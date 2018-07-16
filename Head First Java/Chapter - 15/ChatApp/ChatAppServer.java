import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.*;


public class ChatAppServer {

	private ServerSocket sockServer;
	private JTextArea log;
	private ArrayList <PrintWriter> outStreams;


	private void startServer() {

		outStreams = new ArrayList <PrintWriter> ();

		try {
			sockServer = new ServerSocket(4777);
			log.append("Server started at port : " + sockServer.getLocalPort());

			while(true) {
      
				Socket client = sockServer.accept();
				PrintWriter writer = new PrintWriter(client.getOutputStream());
				outStreams.add(writer);
				Thread clientThread = new Thread(new ClientHandler(client));
				clientThread.start();
				log.append("\nNew client connected!");
			}
		} catch(IOException ex) {
			log.append("Cannot Start Server!");
		}

	}

	private void setUpGUI() {

		JFrame frame = new JFrame("Let's Chat Server");
		log = new JTextArea(20,30);
		JScrollPane qScroller = new JScrollPane(log);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		log.setLineWrap(true);
		log.setWrapStyleWord(true);	
		log.setEditable(false);
		DefaultCaret caret = (DefaultCaret) log.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JButton clearLogButton = new JButton("Clear Log");
		JLabel logLabel = new JLabel("Server Log");
		frame.getContentPane().add(BorderLayout.NORTH, logLabel);
		frame.getContentPane().add(BorderLayout.CENTER, qScroller);
		frame.getContentPane().add(BorderLayout.SOUTH, clearLogButton);

		clearLogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				log.setText("");
			}
		});


		frame.setSize(400, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private class ClientHandler implements Runnable {

		Socket clientSocket;
		BufferedReader reader;

		ClientHandler(Socket socket) {
			try {
				clientSocket = socket;
				reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {
			String message;
			try {
				while((message = reader.readLine()) != null) {
					log.append("\n" + message);
					broadcast(message);
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ChatAppServer instance = new ChatAppServer();
		instance.setUpGUI();
		instance.startServer();
	}

	private void broadcast(String message) {
		Iterator <PrintWriter> i = outStreams.iterator();
		
		while(i.hasNext()) {
			PrintWriter writer = i.next();
			try {
				writer.println(message);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
