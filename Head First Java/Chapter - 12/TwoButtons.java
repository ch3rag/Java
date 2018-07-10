import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {
	
	JFrame frame ;
	JLabel label;

	public static void main(String[] args) {

		TwoButtons gui = new TwoButtons();
		gui.go();

	}

	public void go() {

		frame = new JFrame();

		JButton colorButton = new JButton("New Color");
		colorButton.addActionListener(new ColorListener());

		JButton labelButton = new JButton("Label");
		labelButton.addActionListener(new LabelListener());

		label = new JLabel("I'am a label!");

		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, new MyDrawPanel());
		frame.getContentPane().add(BorderLayout.EAST , labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);

	}

	class ColorListener implements ActionListener  {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
		}
	}
} 

class MyDrawPanel extends JPanel {

	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.fillRect(0,0, this.getWidth(), this.getHeight());

		int r1 = (int)(Math.random() * 255);
		int g1 = (int)(Math.random() * 255);
		int b1 = (int)(Math.random() * 255);

		Color c1 = new Color(r1, g1, b1);

		int r2 = (int)(Math.random() * 255);
		int g2 = (int)(Math.random() * 255);
		int b2 = (int)(Math.random() * 255);

		Color c2 = new Color(r2, g2, b2);

		//System.out.println(c1.toString() + " " + c2.toString());

		GradientPaint gradient = new GradientPaint(100,100, c1, 150, 150, c2);
		g2d.setPaint(gradient);

		g2d.fillOval(100,100, 80, 80);

	}

}


