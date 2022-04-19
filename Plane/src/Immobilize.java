import java.awt.*;

public class Immobilize extends Thread {
    MyPlane m;
    MainFrame mainframe;
    int count = 100;
           //我方飞机被定住
    public Immobilize(MyPlane m, MainFrame ma) {
        this.m = m;
        mainframe = ma;
    }

    @Override
    public void run() {
        m.iscanmove = false;
        while (count > 0) {
            count -= 2;
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        m.iscanmove = true;
        mainframe.immobilizes.remove(this);
    }

    void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(m.x + 10, m.y, count / 2, 2);
        g.drawImage(mainframe.immobilizeimg, m.x, m.y, m.width, m.height, null);
    }
}
