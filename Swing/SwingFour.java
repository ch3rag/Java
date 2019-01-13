import javax.swing.*;
import java.awt.event.*;

public class SwingFour extends JFrame {
    JComboBox combo;
    JButton button;
    String info = "";
    public static void main(String[] args) {
        new SwingFour();
    }

    SwingFour() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Swing Four");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel();

        String[] gameList = {"Grand Theft Auto", "The Sims", "18 Wheels Of Steel", "Age Of Empire", "RimWorld"};
        
        // Creating Combo Boxes
        combo = new JComboBox(gameList);
        
        // Adding Items
        combo.addItem("Tomb Raider");
        combo.insertItemAt("Don't Starve", 1);
        
        combo.setMaximumRowCount(3);

        combo.removeItem("The Sims");
        combo.removeItemAt(1);

        button = new JButton("Get Answer");
        
        button.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                combo.setEditable(true);
                info += "Item at 0: " + combo.getItemAt(0) + "\n";
                info += "Number of games: " + combo.getItemCount() + "\n";
                info += "Selected Index: " + combo.getSelectedIndex() + "\n";
                info += "Selected Item: " + combo.getSelectedItem() + "\n";
                info += "Is Editable?: " + combo.isEditable() + "\n";
                JOptionPane.showMessageDialog(SwingFour.this, info, "Information", JOptionPane.INFORMATION_MESSAGE);
                info = "";
            }
        });

        panel.add(combo);
        panel.add(button);
        
        this.add(panel);
        this.setVisible(true);
    }
}

