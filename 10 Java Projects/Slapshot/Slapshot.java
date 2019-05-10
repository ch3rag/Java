import java.awt.*;
import java.awt.event.*;

public class Splashshot extends Frame implements ActionListener, Runnable, MouseListener, MouseMotionListener {
    MenuBar menubar;
    Menu menu1;
    MenuItem menuItem0, menuItem1, menuItem2, menuItem3;
    OkCancelDialog textDialog;
    

    Splashshot() {
        menubar = new MenuBar();
        menu1 = new Menu("File");
        menuItem0 = new MenuItem("Start");
        menu1.add(menuItem0);
        menuItem0.addActionListener(this);

        menuItem1 = new MenuItem("End");
        menu1.add(menuItem1);
        menuItem1.addActionListener(this);

        menuItem2 = new MenuItem("Set Speed...");
        menu1.add(menuItem2);
        menuItem2.addActionListener(this);

        menuItem3 = new MenuItem("Exit");
        menu1.add(menuItem3);
        menuItem3.addActionListener(this);

        menubar.add(menu1);
        this.setMenuBar(menu1);

    }
}