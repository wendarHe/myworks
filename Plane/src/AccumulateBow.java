import java.awt.*;
import java.io.IOException;
import java.util.Vector;

public class AccumulateBow {
    Vector<Enemy> copyenemy = new Vector<>();
    MainFrame mainframe;

    int x;
    int y;
    int width;
    int height;
    int harm;
    int speedy;

    public AccumulateBow(MainFrame m, int y, int speedy) {
        mainframe = m;
        harm = (int) ((double) mainframe.accumulatenumber * 1.25);
        width = mainframe.accumulatenumber * 2;
        x = mainframe.myplane.x + mainframe.myplane.width / 2 - mainframe.accumulatenumber;
        this.y = y;
        this.speedy = speedy;
        height = (178 * width) / 266;
        copyenemy.addAll(mainframe.enemy);
    }

    void paint(Graphics g) {
        g.drawImage(mainframe.accumutebowimg, x, y -= speedy, width, height, null);
    }

    void hit2() throws IOException {

        Rectangle bull = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemy;
        for (int i = 0; i < copyenemy.size(); i++) {
            Enemy e = copyenemy.get(i);

            enemy = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemy.intersects(bull)) {
                copyenemy.remove(e);
                e.blood -= harm;
                if (e.blood <= 0 && e.isalive) {
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
                    e.flag = false;
                    mainframe.enemy.remove(e);
                    MainFrame.score += 2;
                     MyPlane.energy+=Enemy.energscore;
                }

            }

        }

    }
}
