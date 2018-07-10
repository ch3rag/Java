import javax.swing.*;
import java.awt.*;


public class RandomGradientTest {
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

		int r1 = (int)(Math.random() * 255);
		int g1 = (int)(Math.random() * 255);
		int b1 = (int)(Math.random() * 255);

		Color c1 = new Color(r1, g1, b1);

		int r2 = (int)(Math.random() * 255);
		int g2 = (int)(Math.random() * 255);
		int b2 = (int)(Math.random() * 255);

		Color c2 = new Color(r2, g2, b2);

		System.out.println(c1.toString() + " " + c2.toString());

		GradientPaint gradient = new GradientPaint(100,100, c1, 150, 150, c2);
		g2d.setPaint(gradient);

		g2d.fillOval(100,100, 80, 80);
	}
}
