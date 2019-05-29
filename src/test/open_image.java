package test;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class open_image{
    
    public open_image(String filePath) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(filePath);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(filePath));
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                //set fullscreen size
                initComponents();
                Toolkit tk = Toolkit.getDefaultToolkit();
                int xsize = (int) tk.getScreenSize().getWidth();
                int ysize = (int) tk.getScreenSize().getHeight();
                frame.setSize(xsize, ysize);
                frame.setUndecorated(true);
                frame.setAlwaysOnTop(true);
                frame.setResizable(false);
                frame.setVisible(true);
                
                //resize image sama dengan ukuran y
                Image thisimage = img.getScaledInstance(ysize, ysize, java.awt.Image.SCALE_SMOOTH);
                
                frame.getContentPane().setBackground(Color.BLACK);
                JLabel label = new JLabel();
                //show image
                frame.add(label);
                label.setIcon(new ImageIcon(thisimage));
                //set center position
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
             }

            private void initComponents() {
                return;
            }
        });
        
    }

}
