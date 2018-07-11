import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JTextFieldTest2 {
	
	JTextArea text;

	public static void main(String[] args) {

		JTextFieldTest2 gui = new JTextFieldTest2();
		gui.go();

	}

	public void go() {
		
		JFrame frame = new JFrame();
		text = new JTextArea(10, 20);
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		frame.getContentPane().add(BorderLayout.CENTER, scroller);
		
		JButton button = new JButton("Click Me");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				text.append("Button Clicked! \n");
			}
		});

		frame.getContentPane().add(BorderLayout.SOUTH, button);

		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
