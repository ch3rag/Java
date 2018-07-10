import javax.swing.*;
import java.awt.*;


public class BallAnimation {

	JFrame frame;
	int x = 0;
	int y = 0;

	public static void main(String[] args) {

		BallAnimation animation = new BallAnimation();
		animation.go();


	}

	void go() {

		frame = new JFrame();
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		for(int i = 0 ; i < 250 ; i++) {
			drawPanel.repaint();
			x++;
			y++;
			try {
				Thread.sleep(10);
			} catch (Exception e) { }
		}

	}


	class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {

			Graphics2D g2d = (Graphics2D) g;

			g2d.fillRect(0,0, this.getWidth(), this.getHeight());
			g2d.setPaint(Color.orange);
			g2d.fillOval(x,y, 50, 50);

		}

	}
}

