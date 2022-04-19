import java.awt.*;
import java.io.IOException;

public class EnemyFuryPlane extends Thread {
    int x;
    int y;
    int tempy;
    int width = 80;
    int height = 55;
    int speedy = 8;
    boolean wait = true;
    MainFrame mainframe;
              //敌方狂怒飞机
    public EnemyFuryPlane(MainFrame m, int x, int y) {
        mainframe = m;
        this.x = x;
        this.y = y;
        tempy = y;
    }

    @Override
    public void run() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait = false;
    }

    void paint(Graphics g) {
        if (y < tempy + 110) {
            if (wait) {
                g.drawImage(mainframe.enemy05plusimg, x, y, width, height, null);
            } else {
                g.drawImage(mainframe.enemy05plusimg, x, y += speedy, width, height, null);
            }


        } else if (y >= tempy + 110) {

            mainframe.enemyFuryPlanes.remove(this);
            try {

                Bomb b = new Bomb(mainframe, x, y, width, height);
                b.start();
                mainframe.bomb.add(b);
            } catch (IOException e) {
                e.printStackTrace();
            }


            Rectangle r = new Rectangle(mainframe.myplane.x, mainframe.myplane.y, mainframe.myplane.width, mainframe.myplane.height);
            Rectangle r2 = new Rectangle(x, y, width, height);
            if (r.intersects(r2)) {

                mainframe.myplane.blood -= 10;
            }
        }

    }
}
