import javax.swing.*;
import java.awt.*;


public class GradientTest {
	public static void main(String[] args) {

		JFrame frame = new JFrame();

		frame.getContentPane().add(new MyPanel());

		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	} 
}


class MyPanel extends JPanel {

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gradient = new GradientPaint(70,70, Color.blue, 150, 150, Color.orange);
		g2d.setPaint(gradient);

		g2d.fillOval(100,100, 50, 50);
	}
}
