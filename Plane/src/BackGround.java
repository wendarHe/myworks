import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.Naming;

public class BackGround {
    boolean ispurgatory=false;
   MainFrame mainframe;

    public BackGround(MainFrame m) throws IOException {
        mainframe=m;
    }

    void paint(Graphics g) {
        if(!ispurgatory){
            g.drawImage(mainframe.bgnormalimg, 0, 0, null);
        }else{
            g.drawImage(mainframe.bgpurgatoryimg,0,0,null);
        }

    }
}
