import javax.swing.*;
import java.awt.event.*;

public class SwingFive extends JFrame {

    JButton button;
    String info = "";
    JList gameList, colorList;
    DefaultListModel defListModel = new DefaultListModel();
    JScrollPane scroll;

    public static void main(String[] args) {
        new SwingFive();
    }

    SwingFive() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Swing Five");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JPanel panel = new JPanel();

        String[] games = {"Grand Theft Auto", "The Sims", "18 Wheels Of Steel", "Age Of Empire", "RimWorld"};
        
        // Creating List Boxes
        // Ugly Method
        gameList = new JList(games);
        gameList.setFixedCellHeight(30);
        gameList.setFixedCellWidth(150);
        gameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //gameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //gameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        // Methods:
            // int      <- getSelectedIndex();
            // int[]    <- getSelectedIndexes();
            // String   <- getSelectedValue();
            // String[] <- getSelectedValues();
            // Boolean  <- isSelectedIndex(int);

        // Method 2
        // More Flexible
        String [] colors = {"Red", "Green", "Blue", "Cyan", "Gray"};

        for(String color : colors) {
            defListModel.addElement(color);
        }

        defListModel.add(2, "Black");

        colorList = new JList(defListModel);
        colorList.setVisibleRowCount(4);

        scroll = new JScrollPane(colorList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        colorList.setFixedCellHeight(30);
        colorList.setFixedCellWidth(150);


        button = new JButton("Get Answer");
        
        button.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(defListModel.contains("Black"))
                    info += "Black Is Here\n";
                if(!defListModel.isEmpty())
                    info += "List isn't empty\n";
                
                info += "Number of Elements: " + defListModel.size() + "\n";
                info += "Last Element: " + defListModel.lastElement() + "\n";
                info += "First Element: " + defListModel.firstElement() + "\n";
                info += "2nd Element: " + defListModel.get(1) + "\n";
                
                defListModel.remove(0);
                defListModel.removeElement("Black");

                Object[] arrayOfList = defListModel.toArray();

                for(Object color : arrayOfList) {
                    info += color + "\n";
                }


                JOptionPane.showMessageDialog(SwingFive.this, info, "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(scroll);
        panel.add(gameList);
        panel.add(button);
        
        this.add(panel);
        this.setVisible(true);
    }
}

