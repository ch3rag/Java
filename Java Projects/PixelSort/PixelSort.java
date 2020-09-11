import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Collection;
import java.util.Comparator;
import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class PixelSort extends JFrame {

    JPanel imagePanel = new JPanel();
    JLabel imageLabel = new JLabel();
    BufferedImage image, tempImage;

    public static void main(String[] args) {
        new PixelSort();
    }

    PixelSort() {

        JButton browse = new JButton("Browse..");
        browse.addActionListener(new ActionListener() {

            // DISPLAY A FILE CHOOSER AND SELECT AN IMAGE
            @Override
            public void actionPerformed(ActionEvent ae) {
                // CREATE A FILE CHOOSER
                JFileChooser fileDialog = new JFileChooser();
                int ret = fileDialog.showOpenDialog(null);
                if (ret == JFileChooser.CANCEL_OPTION) {
                    System.out.println("FILE BOX WAS CANCELLED");
                } else {

                    // EXTRACT THE FILE EXTENSION AND CHECK IF IT IS AN IMAGE

                    String fileName = fileDialog.getSelectedFile().getName();
                    fileName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                    System.out.println(fileName);

                    if (!fileName.equals("jpg")) {
                        System.out.println("This type of file is not supported");
                    } else {
                        // LOAD THE IMAGE ONTO THE PANEL AND SORT IT
                        loadImage(fileDialog.getSelectedFile().getAbsolutePath());
                    }
                }
            }
        });

        JButton sortButton = new JButton("Sort IT!");

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sortImage();
            }
        });

        imagePanel.add(imageLabel);

        this.add(imagePanel);
        this.add(browse);
        this.add(sortButton);

        // FRAME PROPERTIES
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Pixel Sort");
        this.setResizable(false);
        this.setVisible(true);
    }

    void loadImage(String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        imageLabel.setIcon(imageIcon);
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sortImage() {
        if (image == null) {
            System.out.println("No Image Loaded");
        } else {
            int imageHeight = image.getHeight(null);
            int imageWidth = image.getWidth(null);

            // CREATE A NEW IMAGE WITH SAME WIDTH AND HEIGHT
            tempImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
            Color[] colors = new Color[imageHeight * imageWidth];

            for (int y = 0; y < imageHeight; y++) {
                for (int x = 0; x < imageWidth; x++) {
                    colors[y * imageWidth + x] = new Color(image.getRGB(x, y));
                }
            }
            Arrays.sort(colors, new Comparator<Color>() {
                @Override
                public int compare(Color a, Color b) {
                    float[] aHSB = Color.RGBtoHSB(a.getRed(), a.getGreen(), a.getBlue(), null);
                    float[] bHSB = Color.RGBtoHSB(b.getRed(), b.getGreen(), b.getBlue(), null);
                    float diff = (aHSB[0] - bHSB[0]);
                    if (diff < 0) {
                        return -1;
                    } else if (diff > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            for (int y = 0; y < imageHeight; y++) {
                for (int x = 0; x < imageWidth; x++) {
                    tempImage.setRGB(x, y, colors[y * imageWidth + x].getRGB());
                }
            }

            ImageIcon imageIcon = new ImageIcon(tempImage);
            imageLabel.setIcon(imageIcon);

        }
    }
}