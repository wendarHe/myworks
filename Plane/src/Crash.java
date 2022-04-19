import java.awt.*;

public class Crash extends Thread {
    MainFrame mainframe;

    public Crash(MainFrame m) {
        mainframe = m;
    }

    @Override
    public void run() {
        try {
            sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainframe.myplane.isinvincible = false;
        mainframe.crashvector.remove(this);
    }

    void paint(Graphics g) {
        g.drawImage(mainframe.shield, mainframe.myplane.x - 15, mainframe.myplane.y - 15, 100, 47, null);
    }
}
