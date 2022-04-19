import java.awt.*;
import java.io.IOException;

            //boss火球
public class EnemyBullet2 {
    MainFrame mainframe;
    int x;
    int y;
    Enemy e;
    int width = 50;
    int height = 50;
    int aimx;
    int aimy;

    public EnemyBullet2(MainFrame m, Enemy e, int aimx, int aimy) {
        mainframe = m;
        this.e = e;
        x = e.x + e.width / 2;
        y = e.y + e.height;
        this.aimx = aimx;
        this.aimy = aimy;
    }


    public void paint(Graphics g) throws IOException {
        if (Math.abs(x - aimx) <= 20) {
            x += (aimx - x) / 10;
        } else if ((aimx - x) > 20) {
            x += 6;
        } else if (aimx - x < -20) {
            x -= 6;
        }
        if (Math.abs(aimy - y) <= 20) {
            y += (aimy - y) / 10;
        } else if ((aimy - y) > 20) {
            y += 6;
        } else if (aimy - y < -20) {
            y -= 6;
        }

        if (Math.abs(x - aimx) < 20 && Math.abs(y - aimy) < 20) {
            Bomb b = new Bomb(mainframe, aimx - 5, aimy - 5, width + 10, height + 10);
            b.start();
            mainframe.bomb.add(b);
            mainframe.enemyBullet2.remove(this);
            Rectangle firebow = new Rectangle(aimx, aimy, width, height);
            Rectangle myplane ;
            for(int i=0;i<mainframe.mylittleplane.size();i++){
               MyPlane m=mainframe.mylittleplane.get(i);
               myplane=new Rectangle(m.x,m.y,m.width,m.height);
                if (firebow.intersects(myplane) && !mainframe.myplane.isinvincible) {
                   m.blood-=10;
                   if(m.blood<=0){
                       Bomb bo=new Bomb(mainframe,m.x,m.y,m.width,m.height);
                       bo.start();
                       mainframe.bomb.add(bo);
                       m.flag=false;
                       mainframe.mylittleplane.remove(m);
                       if(m.myplanetype==1){
                           GameOver ga=new GameOver(mainframe,2);
                           ga.start();
                       }
                   }
                }
            }

            mainframe.enemyBullet2.remove(this);
        } else {
            g.drawImage(mainframe.firebowimg, x, y, width, height, null);
        }
    }
}
