import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;


public class SwingOne extends JFrame {
    public static void main(String[] args) {
        new SwingOne();
    }

    SwingOne() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // CENTER THE FRAME
        // this.setLocationRelativeTo(null);

        // Manually Center The Frame

        // Toolkit allows us to communicate with OS
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        // Dimension holds width and height of screen
        // getScreeSize() returns size of whole screen
        Dimension dim = tk.getScreenSize();

        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        
        this.setLocation(xPos, yPos);

        // Disable Resizing
        this.setResizable(false);

        // Set Frame Title
        this.setTitle("My First Swing Application");

        JPanel panel = new JPanel();

        JLabel labelOne = new JLabel("Hello Visitor!");

        labelOne.setText("Hello Visitor!!");

        labelOne.setToolTipText("This is tooltip!");

        JButton button = new JButton("Send");

        // Hide Button Border
        // button.setBorderPainted(false);

        // Hide Fill
        // button.setContentAreaFilled(false);

        button.setText("Proceed");

        button.setToolTipText("Doesn't do anything..");

        JTextField textField = new JTextField("Type Here..", 15);
        
        // Set TextField Size

        textField.setColumns(20);    

        textField.setText("Type Here Again...");

        textField.setToolTipText("Type Your Text!!");

        JTextArea textArea = new JTextArea(15, 20);
        textArea.setText("Example Of Text Area\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        int lineCount = textArea.getLineCount();
        textArea.append("Number Of Lines: " + lineCount);

        panel.add(labelOne);
        panel.add(button);
        panel.add(textField);
        panel.add(textArea);
        this.add(panel);

        this.setVisible(true);

        // SETTING FOCUS

        textArea.requestFocus();
    }
}