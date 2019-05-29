package test;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NoImage {
    public NoImage(){
        JFrame frame = new JFrame();
        //set fullscreen size
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        frame.setSize(xsize, ysize);
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setVisible(true);
 
        frame.getContentPane().setBackground(Color.BLACK);
        JLabel label = new JLabel();
        //show image
        frame.add(label);
        //set center position
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
    }
}
