import java.awt.*;

public class BossFirebowWarning extends Thread {
    int x;
    int y;
    int width = 50;
    int height = 50;
    MainFrame mainframe;
    Enemy e;
              //boss火球预警
    public BossFirebowWarning(MainFrame m, Enemy e, int x, int y) {
        this.x = x;
        this.y = y;
        mainframe = m;
        this.e = e;
    }

    @Override
    public void run() {
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EnemyBullet2 e = new EnemyBullet2(mainframe, this.e, x, y);
        mainframe.enemyBullet2.add(e);
        mainframe.bossFirebowWarnings.remove(this);
    }

    void paint(Graphics g) {
        g.drawImage(mainframe.aimingimg, x, y, width, height, null);
    }
}
