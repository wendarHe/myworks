import java.awt.*;
import java.io.IOException;
import java.util.Vector;

public class DeadlyFourBulletFire {
    MainFrame mainframe;
    Vector<Enemy>copyenemy=new Vector<>();
    int x;
    int y;
    int tempx;
    int tempy;
    static int harm=100;
    int width=30;
    int height=30;
    int beginx;int beginy;int endx;int endy;
   double sin;
    double cos;
    double length;
    public DeadlyFourBulletFire(MainFrame m,int beginx,int beginy,int endx,int endy) {
        mainframe = m;
copyenemy.addAll(mainframe.enemy);
            sin= (double)(endy-beginy)/Math.sqrt(Math.pow((endx-beginx),2)+Math.pow((endy-beginy),2));
            cos=(double) (endx-beginx)/Math.sqrt(Math.pow((endx-beginx),2)+Math.pow((endy-beginy),2));
       tempx=beginx;
       tempy=beginy;


    }
    void paint(Graphics g){
        x=(int)(length*cos)+tempx;
        y=(int)(length*sin)+tempy;
        g.drawImage(mainframe.deadlybulletimg,x-15,y-15,30,30,null);
        length+=17.0;
        //length+=10.0;
if(length>1000.0){
    mainframe.deadlyFourBulletFires.remove(this);
}
    }
    void hit2() throws IOException {
        Rectangle bull = new Rectangle(this.x-15, this.y-15, this.width, this.height);
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
                    // MyPlane.energy+=Enemy.energscore;
                }

            }

        }

    }
}
