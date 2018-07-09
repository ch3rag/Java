import javax.swing.*;
import java.awt.*;

public class GraphicsTest {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		MyDrawPanel panel = new MyDrawPanel();

		frame.getContentPane().add(panel);

		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MyDrawPanel extends JPanel {

	public void paintComponent(Graphics g) {

		g.setColor(Color.orange);

		g.fillRect(30,30, 100, 100);

		Image image = new ImageIcon("cat.jpg").getImage();

		g.drawImage(image, 200,30, this);
	}
}
