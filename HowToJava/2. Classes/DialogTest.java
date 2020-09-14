import javax.swing.JOptionPane;

public class DialogTest {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog(null, "What is your name?");
		JOptionPane.showMessageDialog(null, String.format("Welcome %s, to the java programming!", name));
		int a = Integer.parseInt(JOptionPane.showInputDialog(null, "First Number"));
		int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Second Number"));
		JOptionPane.showMessageDialog(null, String.format("Sum: %d", a + b));
	}
} 
