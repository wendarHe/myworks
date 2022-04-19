import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GuidedMisssile {

    int x;
    int y;
    int width = 17;
    int height = 36;
    int harm = 20;
    int temp;
    Enemy e;
    MainFrame mainframe;

    public GuidedMisssile(MainFrame m, int x, int y) throws IOException {
        harm += MyPlane.beneficialharm;
        mainframe = m;
        this.x = x;
        this.y = y;
        for (int j = 0; j < mainframe.enemy.size(); j++) {
            Enemy e2 = mainframe.enemy.get(j);
            if (j == mainframe.enemy.size() - 1) {
                if (e2.isbefollow) {
                    for (int k = 0; k < mainframe.enemy.size(); k++) {
                        Enemy e3 = mainframe.enemy.get(k);
                        e3.isbefollow = false;
                    }
                }
            }
            if (!e2.isbefollow) {
                e = e2;
                e2.isbefollow = true;
                break;
            }

        }
    }

    public void paint(Graphics g) {
        if (this.e == null || !e.isalive) {

            for (int i = 0; i < mainframe.enemy.size(); i++) {
                Enemy e2 = mainframe.enemy.get(i);
                if (i == mainframe.enemy.size() - 1) {
                    if (e2.isbefollow) {
                        for (int k = 0; k < mainframe.enemy.size(); k++) {
                            Enemy e3 = mainframe.enemy.get(k);
                            e3.isbefollow = false;
                        }
                    }
                }
                if (!e2.isbefollow) {
                    e = e2;
                    e2.isbefollow = true;
                    break;
                }

            }
        }
        int speedx = ((e.x + e.width / 2 - 15) - x);
        int speedy = ((e.y + e.width / 2 + 15) - y);
        if ((speedx <= 20 && speedx >= 0) || (speedx >= -20 && speedx <= 0)) {
            speedx /= 10;
        } else if (speedx > 20) {
            speedx = 9;
        } else if (speedx < -20) {
            speedx = -9;
        }
        if ((speedy <= 20 && speedy >= 0) || (speedy >= -20 && speedy <= 0)) {
            speedy /= 10;
        } else if (speedy > 20) {
            speedy = 10;
        } else if (speedy < -20) {
            speedy = -10;
        }

//            int spx=((e.x+e.width/2-15)-x)/10;
//            int spy=((e.y+e.width/2+15)-y)/10;
        g.drawImage(mainframe.gm, x += speedx, y += speedy, width, height, null);


    }

    void hit() throws IOException {
        Rectangle bull = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemy;
        for (int i = 0; i < mainframe.enemy.size(); i++) {
            Enemy e = mainframe.enemy.get(i);
            enemy = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemy.intersects(bull)) {

                e.blood -= harm;
                if (e.blood <= 0) {
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
                    MyPlane.energy += Enemy.energscore;
                }
                e.isbefollow = false;
                mainframe.guidedmissile.remove(this);

            }
        }

    }
}
