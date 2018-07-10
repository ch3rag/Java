import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
	
	JFrame frame ;

	public static void main(String[] args) {

		SimpleGui3C gui = new SimpleGui3C();
		gui.go();

	}

	public void go() {

		frame = new JFrame();

		JButton button = new JButton("Change Color!");
		button.addActionListener(this);

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, new MyDrawPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}
} 

class MyDrawPanel extends JPanel {

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


