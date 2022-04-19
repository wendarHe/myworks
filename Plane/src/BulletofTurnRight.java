import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
              //转向子弹
public class BulletofTurnRight extends Thread {
    MainFrame mainframe;
    int x;
    int y;
    int a;
    //boolean flag=true;
    int width = 20;
    int height = 20;
    int speed;
    int harm = 30;
    int temp;

    public BulletofTurnRight(MainFrame frame, int a, int speed, int x, int y) throws IOException {

        mainframe = frame;
        this.x = x;
        this.y = y;
        this.a = a;
        this.speed = speed;
        temp = x;
        harm += MyPlane.beneficialharm;
    }


    void paint(Graphics g) {
        if (x < temp - 100 || x < 0) {
            a *= -1;
        } else if (x > temp + 100 || x > 500) {
            a *= -1;
        }
        g.drawImage(mainframe.bulletofturnrightimg, x += a, y -= speed, width, height, null);
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

                mainframe.bulletofturnright.remove(this);

                break;
            }
        }
    }
}
