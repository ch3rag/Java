import javax.swing.*;
import java.awt.*;



class BorderLayoutTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton north = new JButton("NORTH");
		JButton south = new JButton("SOUTH");
		JButton east = new JButton("EAST");
		JButton west = new JButton("WEST");
		JButton center = new JButton("CENTER");
	
		frame.getContentPane().add(BorderLayout.NORTH, north);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.CENTER, center);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}
}
