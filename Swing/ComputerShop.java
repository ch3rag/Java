import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class ComputerShop extends JFrame {

    public static void main(String[] args) {
        new ComputerShop();
    }

    ComputerShop() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel title = new JLabel("Chirag Computer Store");

        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField("", 30);

        JLabel phoneLabel = new JLabel("Phone");
        JTextField phone = new JTextField("", 30);

        JLabel sex = new JLabel("Sex");
        JCheckBox male = new JCheckBox("Male");
        JCheckBox female = new JCheckBox("Female");

        JLabel addressLabel = new JLabel("Address");
        JTextArea address = new JTextArea(5, 30);
        JScrollPane scroll = new JScrollPane(address, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        JList items, added;
        DefaultListModel defListModelItems = new DefaultListModel();
        DefaultListModel defListModelAdded = new DefaultListModel();
        JButton add = new JButton(">");
        JButton remove = new JButton("<");
        

        String[] itemList = {"GTX 1080", "PSU 500W", "Intel Core i7", "AMD Athlon X2", "Segate HDD 1TB", "Grand Theft Auto"};

        for(String item : itemList) {
            defListModelItems.addElement(item);
        }

        items = new JList(defListModelItems);
        added = new JList(defListModelAdded);
        added.setVisibleRowCount(5);
        added.setFixedCellHeight(30);
        added.setFixedCellWidth(200);

        items.setVisibleRowCount(5);
        items.setFixedCellWidth(200);
        items.setFixedCellHeight(30);

        JScrollPane scrollForItems = new JScrollPane(items, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scrollForAdded = new JScrollPane(added, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(male);
        sexGroup.add(female);
        JPanel sexPanel = new JPanel();
        sexPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sexPanel.add(male);
        sexPanel.add(female);

        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        panel.add(title, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(nameLabel, constraints);


        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridwidth = 3;
        panel.add(name, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(phoneLabel, constraints);


        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(phone, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;

        panel.add(sex, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(sexPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(addressLabel, constraints);


        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(scroll, constraints);


        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(scrollForItems, constraints);


        // constraints.gridx = 2;
        // constraints.gridy = 5;
        // constraints.gridwidth = 1;
        // constraints.gridheight = 2;
        // constraints.anchor = GridBagConstraints.CENTER;
        // panel.add(scrollForAdded, constraints);

        // constraints.gridx = 1;
        // constraints.gridy = 5;
        // constraints.gridwidth = 1;
        // constraints.gridheight = 1;
        // constraints.anchor = GridBagConstraints.CENTER;
        // panel.add(add, constraints);

        // constraints.gridx = 2;
        // constraints.gridy = 6;
        // constraints.gridwidth = 1;
        // constraints.gridheight = 1;
        // constraints.anchor = GridBagConstraints.CENTER;
        // panel.add(remove, constraints);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Chirag Computer Store");
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}

