import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
             //灼烧子弹
public class BulletFire {
    MainFrame mainframe;
    Vector<Enemy> copyenemy = new Vector<>();


    int x;
    int y;
    int width = 30;
    int height = 144;
    int speed = 13;
    int a;
    int harm = 15;

    public BulletFire(MainFrame frame, int a, int x, int y) throws IOException {
        mainframe = frame;
        this.x = x;
        this.y = y;
        this.a = a;
        copyenemy.addAll(mainframe.enemy);
        harm += MyPlane.beneficialharm;
    }


    void paint(Graphics g) {
        for (int i = 0; i < copyenemy.size(); i++) {
            if (!copyenemy.get(i).isalive) {
                copyenemy.remove(i);
            }
        }
        g.drawImage(mainframe.planefirebowimg, x += a, y -= speed, width, height, null);
    }


    void hit() throws IOException {
        Rectangle bull = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemy;
        for (int i = 0; i < copyenemy.size(); i++) {
            Enemy e = copyenemy.get(i);

            enemy = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemy.intersects(bull)) {
                Iginition igi = new Iginition(e, mainframe, this);
                igi.start();
                mainframe.iginitions.add(igi);
                copyenemy.remove(e);
                e.blood -= harm;
                if (e.blood <= 0 && e.isalive) {
                    e.isalive = false;
                    e.flag = false;
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

    }
}
