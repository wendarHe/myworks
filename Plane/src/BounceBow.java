import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;
               //技能 反弹波
public class BounceBow {
    int x;
    int y;
    int speedy;
    int width;
    int height;
    int harm = 70;

    boolean issetted = false;
    boolean temp = true;
    MainFrame mainframe;
    BufferedImage img;
    Vector<Enemy> copyenemy = new Vector<>();

    public BounceBow(MainFrame m, int x, int speedy, int width, int height) {
        mainframe = m;
        this.x = x;
        this.speedy = speedy;
        this.width = width;
        this.height = height;
        img = mainframe.bouncebowimg02;
        copyenemy.addAll(mainframe.enemy);
    }

    void paint(Graphics g) {
        if (issetted && temp) {
            img = mainframe.bouncebowimg01;
            x = 0;
            speedy = -10;
            width = 512;
            height = 427;
            temp = false;
            harm = 300;
            copyenemy.clear();
            copyenemy.addAll(mainframe.enemy);
        }
        g.drawImage(img, x, y += speedy, width, height, null);

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
                    // MyPlane.energy+=Enemy.energscore;
                }

            }

        }

    }
}
