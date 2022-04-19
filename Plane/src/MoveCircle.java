import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Vector;

public class MoveCircle extends Thread {
    boolean isalive = true;
    MainFrame mainframe;
    int x = 256;
    int y = 500;
    int width = 50;
    int height = 53;
    boolean flag = true;
    int countdown = 0;
    double n = Math.PI / 6.0;
    double n2 = -Math.PI / 6.0;
    double n3 = Math.PI / 2;
    double n4 = (Math.PI * 5.0) / 6.0;
    double n5 = 1.5 * Math.PI;
    double n6 = (7.0 * Math.PI) / 6.0;
    double length = 50.0;
    double speed = 0.002;
    Vector<Enemy> enemy = new Vector<>();

    public MoveCircle(MainFrame m) {
        mainframe = m;

        enemy.addAll(mainframe.enemy);
    }

    @Override
    public void run() {
        while (flag) {
            if (mainframe.drawlineharm.size() < 3) {
                for (int i = 0; i < enemy.size(); i++) {
                    Enemy e = enemy.get(i);
                    if (e.isalive && !e.isdrawlineharm) {
                        DrawLineHarm d = new DrawLineHarm(this, e, mainframe);
                        d.start();
                        mainframe.drawlineharm.add(d);
                        e.isdrawlineharm = true;

                    } else if (!e.isalive) {
                        enemy.remove(e);
                    }
                    if (mainframe.drawlineharm.size() == 3) {
                        break;
                    }
                }
            }
            countdown += 1;
            if (countdown == 1200) {
                flag = false;
                mainframe.movecircle.remove(this);
                isalive = false;
            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
//       enemy.clear();
//       enemy.addAll(mainframe.enemy);
        for (int i = 0; i < enemy.size(); i++) {
            if (!enemy.get(i).isalive) {
                enemy.remove(i);
            }
        }
        Graphics2D g_2d = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(x + (int) (length * Math.cos(n3 += speed)), y + (int) (length * Math.sin(n3 += speed)), x + (int) (length * Math.cos(n2 += speed)), y + (int) (length * Math.sin(n2 += speed)));
        Line2D line_2 = new Line2D.Double(x + (int) (length * Math.cos(n3 += speed)), y + (int) (length * Math.sin(n3 += speed)), x + (int) (length * Math.cos(n6 += speed)), y + (int) (length * Math.sin(n6 += speed)));
        Line2D line_3 = new Line2D.Double(x + (int) (length * Math.cos(n2 += speed)), y + (int) (length * Math.sin(n2 += speed)), x + (int) (length * Math.cos(n6 += speed)), y + (int) (length * Math.sin(n6 += speed)));
        Line2D line_4 = new Line2D.Double(x + (int) (length * Math.cos(n += speed)), y + (int) (length * Math.sin(n += speed)), x + (int) (length * Math.cos(n4 += speed)), y + (int) (length * Math.sin(n4 += speed)));
        Line2D line_5 = new Line2D.Double(x + (int) (length * Math.cos(n += speed)), y + (int) (length * Math.sin(n += speed)), x + (int) (length * Math.cos(n5 += speed)), y + (int) (length * Math.sin(n5 += speed)));
        Line2D line_6 = new Line2D.Double(x + (int) (length * Math.cos(n4 += speed)), y + (int) (length * Math.sin(n4 += speed)), x + (int) (length * Math.cos(n5 += speed)), y + (int) (length * Math.sin(n5 += speed)));

        BasicStroke bs_1 = new BasicStroke(4);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.MAGENTA);
        g_2d.draw(line_1);
        g_2d.setColor(Color.red);
        g_2d.draw(line_2);
        g_2d.setColor(Color.yellow);
        g_2d.draw(line_3);
        g_2d.setColor(Color.green);
        g_2d.draw(line_4);
        g_2d.setColor(Color.ORANGE);
        g_2d.draw(line_5);
        g_2d.setColor(Color.CYAN);
        g_2d.draw(line_6);
g_2d.drawImage(mainframe.circleimg,x-52,y-52,104,104,null);

    }
}
