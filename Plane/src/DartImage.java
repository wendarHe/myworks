import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DartImage {
    BufferedImage[] dart =new BufferedImage[38];
    public DartImage() throws IOException {
        for(int i=0;i<38;i++){
            dart[i]= ImageIO.read(new File("src\\image\\飞镖\\图层 1 拷贝 "+(i+2)+".png"));
        }
    }
}
