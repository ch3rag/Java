import java.awt.event.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.text.*;
import java.io.*;

class ListBox {
    JScrollPane scroll;
    JList list;
    DefaultListModel defListModel;
    ListBox(String[] items, int rowCount, int fixedWidth, int fixedHeight) {
        defListModel = new DefaultListModel();
        for(String item : items) {
            defListModel.addElement(item);
        }
        list = new JList(defListModel);
        list.setVisibleRowCount(rowCount);
        list.setFixedCellWidth(fixedWidth);
        list.setFixedCellHeight(fixedHeight);
        scroll = SwingHelper.addScrolls(list);        
    }
}
class SwingHelper {
    static JScrollPane addScrolls(JTextArea area) {
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }

    static JScrollPane addScrolls(JList list) {
        JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }
}

class CheckBoxGroup {
    JPanel panel;
    ButtonGroup group;

    CheckBoxGroup() {
        panel = new JPanel();
        group = new ButtonGroup();
    }

    CheckBoxGroup addCheckBox(JCheckBox box) {
        group.add(box);
        panel.add(box);
        return this;
    }
}

class Form  {
    JPanel panel;
    GridBagConstraints constraints;
    int gx = 0;
    int gy = 0;

    Form() {
        panel = new JPanel();
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(6, 6, 6, 6);
        panel.setLayout(new GridBagLayout());
    }

    void addTextField(JLabel label, JTextField field) {
        constraints.gridx = gx;
        constraints.gridy = gy;
        panel.add(label, constraints);
        gx += 1;
        constraints.gridx = gx;
        panel.add(field, constraints);
        gy += 1;
        gx = 0;
    }

    void addTextArea(JLabel label, JScrollPane field) {
        constraints.gridx = gx;
        constraints.gridy = gy;
        panel.add(label, constraints);
        gx += 1;
        constraints.gridx = gx;
        panel.add(field, constraints);
        gy += 1;
        gx = 0;
    }

    void addPanel(JLabel label, JPanel jpanel) {
        constraints.gridx = gx;
        constraints.gridy = gy;
        panel.add(label, constraints);
        gx += 1;
        constraints.gridx = gx;
        panel.add(jpanel, constraints);
        gy += 1;
        gx = 0;
    }
}

class TextField {
    JPanel panel;
    JLabel label;
    JTextField field;
    
    TextField(String labelText, int size) {
        panel = new JPanel();
        label = new JLabel(labelText);
        field = new JTextField(size);
        panel.add(label);
        panel.add(field);
    }
}

class TextArea {
    JPanel panel;
    JLabel label;
    JTextArea textArea;

    TextArea(String labelText, int rows, int cols) {
        panel = new JPanel();
        label = new JLabel(labelText);
        textArea = new JTextArea("", rows, cols);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(label);
        panel.add(scroll);
    }
}

public class SwingSix extends JFrame {
    JTextField custName = new JTextField(30);
    JTextField phone = new JTextField(30);
    JTextArea address = new JTextArea("", 5, 30);    
    JCheckBox male = new JCheckBox("Male", true);
    JCheckBox female = new JCheckBox("Female");
    ListBox items, added;
    public static void main(String[] args) {
        new SwingSix();
    }

    SwingSix() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel listPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        AbstractDocument doc = (AbstractDocument) phone.getDocument();
        doc.setDocumentFilter(new KeyFilter(10));
        JLabel title = new JLabel("Chirag Computer Store");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        Form form = new Form();
        form.addTextField(new JLabel("Name:"), custName);
       
        form.addTextField(new JLabel("Phone:"), phone);
        
        form.addTextArea(new JLabel("Address:"), SwingHelper.addScrolls(address));
        
        form.addPanel(new JLabel("Sex:"), new CheckBoxGroup().addCheckBox(male).addCheckBox(female).panel);
        
        String[] itemList = {"GTX 1080", "PSU 500W", "Intel Core i7", "AMD Athlon X2", "Segate HDD 1TB", "Grand Theft Auto"};
        items = new ListBox(itemList, 5, 150, 30);
        added = new ListBox(new String[0], 5, 150, 30);
        items.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        added.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton addItem = new JButton(">");
        JButton removeItem = new JButton("<");
        
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(items.list.getSelectedIndex() > -1 && !added.defListModel.contains(items.list.getSelectedValue()))  {
                    added.defListModel.addElement(items.list.getSelectedValue());
                }  
            }
        });

        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(added.list.getSelectedIndex() > -1) {
                    added.defListModel.remove(added.list.getSelectedIndex());
                }
            }
        });


        listPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        listPanel.add(items.scroll, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.PAGE_END;
        listPanel.add(addItem, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.PAGE_START;
        listPanel.add(removeItem, constraints);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        listPanel.add(added.scroll, constraints);

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        JButton clear = new JButton("Clear");
        JButton viewLast = new JButton("Last Order");

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { 
                custName.setText("");
                phone.setText("");
                address.setText("");
                added.defListModel.removeAllElements();
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent ae) {
                String sex = male.isSelected() ? "Male" : "Female";
                Order ord = new Order(custName.getText(), phone.getText(), address.getText(), sex, added.defListModel.toString());
                JOptionPane.showMessageDialog(SwingSix.this, ord.toString(), "Order Placed!", JOptionPane.INFORMATION_MESSAGE);
                ord.saveTextFile("order.txt");
                ord.saveObject("ordBinary.dat");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4, 5, 5));
        buttonPanel.add(ok);
        buttonPanel.add(clear);
        buttonPanel.add(viewLast);
        buttonPanel.add(cancel);

        viewLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { 
                Order lastOrder = Order.loadOrder("ordBinary.dat");
                JOptionPane.showMessageDialog(SwingSix.this, lastOrder.toString(), "Last Order", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Chirag Computer Store");
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(form.panel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(listPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private class KeyFilter extends DocumentFilter {
        
        private int maxLen;

        KeyFilter(int maxLen) {
            this.maxLen = maxLen;
        }
        @Override
        public void insertString(FilterBypass fb, int offset, String str, AttributeSet as) throws BadLocationException {
            if(fb.getDocument().getLength() < maxLen) {
                fb.insertString(offset, str.replaceAll("[^0-9]", ""), as);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int len, String str, AttributeSet as) throws BadLocationException  {
            if(fb.getDocument().getLength() < maxLen) {
                fb.replace(offset, len, str.replaceAll("[^0-9]", ""), as);
            }
        }
    }

}

class Order implements Serializable {
    private String name;
    private String phone;
    private String address;
    private String sex;
    private String orders;
    Order(String name, String phone, String address, String sex, String orders) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.orders = orders;
    }

    public void saveTextFile(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
            bw.write(this.toString());
            bw.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveObject(String fileName) {
        try {
            FileOutputStream fs = new FileOutputStream(new File(fileName));
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(this);
            os.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public String toString() {
        String info = "";
        info += "Name: " + name + "\n";
        info += "Phone: " + phone + "\n";
        info += "Address: " + address + "\n";
        info += "Sex: " + sex + "\n";
        info += "Orders: " + orders + "\n";
        return info;
    }

    static Order loadOrder(String fileName) {
        Order ord = null;
        try {
            FileInputStream fs = new FileInputStream(new File(fileName));
            ObjectInputStream os = new ObjectInputStream(fs);
            ord = (Order) os.readObject();
            return ord;
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return ord;
    }
}