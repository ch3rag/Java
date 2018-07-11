import javax.swing.*;
import java.awt.*;



public class ButtonFont {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("Click Me");
		Font bigFont = new Font("serif", Font.BOLD, 28);
		button.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.NORTH, button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}
}
