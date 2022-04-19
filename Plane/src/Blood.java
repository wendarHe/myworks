import java.awt.*;            //画我方飞机血条

public class Blood {
    int xl = 390;
    int yl = 50;

    MainFrame mainframe;

    public Blood(MainFrame m) {
        mainframe = m;
    }

    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.drawLine(390, 49, 490, 49);
        g.drawLine(389, 50, 389, 60);
        g.drawLine(490, 50, 490, 60);
        g.drawLine(390, 60, 490, 60);

        if (mainframe.myplane.blood > 60) {
            g.setColor(Color.blue);
        } else if (mainframe.myplane.blood > 20 && mainframe.myplane.blood <= 60) {
            g.setColor(Color.yellow);
        } else {
            g.setColor(Color.red);
        }

        g.fillRect(xl, yl, mainframe.myplane.blood, 10);
    }
}
