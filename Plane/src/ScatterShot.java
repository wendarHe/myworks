import java.awt.*;
import java.io.IOException;

public class ScatterShot extends Thread {
    int x;
    int y;
    int range = 15;
    int speedx;
    int speedy;
    int tempy;
    int harm;
    MainFrame mainframe;

    public ScatterShot(MainFrame m, int x, int speedx, int y, int speedy, int harm) {
        this.x = x;
        this.y = y;
        this.mainframe = m;
        this.speedx = speedx;
        this.speedy = speedy;
        tempy = y;
        this.harm = harm;
    }

    public ScatterShot(MainFrame m, int harm) {
        this.mainframe = m;
        this.harm = harm;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            ScatterShot s1 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, -2, mainframe.myplane.y, 12, 5);
            ScatterShot s2 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, -1, mainframe.myplane.y, 12, 7);
            ScatterShot s3 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 0, mainframe.myplane.y, 12, 9);
            ScatterShot s4 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 1, mainframe.myplane.y, 12, 7);
            ScatterShot s5 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 2, mainframe.myplane.y, 12, 5);
            mainframe.scattershot.add(s1);
            mainframe.scattershot.add(s2);
            mainframe.scattershot.add(s3);
            mainframe.scattershot.add(s4);
            mainframe.scattershot.add(s5);
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void paint(Graphics g) {
        if ((tempy - y) > 300) {
            mainframe.scattershot.remove(this);
        }
        g.drawImage(mainframe.bulletimg, x += speedx, y -= speedy, range, range, null);
    }

    void hit() throws IOException {
        Rectangle bull = new Rectangle(this.x, this.y, range, range);
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
                mainframe.scattershot.remove(this);

                break;
            }
        }

    }
}
