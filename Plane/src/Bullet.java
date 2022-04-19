import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
      //普通子弹
public class Bullet {
    MainFrame mainframe;


    //boolean flag=true;
    int x;
    int y;
    int width = 20;
    int height = 20;
    int speedy = 13;
    int speedx;

    int harm = 30;

    public Bullet(MainFrame frame, int speedx, int x, int y) throws IOException {
        mainframe = frame;
        this.x = x;
        this.y = y;
        this.speedx = speedx;
        harm += MyPlane.beneficialharm;
    }

    public Bullet(MainFrame frame, int x, int speedx, int y, int speedy, int width, int height) throws IOException {
        mainframe = frame;
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        this.speedx = speedx;
        speedy = speedy;
    }


    void paint(Graphics g) {
        g.drawImage(mainframe.bulletimg, x += speedx, y -= speedy, width, height, null);
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
                mainframe.bullet.remove(this);

                break;
            }
        }

    }
}

