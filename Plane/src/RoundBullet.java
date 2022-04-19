import java.awt.*;
import java.io.IOException;

public class RoundBullet extends Thread {
    MainFrame mainframe;
    double n;
    double length = 0;
    int x;
    int y;
    int tempx;
    int tempy;
    int harm = 25;
    int width = 15;
    int height = 15;

    public RoundBullet(MainFrame m, double n) {
        mainframe = m;
        this.n = n;
        tempx = mainframe.myplane.x + mainframe.myplane.width / 2;
        tempy = mainframe.myplane.y + mainframe.myplane.height / 2;
    }

    public RoundBullet(MainFrame m) {
        mainframe = m;
//        tempx=mainframe.myplane.x+mainframe.myplane.width/2;
//        tempy=mainframe.myplane.y+mainframe.myplane.height/2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            RoundBullet b = new RoundBullet(mainframe, 0.2);
            RoundBullet b2 = new RoundBullet(mainframe, 0.4);
            RoundBullet b3 = new RoundBullet(mainframe, 0.6);
            RoundBullet b4 = new RoundBullet(mainframe, 0.8);
            RoundBullet b5 = new RoundBullet(mainframe, 1.0);
            RoundBullet b6 = new RoundBullet(mainframe, 1.2);
            RoundBullet b7 = new RoundBullet(mainframe, 1.4);
            RoundBullet b8 = new RoundBullet(mainframe, 1.6);
            RoundBullet b9 = new RoundBullet(mainframe, 1.8);
            RoundBullet b10 = new RoundBullet(mainframe, 2.0);
            mainframe.roundBullets.add(b);
            mainframe.roundBullets.add(b2);
            mainframe.roundBullets.add(b3);
            mainframe.roundBullets.add(b4);
            mainframe.roundBullets.add(b5);
            mainframe.roundBullets.add(b6);
            mainframe.roundBullets.add(b7);
            mainframe.roundBullets.add(b8);
            mainframe.roundBullets.add(b9);
            mainframe.roundBullets.add(b10);
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        RoundBullet b=new RoundBullet(mainframe,1.6);
//        RoundBullet b=new RoundBullet(mainframe,1.6);
    }

    void paint(Graphics g) {
        if (length < 250.0) {
            x = tempx + (int) (length * Math.sin(n * Math.PI));
            y = tempy + (int) (length * Math.cos(n * Math.PI));
            length += 10.0;
            g.drawImage(mainframe.bulletimg, x, y, width, height, null);
        } else {
            mainframe.roundBullets.remove(this);
        }
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
                mainframe.roundBullets.remove(this);

                break;
            }
        }

    }
}
