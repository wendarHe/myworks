import java.awt.*;
import java.awt.geom.Line2D;
import java.io.IOException;

public class DrawLineHarm extends Thread {
    int harm = 5;
    MoveCircle movecircle;
    Enemy e;
    MainFrame mainframe;
    boolean flag = true;

    public DrawLineHarm(MoveCircle move, Enemy e, MainFrame m) {
        this.movecircle = move;
        this.e = e;
        mainframe = m;
    }

    @Override
    public void run() {
        while (flag) {
            e.blood -= harm;
            try {
                sleep(350);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            if (harm <= 10) {
                harm += 1;
            }
        }

    }

    public void paint(Graphics g) {
        if (e.blood <= 0 || e.y > 700 || !e.isalive) {
            flag = false;
            e.isalive = false;
            movecircle.enemy.remove(e);
            mainframe.drawlineharm.remove(this);
            mainframe.enemy.remove(e);
        }
        if (!movecircle.isalive) {
            flag = false;
            mainframe.drawlineharm.remove(this);

        }
        Graphics2D g_2d = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(movecircle.x, movecircle.y, e.x + e.width / 2, e.y + e.height / 2);
        BasicStroke bs_1 = new BasicStroke(4);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.blue);
        g_2d.draw(line_1);
        BasicStroke bs_2 = new BasicStroke(1);
        g_2d.setStroke(bs_2);
    }

    void hit() throws IOException {
        if (e.blood <= 0) {
            e.flag = false;
            e.isalive = false;
            if (e.enemytype == 4) {
                EnemyBullet ene = new EnemyBullet(mainframe, 2, e.x, 0, e.y, 0, 60);
                ene.start();
                mainframe.enemybullet.add(ene);
            } else if (e.enemytype == 7) {
                EnemyFuryPlane ef = new EnemyFuryPlane(mainframe, e.x, e.y);
                ef.start();
                mainframe.enemyFuryPlanes.add(ef);
            } else {
                Bomb b = new Bomb(mainframe, e.x, e.y, e.width, e.height);
                b.start();
                mainframe.bomb.add(b);
                if(e.enemytype==2){
                    GameOver g=new GameOver(mainframe,1);
                    g.start();
                }
            }

            int rate = mainframe.r.nextInt(4);
            if (rate == 0) {
                int rate2 = mainframe.r.nextInt(8);
                BloodBottle bloodbottle = new BloodBottle(mainframe, rate2, e.x + e.width / 2, e.y + e.height / 2);
                mainframe.bloodbottle.add(bloodbottle);
            }

            mainframe.enemy.remove(e);
            MainFrame.score += 2;
            MyPlane.energy += Enemy.energscore;

        }

    }
}
