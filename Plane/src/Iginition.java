import java.awt.*;
import java.io.IOException;
                //子弹 灼烧敌人
public class Iginition extends Thread {
    Enemy e;
    MainFrame mainframe;
    boolean flag = true;
    int count;
    BulletFire b;
    boolean crash = false;

    public Iginition(Enemy e, MainFrame m, BulletFire b) {
        this.e = e;
        mainframe = m;
        this.b = b;
    }

    @Override
    public void run() {
        crash = true;
        while (flag) {

            e.blood -= 5;

            try {
                sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            count++;
            if (count == 8) {
                flag = false;
                mainframe.iginitions.remove(this);
            }
        }
    }

    void paint(Graphics g) {
        g.drawImage(mainframe.iginitionimg, e.x + e.width / 2, e.y, 40, 40, null);
    }

    void hit() throws IOException {
        if (!e.isalive) {
            flag = false;
            mainframe.iginitions.remove(this);
        }
        if (e.blood <= 0 && e.isalive) {
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
            mainframe.iginitions.remove(this);
            b.copyenemy.remove(e);
        }


    }
}
