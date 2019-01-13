import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class TestGridBagLayout extends JFrame {
    public static void main(String[] args) {
        new TestGridBagLayout();
    }

    TestGridBagLayout() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton buttonOne = new JButton("Button 1");
        JButton buttonTwo = new JButton("Button 2");
        JButton buttonThree = new JButton("Button 3");
        JButton buttonFour = new JButton("Button 4");
        JButton buttonFive = new JButton("Button 5");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 4;
        constraints.ipady = 100;
        constraints.fill = GridBagConstraints.VERTICAL;
        panel.add(buttonOne, constraints);
        constraints.weighty = 0.5;
        constraints.ipady = 0;
        constraints.fill = 0;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        panel.add(buttonTwo, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(buttonThree, constraints);
        constraints.ipady = 100;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 4;
        constraints.fill = GridBagConstraints.VERTICAL;
        panel.add(buttonFour, constraints);
        
        this.add(panel);
        this.setTitle("Grid Bag Layout Test");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}