import javax.swing.*;
import java.awt.*;

public class GraphicsTest2 {

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

	
		g.fillRect(0,0,this.getWidth(), this.getHeight());

		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);

		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillOval(100,100, 50, 50);
	}

}
