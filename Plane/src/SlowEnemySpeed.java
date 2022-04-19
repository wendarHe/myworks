import java.awt.*;
          //技能减速敌机
public class SlowEnemySpeed extends Thread {
    Enemy e;

    MainFrame mainframe;

    public SlowEnemySpeed(MainFrame m, Enemy e) {
        this.e = e;
        this.mainframe = m;
    }

    @Override
    public void run() {

            e.speedy /= 2;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            e.speedy *= 2;
            e.isbeslow = false;
            mainframe.slowenemyspeed.remove(this);

    }

    public void paint(Graphics g) {
        g.drawImage(mainframe.sixstarimg, e.x, e.y, e.width, e.height, null);
    }
}
