import java.awt.*;
import java.awt.geom.Line2D;
import java.io.IOException;

public class Laser extends Thread {
    MainFrame mainframe;
    Enemy e;
    Enemy temp;
    int positionx;
    int beginy;
    int endy;
    int count;
    boolean flag = true;
          //技能 激光
    public Laser(MainFrame m) {
        mainframe = m;
    }

    @Override
    public void run() {
        while (flag) {
            if (e != null) {
                e.blood -= 25;
                if (e.blood <= 0) {
                    e.flag = false;
                    e.isalive = false;
                    if (e.enemytype == 4) {

                        try {
                            EnemyBullet ene = new EnemyBullet(mainframe, 2, e.x, 0, e.y, 0, 60);
                            ene.start();
                            mainframe.enemybullet.add(ene);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }

                    } else if (e.enemytype == 7) {
                        EnemyFuryPlane ef = new EnemyFuryPlane(mainframe, e.x, e.y);
                        ef.start();
                        mainframe.enemyFuryPlanes.add(ef);
                    } else {

                        try {
                            Bomb b = new Bomb(mainframe, e.x, e.y, e.width, e.height);
                            b.start();
                            mainframe.bomb.add(b);
                            if(e.enemytype==2){
                                GameOver g=new GameOver(mainframe,1);
                                g.start();
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
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
            count++;
            if (count == 50) {
                flag = false;
                mainframe.lasers.remove(this);
            }
            //System.out.println(count);
            try {
                sleep(300);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }
    }

    void paint(Graphics g) {
        endy = -5;
        positionx = mainframe.myplane.x + mainframe.myplane.width / 2;
        beginy = mainframe.myplane.y;

        for (int i = 0; i < mainframe.enemy.size(); i++) {
            Enemy en = mainframe.enemy.get(i);
            if (positionx >= en.x && positionx <= en.x + en.width) {
                if (en.y + en.height / 2 > endy && en.y + en.height / 2 < mainframe.myplane.y) {
                    endy = en.y + en.height / 2;
                    temp = en;
                }
            }
        }
        if (endy == -5) {
            e = null;
        } else {
            e = temp;
        }
        g.drawImage(mainframe.laserfireGIF, positionx - 10, endy - 10, 20, 20, null);
        Graphics2D g_2d = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(positionx, beginy, positionx, endy);
        BasicStroke bs_1 = new BasicStroke(8);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.red);
        g_2d.draw(line_1);
    }
}
