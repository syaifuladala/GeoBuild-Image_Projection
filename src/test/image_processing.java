package test;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
       

public class image_processing {
    
    
    
    public image_processing() {
        
        String path =  "C:\\Users\\User\\Desktop\\PKM\\test\\src\\test\\mtest.png"; 
        //bufferedimage source
        BufferedImage dsimg = null;
        BufferedImage bsimg = null;
        BufferedImage kasimg = null;
        BufferedImage kisimg = null;
        BufferedImage fiximg = null;
        //file objek
        File f = null;
        
        try {
            f = new File("C:\\Users\\User\\Desktop\\tugu.png");
            dsimg = ImageIO.read(f);
            f = new File("C:\\Users\\User\\Desktop\\tugu.png");
            bsimg = ImageIO.read(f);
            f = new File("C:\\Users\\User\\Desktop\\tugu.png");
            kasimg = ImageIO.read(f);
            f = new File("C:\\Users\\User\\Desktop\\tugu.png");
            kisimg = ImageIO.read(f);
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        
        //sourceimage dimension
        int width = dsimg.getWidth();
        int height = dsimg.getHeight();
        
        //buffer ukuran image
        BufferedImage mimg = new BufferedImage(width*3, height*3, BufferedImage.TYPE_INT_ARGB);
        
        //algoritma
        for (int y=0, yy=height*3-1; y<height; y++, yy--){
            for(int lx=0, mtx=width-1, mdx=width*2-1; lx<width; lx++, mtx++, mdx--){                
                //get pixel
                int p = dsimg.getRGB(lx, y);
                int q = bsimg.getRGB(lx, y);
                int r = kasimg.getRGB(lx, y);
                int s = kisimg.getRGB(lx, y);
                
                //set mirror image
                //depan
                mimg.setRGB(mdx, y, p);
                //belakang
                mimg.setRGB(mtx, yy, q);
                //kanan
                mimg.setRGB(yy, mdx, r);
                //kiri
                mimg.setRGB(y, mtx, s);
            }
        }
        
        //save mirror image
        try {
            f = new File(path);
            ImageIO.write(mimg, "png", f);
        } catch (Exception e) {
            System.out.println("Error "+e); 
        }
        
        new open_image("C:\\Users\\User\\Desktop\\PKM\\test\\src\\test\\mtest.png");
    }
    
}
