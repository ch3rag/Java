import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class TextBoxTest {

	JFrame frame;
	JPanel panel;
	JLabel nameLabel;
	JButton submit;
	JTextField nameField;

	public static void main(String[] args) {

		TextBoxTest gui = new TextBoxTest();
		gui.go();
	}

	void go() {

		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(Color.darkGray);
		frame.setContentPane(panel);

		nameLabel = new JLabel("Name:");
		nameLabel.setForeground(Color.white);
		nameField = new JTextField(20);
		nameField.setText("Enter Your Name..");
		nameField.addMouseListener(new TextFieldListener());
		submit = new JButton("Submit");
		submit.addActionListener(new SubmitListener());
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(submit);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			System.out.println(nameField.getText());
		}
	}

	class TextFieldListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			nameField.setText("");
		}
	}
}
