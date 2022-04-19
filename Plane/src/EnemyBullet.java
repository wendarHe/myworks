import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
          //敌方子弹
public class EnemyBullet extends Thread {
    BufferedImage img;
    int enemybullettype ;
    int x;
    int y;
    int xspeed;
    int range ;
    int yspeed = 3;
    int index=0;
    double length = 0.0;
    double rotationalspeed=0.004;
    int tempx;
    int tempy;
    double n;
    static int harm = 10;
    boolean flag = true;
    MainFrame mainframe;

    public EnemyBullet(MainFrame m, int enemybullettype, int x, int xspeed, int y, int yspeed, int range) throws IOException {
        mainframe = m;
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.range = range;
        this.enemybullettype = enemybullettype;
        if (enemybullettype == 0 || enemybullettype == 1) {
            img = mainframe.enemybulletimg;
        } else if (enemybullettype == 2) {
            img = mainframe.redbomb;
        } else if (enemybullettype == 4) {
            img = mainframe.fivestarimg;
        }
        if(enemybullettype==6){
            tempx=x;
        }
    }
    public EnemyBullet(MainFrame m, int enemybullettype, int x, int y, int range,double n) throws IOException {
        mainframe = m;
        this.x = x;
        this.y = y;
        this.range = range;
        this.enemybullettype = enemybullettype;
        this.n=n;
        tempx=x;
        tempy=y;
        if (enemybullettype == 0 || enemybullettype == 1) {
            img = mainframe.enemybulletimg;
        } else if (enemybullettype == 2) {
            img = mainframe.redbomb;
        } else if (enemybullettype == 4) {
            img = mainframe.fivestarimg;
        }
    }

              public EnemyBullet(MainFrame m, int enemybullettype, int x, int y, int range,double n,double rotationalspeed) throws IOException {
                  mainframe = m;
                  this.x = x;
                  this.y = y;
                  this.range = range;
                  this.enemybullettype = enemybullettype;
                  this.rotationalspeed=rotationalspeed;
                  this.n=n;
                  tempx=x;
                  tempy=y;
                  if (enemybullettype == 0 || enemybullettype == 1) {
                      img = mainframe.enemybulletimg;
                  } else if (enemybullettype == 2) {
                      img = mainframe.redbomb;
                  } else if (enemybullettype == 4) {
                      img = mainframe.fivestarimg;
                  }
              }

    @Override
    public void run() {
        while (flag) {
            if (enemybullettype == 1) {        //boss子弹打出之后会分成若干个
                if (y > 450) {
                    try {
                        EnemyBullet e = new EnemyBullet(mainframe, 5, x,y,10,0.2);
                        mainframe.enemybullet.add(e);
                        EnemyBullet e2 = new EnemyBullet(mainframe, 5, x,y,10,0.4);
                        mainframe.enemybullet.add(e2);
                        EnemyBullet e3 = new EnemyBullet(mainframe, 5, x,y,10,  0.6);
                        mainframe.enemybullet.add(e3);
                        EnemyBullet e4 = new EnemyBullet(mainframe, 5, x,y,10,  0.8);
                        mainframe.enemybullet.add(e4);
                        EnemyBullet e5 = new EnemyBullet(mainframe, 5, x,y,10,  1.0);
                        mainframe.enemybullet.add(e5);
                        EnemyBullet e6 = new EnemyBullet(mainframe, 5, x,y,10,1.2);
                        mainframe.enemybullet.add(e6);
                        EnemyBullet e7 = new EnemyBullet(mainframe, 5, x,  y, 10,1.4);
                        mainframe.enemybullet.add(e7);
                        EnemyBullet e8 = new EnemyBullet(mainframe, 5, x,  y,10,1.6);
                        mainframe.enemybullet.add(e8);
                        EnemyBullet e9 = new EnemyBullet(mainframe, 5, x,  y,10,1.8);
                        mainframe.enemybullet.add(e9);
                        EnemyBullet e10 = new EnemyBullet(mainframe, 5, x,  y,10,2.0);
                        mainframe.enemybullet.add(e10);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    mainframe.enemybullet.remove(this);
                    flag = false;
                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (enemybullettype == 2) {         //飞机死亡后爆炸
                while (range < 120) {
                    range += 10;
                    x -= 5;
                    y -= 5;
                    try {
                        sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainframe.enemybullet.remove(this);
            }
        }

    }


    public void paint(Graphics g) {
        if (enemybullettype == 3) {          //boss旋转子弹
            n += rotationalspeed;
            length += 1.5;
            tempy += 2;
            x = (int) (Math.cos(Math.PI * n) * length) + tempx;
            y = (int) (Math.sin(Math.PI * n) * length) + tempy;
            g.drawImage(mainframe.enemybulletimg, x, y, range, range, null);
        } else if (enemybullettype == 4) {            //眩晕五角星
            g.drawImage(img, x += xspeed, y += yspeed, 20, 20, null);
        }else if(enemybullettype==5){              //boss子弹打出去散开
            x=tempx+(int)(length*Math.cos(n*Math.PI));
            y=tempy+(int)(length*Math.sin(n*Math.PI));
            length+=4.0;
            g.drawImage(mainframe.enemybulletimg,x,y,range,range,null);
        }
        else{
            g.drawImage(img, x += xspeed, y += yspeed, range, range, null);    //bullettype=0 普通子弹
        }

    }

}
