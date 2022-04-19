import com.sun.tools.javac.Main;

import java.awt.*;

public class Iced extends Thread {
    MainFrame mainframe;
    Enemy e;
    EnemyFuryPlane en;
    int tempspeed;
    int count = 100;

    public Iced(MainFrame m, Enemy e) {
        mainframe = m;
        this.e = e;

    }

    public Iced(MainFrame m, EnemyFuryPlane en) {
        mainframe = m;
        this.en = en;
    }

    @Override
    public void run() {
        if (e != null) {
            tempspeed = e.speedy;
            e.speedy = 0;
            e.isiced = true;
        }
        if (en != null) {
            tempspeed = en.speedy;
            en.speedy = 0;
        }
        while (count > 0) {
            count -= 1;
            try {
                sleep(10);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        if (e != null) {
            e.speedy = tempspeed;
            e.isiced = false;
        }
        if (en != null) {
            en.speedy = tempspeed;

        }
        mainframe.iced.remove(this);
    }

    void paint(Graphics g) {
        if (e != null) {
            if (e.isalive && e.enemytype != 2) {
                g.setColor(Color.yellow);
                g.fillRect(e.x + 15, e.y - 5, count / 2, 2);
                g.drawImage(mainframe.immobilizeimg, e.x, e.y, e.width, e.height, null);
            }

        } else if (en != null) {
            g.drawImage(mainframe.immobilizeimg, en.x, en.y, en.width, en.height, null);
            g.setColor(Color.yellow);
            g.fillRect(en.x + 15, en.y - 5, count / 2, 2);
        }

    }
}
