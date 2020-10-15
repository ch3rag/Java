import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	int stepSize = 10;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		System.out.println(width + " " + height);
		int x = width;
		int y = 0;
		while (x >= 0 && y <= height) {
			g.drawLine(0, 0, x, y);
			x -= stepSize;
			y += stepSize;
		}

		x = 0;
		y = height;
		while (x <= width && y >= 0) {
			x += stepSize;
			y -= stepSize;
			g.drawLine(width, height, x, y);
		}
		x = stepSize;
		y = stepSize;
		while (x <= width && y <= height) {
			g.drawLine(width, 0, x, y);
			x += stepSize;
			y += stepSize;
		}

		x = 0;
		y = 0;
		while (x <= width && y <= height) {
			g.drawLine(0, height, x, y);
			x += stepSize;
			y += stepSize;
		}


	}
}
