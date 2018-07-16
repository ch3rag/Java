import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.text.*;


public class ChatAppClient {

	private JFrame frame;
	private String clientName;
	private JTextField nameField;
	private JPanel loginPanel;
	private JPanel mainPanel;
	private JTextArea incoming;
	private JTextField outgoing;
	private JButton sendButton;
	private Socket sock;
	private BufferedReader inStream;
	private PrintWriter outStream;

	public static void main(String[] args) {

		new ChatAppClient().start();
	}

	private void start() {

		frame = new JFrame("Let's Chat!");

		loginPanel = new JPanel();
		JLabel nameLabel = new JLabel("Enter Your Name");
		nameField = new JTextField(15);
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new LoginButtonListener());

		loginPanel.add(nameLabel);
		loginPanel.add(nameField);
		loginPanel.add(loginButton);

 		mainPanel = new JPanel();
 		incoming = new JTextArea(25,30);
 		DefaultCaret caret = (DefaultCaret) incoming.getCaret();
 		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

 		incoming.setEditable(false);
 		incoming.setLineWrap(true);
 		incoming.setWrapStyleWord(true);
 		outgoing = new JTextField(20);
 		JScrollPane qScroller = new JScrollPane(incoming);
 		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 		
 		sendButton = new JButton("Send");
 		sendButton.addMouseListener(new SendButtonListener());
 		JPanel sendPanel = new JPanel();
 		sendPanel.add(outgoing);
 		sendPanel.add(sendButton);

 		mainPanel.add(qScroller);
 		mainPanel.add(sendPanel);

 		frame.getContentPane().add(BorderLayout.CENTER, loginPanel);
		frame.setResizable(false);
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private void setUpConnection() {
		
		try {
			sock = new Socket("127.0.0.1", 4777);
			outStream = new PrintWriter(sock.getOutputStream());
			inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			Thread incomingReader = new Thread(new IncomingReader());
			incomingReader.start();
			incoming.append("Connection Successful!\n");
			outStream.println(clientName + " joined the chat!");
			outStream.flush();
		} catch(IOException ex) {
			incoming.append("Not Connected!\n");
		}
		
	}

	private class LoginButtonListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent me) {
			if(!nameField.getText().equals("")) {
				clientName = nameField.getText();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
				frame.revalidate();
				setUpConnection();
				incoming.append("Welcome! " + clientName + "\n");
			} else {
				nameField.setText("Name can't be empty!");
			}
		}

		@Override
		public void mouseReleased(MouseEvent me) {
			nameField.setText("");
		}
	}

	private class SendButtonListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent me) {
			if(!outgoing.getText().equals("")) {
				try {
					outStream.println(clientName + ": " + outgoing.getText());
					outStream.flush();
					outgoing.setText("");
					outgoing.requestFocus();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private class IncomingReader implements Runnable {

		@Override 
		public void run() {
			String message;
			try {
				while((message = inStream.readLine()) != null) {
					message += "\n";
					incoming.append(message);
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
