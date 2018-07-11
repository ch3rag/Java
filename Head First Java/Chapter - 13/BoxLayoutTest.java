import javax.swing.*;
import java.awt.*;

public class BoxLayoutTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton button = new JButton("Shock Me");
		JButton button2 = new JButton("Bliss");
		JButton button3 = new JButton("Huh?");
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);



	}


}
