import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;


public class SwingThree extends JFrame {
    JButton button;
    JLabel lb1, lb2, lb3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeperator;
    JRadioButton addNums, subNums, multNums, divNums;
    JSlider howManyTimes;
    double num1, num2, total;

    public static void main(String[] args) {
        new SwingThree();
    }

    SwingThree() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Swing Three");
        JPanel panel = new JPanel();
        button = new JButton("Calculate");
        button.addActionListener(new ListenerForButton());
        
        lb1 = new JLabel("Number 1");
        lb2 = new JLabel("Number 2");
        textField1 = new JTextField("", 5);
        textField2 = new JTextField("", 5);
        dollarSign = new JCheckBox("Dollars");
        commaSeperator  = new JCheckBox("Commas");
        addNums = new JRadioButton("ADD");
        subNums = new JRadioButton("SUB");
        multNums = new JRadioButton("MULT");
        divNums = new JRadioButton("DIV");
        
        ButtonGroup operation = new ButtonGroup();
        operation.add(addNums);
        operation.add(subNums);
        operation.add(multNums);
        operation.add(divNums);
        
        JPanel operationPanel = new JPanel();
        Border operationBorder = BorderFactory.createTitledBorder("Operation");
        operationPanel.setBorder(operationBorder);

        operationPanel.add(addNums);
        operationPanel.add(subNums);
        operationPanel.add(divNums);
        operationPanel.add(multNums);
        addNums.setSelected(true);

        lb3 = new JLabel("Perform How Many Times");

        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        howManyTimes.addChangeListener(new ListenerForSlider());

        panel.add(lb1);
        panel.add(textField1);
        panel.add(lb2);
        panel.add(textField2);
        panel.add(button);
        panel.add(dollarSign);
        panel.add(commaSeperator, true);
        panel.add(operationPanel);
        panel.add(lb3);
        panel.add(howManyTimes);
        this.add(panel);
        this.setVisible(true);

        textField1.requestFocus();
        
    }

    private class ListenerForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == button) {
                try {
                    num1 = Double.parseDouble(textField1.getText());
                    num2 = Double.parseDouble(textField2.getText());
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingThree.this, "Please Enter Numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if(addNums.isSelected()) {
                    total = addNumbers(num1, num2, howManyTimes.getValue());
                } else if(subNums.isSelected()) {
                    total = subNumbers(num1, num2, howManyTimes.getValue());
                } else if(multNums.isSelected()) {
                    total = multNumbers(num1, num2, howManyTimes.getValue());
                } else {
                    total = divNumbers(num1, num2, howManyTimes.getValue());
                }

                if(dollarSign.isSelected()) {
                    NumberFormat numFor = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(SwingThree.this, numFor.format(total), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } else if(commaSeperator.isSelected()) {
                    NumberFormat numFor = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(SwingThree.this, numFor.format(total), "Solution", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(SwingThree.this, total, "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } 
    }

    private class ListenerForSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            if(ce.getSource() == howManyTimes) {
                lb3.setText("Perform How Many Times? " + howManyTimes.getValue());
            }
        }
    }

    public static double addNumbers(double a, double b, int f) {
        double total = 0;
        int i = 0;
        while(i < f)  {
            total += (a + b);
            i++;
        }
        return total;
    }
    
    public static double subNumbers(double a, double b, int f) {
        double total = 0;
        int i = 0;
        while(i < f)  {
            total += (a - b);
            i++;
        }
        return total;
    }
    
    public static double multNumbers(double a, double b, int f) {
        double total = 0;
        int i = 0;
        while(i < f)  {
            total += (a * b);
            i++;
        }
        return total;
    }
    
    public static double divNumbers(double a, double b, int f) {
        double total = 0;
        int i = 0;
        while(i < f)  {
            total += (a / b);
            i++;
        }
        return total;
    }
}
