import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//子弹 撞到敌人后面生成两个子弹
public class Bullet3 {
    MainFrame mainframe;


    //BufferedImage bullet = image1;
    int x;
    int y;
    int a;
    int width = 30;
    int height = 30;
    int speed = 13;
    int harm = 20;
    boolean ishit = false;

    public Bullet3(MainFrame frame, int a, int x, int y) throws IOException {
        mainframe = frame;
        this.x = x;
        this.y = y;
        this.a = a;
        harm += MyPlane.beneficialharm;
    }


    void paint(Graphics g) {
        g.drawImage(mainframe.bullet3img, x += a, y -= speed, width, height, null);
    }


    void hit() throws IOException {
        Rectangle bull = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemy;
        for (int i = 0; i < mainframe.enemy.size(); i++) {
            Enemy e = mainframe.enemy.get(i);
            enemy = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemy.intersects(bull)) {
                if (!ishit) {         //让子弹分裂一次碰到敌人不再分裂
                    Bullet3 b1 = new Bullet3(mainframe, -3, e.x + e.width / 2 - 15, e.y - 30);
                    b1.ishit = true;
                    mainframe.bullet3.add(b1);
                    Bullet3 b2 = new Bullet3(mainframe, +3, e.x + e.width / 2 - 15, e.y - 30);
                    b2.ishit = true;
                    mainframe.bullet3.add(b2);
                }
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


                mainframe.bullet3.remove(this);

            }
        }

    }

}
