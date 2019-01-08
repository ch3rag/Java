import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Canvas extends JFrame {
    private int width;
    private int height;
    private JFrame frame;
    private JPanel panel;
    private Color fillColor;
    private Color strokeColor;
    private Graphics pen;
    private Container surface;

    Canvas(int w, int h) {
        this.width = w;
        this.height = h;
        this.frame = new JFrame();
        this.panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
        surface = frame.getContentPane();
        pen = pael.getGraphics();
    } 

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public void setBackground(int r, int g, int b) {
        surface.setBackground(new Color(r, g, b));
    }

    public void setFill(int r, int g, int b) {
        fillColor = new Color(r, g, b);
    }

    public void setStroke(int r, int g, int b) {
        strokeColor = new Color(r, b, b);   
    }

    public void ellipse(int x, int y, int w, int h) {
        pen.setColor(fillColor);
        pen.fillOval(x, y, w, h);
        pen.setColor(strokeColor);
        pen.drawOval(x, y, w, h);
        surface.repaint();
    }
}



class GraphicTestDrive {
    public static void main(String [] args) {
        Canvas canvas = new Canvas(800, 600);
        canvas.setBackground(255, 0, 0);
        canvas.setFill(0, 255, 0);
        canvas.ellipse(canvas.getWidth()/2, canvas.getHeight()/2, 50, 50);
    }
}