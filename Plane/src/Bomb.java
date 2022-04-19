import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
               //飞机死后爆炸效果
class Bomb extends Thread {
    boolean flag = true;
    int width;
    int height;
    int x;
    int y;

    MainFrame mainframe;

    public Bomb(MainFrame m, int x, int y, int width, int height) throws IOException {
        mainframe = m;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void run() {
        while (flag) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            mainframe.bomb.remove(this);
        }
    }

    public void paint(Graphics g) {

        g.drawImage(mainframe.bombimg, x, y, width, height, null);
    }
}
