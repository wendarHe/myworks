import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

          //子弹 激光
public class Bullet2 {
    Vector<Enemy> copyenemy = new Vector<>();
    MainFrame mainframe;
    int x;
    int y;
    int y2;
    int width = 1;
    int height = 1;
    int speed = 13;
    int count;
    boolean flag = true;
    int harm = 20;
    Enemy e1;


    public Bullet2(MainFrame frame, int x, int y) throws IOException {
        mainframe = frame;
        this.x = x;
        this.y = y;
        y2 = y + 30;
        harm += MyPlane.beneficialharm;
        copyenemy.addAll(mainframe.enemy);

    }


    void paint(Graphics g) {

        Graphics2D g_2d = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(x, y -= speed, x, y2 -= speed);
        BasicStroke bs_1 = new BasicStroke(4);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.red);
        g_2d.draw(line_1);
        BasicStroke bs_2 = new BasicStroke(0);
        g_2d.setStroke(bs_2);

    }


    void hit() throws IOException {
        Rectangle bull = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemy;
        for (int i = 0; i < copyenemy.size(); i++) {
            Enemy e = copyenemy.get(i);
            enemy = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemy.intersects(bull) && e.isalive) {
                mainframe.bullet2.remove(this);
                e.blood -= harm;
                copyenemy.remove(e);
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

                for (int k = 0; k < 3; k++) {
                    if (copyenemy.size() > 0) {
                        e1 = copyenemy.get(0);
                    }
                    for (int j = 0; j < copyenemy.size(); j++) {
                        Enemy en = copyenemy.get(j);
                        if (Math.abs(en.y - e.y) < Math.abs(e1.y - e.y)) {
                            e1 = en;
                        }
                    }
                    if (e1 != null) {
                        DrawLine d = new DrawLine(mainframe, e1, e);
                        d.start();
                        mainframe.drawline.add(d);
                        e1.blood -= harm;
                        if (e1.blood <= 0) {
                            e1.flag = false;
                            e1.isalive = false;
                            if (e1.enemytype == 4) {
                                EnemyBullet ene = new EnemyBullet(mainframe, 2, e1.x, 0, e1.y, 0, 60);
                                ene.start();
                                mainframe.enemybullet.add(ene);
                            } else if (e1.enemytype == 7) {
                                EnemyFuryPlane ef = new EnemyFuryPlane(mainframe, e1.x, e1.y);
                                ef.start();
                                mainframe.enemyFuryPlanes.add(ef);
                            } else {
                                Bomb b = new Bomb(mainframe, e1.x, e1.y, e1.width, e1.height);
                                b.start();
                                mainframe.bomb.add(b);
                                if(e1.enemytype==2){
                                    GameOver g=new GameOver(mainframe,1);
                                    g.start();
                                }
                            }

                            int rate = mainframe.r.nextInt(4);
                            if (rate == 0) {
                                int rate2 = mainframe.r.nextInt(8);
                                BloodBottle bloodbottle = new BloodBottle(mainframe, rate2, e1.x + e1.width / 2, e1.y + e1.height / 2);
                                mainframe.bloodbottle.add(bloodbottle);
                            }

                            mainframe.enemy.remove(e1);
                            MainFrame.score += 2;
                            MyPlane.energy += Enemy.energscore;
                        }
                    }
                    copyenemy.remove(e1);
                }

                break;
            }
        }
    }
}


