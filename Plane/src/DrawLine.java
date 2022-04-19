import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
                 //激光画红线
public class DrawLine extends Thread {

    MainFrame mainframe;
    Enemy enemy;
    Enemy enemy2;

    public DrawLine(MainFrame m, Enemy e2, Enemy e) throws IOException {
        mainframe = m;
        enemy = e;
        this.enemy2 = e2;
    }

    public void run() {

            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainframe.drawline.remove(this);
        }


    public void paint(Graphics g) {
        //g.setColor(Color.red);
        Graphics2D g_2d = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(enemy2.x + enemy2.width / 2, enemy2.y + enemy2.height / 2, enemy.x + enemy.width / 2, enemy.y + enemy.height / 2);
        BasicStroke bs_1 = new BasicStroke(4);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.red);
        g_2d.draw(line_1);
        BasicStroke bs_2 = new BasicStroke(1);
        g_2d.setStroke(bs_2);
//g.drawLine(x,y,x2,y2);

    }
}
