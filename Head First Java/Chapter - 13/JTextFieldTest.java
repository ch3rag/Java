import javax.swing.*;
import java.awt.*;

public class JTextFieldTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		frame.setContentPane(panel);
		JTextArea text = new JTextArea(10, 20);
		
		JScrollPane scroller = new JScrollPane(text);
		text.setLineWrap(true);

		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroller);
		//ADD SCROLLER NOT TEXTFIELD!
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
