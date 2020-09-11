import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Aquarium extends Frame implements Runnable {
    
    MediaTracker tracker;
    Image backgroundImage, bufferImage;
    Image [] fishImages = new Image[2];
    Graphics bufferGraphics;
    Thread thread;
    Vector <Fish> fishes = new Vector <Fish> ();
    int numFish = 12;
    int sleepTime = 110;
    boolean running = true;

    public static void main(String [] args) {
        new Aquarium();
    }

    Aquarium() {
        this.setTitle("The Aquarium");
        tracker = new MediaTracker(this);    
        
        // LOADING IMAGES
        Toolkit tk = Toolkit.getDefaultToolkit();
        fishImages[0] = tk.getImage("./fish1.gif");
        fishImages[1] = tk.getImage("./fish2.gif");
        backgroundImage = tk.getImage("./bubbles.gif");
        
        // TRACK IT WITH THE MEDIA TRACKER
        tracker.addImage(fishImages[0], 0);
        tracker.addImage(fishImages[1], 0);
        tracker.addImage(backgroundImage, 0);

        // WAIT FOR IMAGES TO LOAD
        try {
            tracker.waitForID(0);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }

        // IMAGE LOADING FAILED
        if(tracker.isErrorID(0)) {
            System.exit(0);
        }
        
        
        this.setSize(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
        this.setResizable(false);
        this.setVisible(true);

        bufferImage = this.createImage(getSize().width, getSize().height);
        bufferGraphics = bufferImage.getGraphics();

        thread = new Thread(this);
        thread.start();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                running = false;
                System.exit(0);
            }
        });

        
    }

    public void run() {
        Insets ins = this.getInsets();
        Rectangle edges = new Rectangle(ins.left, ins.top, getSize().width - (ins.left + ins.right), getSize().height - (ins.top + ins.bottom));
        for(int i = 0 ; i < numFish ; i++) {
            fishes.add(new Fish(fishImages[0], fishImages[1], edges, this));
            try {
                Thread.sleep(20);
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        while(running) {
            for(int i = 0 ; i < numFish ; i++) {
                Fish f = fishes.get(i);
                f.swim();
            }
            try {
                Thread.sleep(sleepTime);
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
            repaint();
        }
    }

    public void update(Graphics g) {
        bufferGraphics.drawImage(backgroundImage, 0, 0, null);
        for(int i = 0 ; i < numFish ; i++) {
            fishes.get(i).drawFishImage(bufferGraphics);
        }
        g.drawImage(bufferImage, 0, 0, null);
    }
}

class Fish {
    Component tank;
    Image image1;
    Image image2;
    Point velocity;
    Point position;
    Rectangle edges;
    Random rand;

    Fish(Image i1, Image i2, Rectangle e, Component t) {
        this.tank = t;
        this.image1 = i1;
        this.image2 = i2;
        this.edges = e;
        this.position = new Point((int)(-150 + Math.random() * 300), (int)(-50 + Math.random() * 100));
        this.velocity = new Point((int)(Math.random() * 8), (int)(Math.random() * 8));
    }

    public void swim() {
        if(Math.random() * 7 <= 1) {
            velocity.x += -4 +  Math.random() * 8;
            velocity.x = Math.min(velocity.x, 8);
            velocity.x = Math.max(velocity.x, -8);
            
            velocity.y += -4 +  Math.random() * 8;
            velocity.y = Math.min(velocity.y, 8);
            velocity.y = Math.max(velocity.y, -8);
        }

        position.x += velocity.x;
        position.y += velocity.y;

        if(position.x < edges.x) {
            position.x = edges.x;
            velocity.x *= -1;
        } else if((position.x + image1.getWidth(null)) > (edges.x + edges.width)) {
            position.x = edges.x + edges.width - image1.getWidth(null);
            velocity.x *= -1;
        } 

        if(position.y < edges.y) {
            position.y = edges.y;
            velocity.y *= -1;
        } else if((position.y + image1.getHeight(null)) > (edges.y + edges.height)) {
            position.y = edges.y + edges.height - image1.getHeight(null);
            velocity.y *= -1;
        } 
    }

    public void drawFishImage(Graphics g) {
        if(velocity.x < 0) {
            g.drawImage(image1, position.x, position.y, null);
        } else {
            g.drawImage(image2, position.x, position.y, null);
        }
    }
}