import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBoxTest {
	JCheckBox check;
	public static void main(String[] args) {
		JCheckBoxTest gui = new JCheckBoxTest();
		gui.go();
	}

	void go() {
		JFrame frame = new JFrame();
		check = new JCheckBox("Goes to 11");
		
		// check.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent ae) {
		// 		System.out.println("la");
		// 	}
		// });

		check.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				boolean onOrOff = check.isSelected();
				System.out.println("Check Box is : " + onOrOff);

			}
		});
		frame.getContentPane().add(BorderLayout.SOUTH,check);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
