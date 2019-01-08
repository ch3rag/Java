import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;


public class SwingTwo extends JFrame {
    JButton buttonOne;
    JTextField textField;
    JTextArea textArea;    
    int buttonClicked;
    public static void main(String[] args) {
        new SwingTwo();
    }

    SwingTwo() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        //this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        
        textArea = new JTextArea(10, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        buttonOne = new JButton("Click Me!");
        buttonOne.addActionListener(new ButtonListener());

        textField = new JTextField("", 15);
        textField.addKeyListener(new ListenerForKeys());

        panel.add(buttonOne);
        panel.add(scroll);
        panel.add(textField);
        panel.addMouseListener(new ListenerForMouse());
        
        this.addWindowListener(new ListenerForWindow());

        this.add(panel);
        
        this.setTitle("Swing Two");
        this.setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
        this.setVisible(true);

    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == buttonOne) {
                buttonClicked++;
                textArea.append("Button Clicked: " + buttonClicked + " times.\n");
            }
        } 
    }

    private class ListenerForKeys implements KeyListener {
        
        @Override
        public void keyPressed(KeyEvent ke) {
            textArea.append("Key Hit: " + ke.getKeyChar() + "\n");
        }
        
        @Override
        public void keyReleased(KeyEvent ke) {
            
        }

        @Override
        public void keyTyped(KeyEvent ke) {
            
        }
    }

    private class ListenerForWindow implements WindowListener {
        @Override
        public void windowActivated(WindowEvent we) {
            // CALLED WHENEVER THE FRAME IS ACTIVE WINDOW
            textArea.append("Window is active.\n");
        }
        @Override
        public void windowClosed(WindowEvent we) {
            
        }
        @Override
        public void windowClosing(WindowEvent we) {
            textArea.append("Window is not active.\n");
        }
        @Override
        public void windowDeiconified(WindowEvent we) {
            textArea.append("Window is maximized.\n");
        }
        @Override
        public void windowIconified(WindowEvent we) {
            textArea.append("Window is minimized.\n");
        }
        @Override
        public void windowOpened(WindowEvent we) {
            textArea.append("Window created.\n");
        }
        @Override
        public void windowDeactivated(WindowEvent we) {

        }
    }

    private class ListenerForMouse implements MouseListener {
        @Override 
        public void mouseClicked(MouseEvent me) {
            textArea.append("MouseX: " + me.getX() + " MouseY: " + me.getY() + "\n");
            textArea.append("MouseSX: " + me.getXOnScreen() + " MouseSY: " + me.getYOnScreen() + "\n");
            textArea.append("TimeClicked: " + me.getClickCount() + "\n");
        }
        @Override 
        public void mouseEntered(MouseEvent me) {
            
        }
        @Override 
        public void mouseExited(MouseEvent me) {
            
        }
        @Override 
        public void mousePressed(MouseEvent me) {
            
        }
        @Override 
        public void mouseReleased(MouseEvent me) {
            
        }
    }
}

