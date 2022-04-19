import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
          //敌机类 包含敌机boss
public class Enemy extends Thread {
    BufferedImage enemyimg;
    int enemytype;
    boolean isbefollow = false;
    boolean isalive = true;
    boolean flag = true;
    boolean isbeslow = false;
    boolean isbesetted = false;
    boolean isiced = false;
    int bosscrash=0;
    Random random = new Random();
    int attack;
    int move;
    int movespeed;
    int rate;
    int r;
    boolean isdrawlineharm = false;
    MainFrame mainframe;
    int blood;
    int x;
    int y;
    int width = 70;
    int height = 56;
    int speedx;
    int speedy;

    int bulletspeedy = 3;
    static int harm = 10;
    static int energscore = 8;
    Vector<Enemy> bufferenemy = new Vector<>();

    public Enemy(MainFrame m, BufferedImage enemyimg, int enemytype, int x, int speedx, int y, int speedy, int width, int height, int blood) throws IOException {
        this.x = x;
        this.y = y;
        mainframe = m;
        this.speedx = speedx;
        this.speedy = speedy;
        this.enemyimg = enemyimg;
        this.enemytype = enemytype;
        this.width = width;
        this.height = height;
        this.blood = blood;

    }

    public Enemy(MainFrame m, BufferedImage enemyimg, int enemytype, int x, int y, int width, int height, int blood) throws IOException {
        this.x = x;
        this.y = y;
        mainframe = m;
        this.enemyimg = enemyimg;
        this.enemytype = enemytype;
        this.width = width;
        this.height = height;
        this.blood = blood;

    }

    @Override
    public void run() {
        while (flag) {
            if ((enemytype == 1 || enemytype == 4 || enemytype == 7) && !isiced) {
                r = random.nextInt(3);
                if (r == 0) {
                    try {
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, 4,10));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (enemytype == 2) {         //boss敌机
                movespeed = random.nextInt(3)+1;
                move = random.nextInt(4);
                rate = random.nextInt(2);
               attack = random.nextInt(11);
                while(rate==0&&attack==3&&bosscrash==1){
                    attack = random.nextInt(8);
                }
                //attack = random.nextInt(2)+9;
             // attack=10;
               //rate=0;
                if (attack == 0 && rate == 0) {             //打出五发子弹
                    try {
                        mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, -1, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 1, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, -2, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, +2, y + height, 4,10));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bosscrash=0;
                } else if (attack == 1 && rate == 0) {           //打出三发子弹共三次
                    for (int i = 0; i < 3; i++) {
                        try {
                            mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, 6,10));
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, -2, y + height, 6,10));
                            mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 2, y + height, 6,10));
                            movespeed = random.nextInt(2 + 1);
                            move = random.nextInt(4);
                            sleep(800);
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bosscrash=0;
                } else if (attack == 2 && rate == 0) {         //召唤五架飞机
                    bufferenemy.clear();
                    try {
                        Enemy e1 = new Enemy(mainframe, mainframe.enemy03img, 1, 0, 0, -40, 5, 70, 56, 80);
                        e1.start();
                        mainframe.enemy.add(e1);
                        bufferenemy.add(e1);

                        Enemy e2 = new Enemy(mainframe, mainframe.enemy03img, 1, 100, 0, -20, 5, 70, 56, 80);
                        e2.start();
                        mainframe.enemy.add(e2);
                        bufferenemy.add(e2);

                        Enemy e3 = new Enemy(mainframe, mainframe.enemy03img, 1, 200, 0, 0, 5, 70, 56, 80);
                        e3.start();
                        mainframe.enemy.add(e3);
                        bufferenemy.add(e3);

                        Enemy e4 = new Enemy(mainframe, mainframe.enemy03img, 1, 300, 0, -20, 5, 70, 56, 80);
                        e4.start();
                        mainframe.enemy.add(e4);
                        bufferenemy.add(e4);

                        Enemy e5 = new Enemy(mainframe, mainframe.enemy03img, 1, 400, 0, -40, 5, 70, 56, 80);
                        e5.start();
                        mainframe.enemy.add(e5);
                        bufferenemy.add(e5);

                        for (int j = 0; j < bufferenemy.size(); j++) {
                            for (int i = 0; i < mainframe.lightbow.size(); i++) {
                                mainframe.lightbow.get(i).copyenemy.add(bufferenemy.get(j));
                            }
                            for (int i = 0; i < mainframe.arrowbullet.size(); i++) {
                                mainframe.arrowbullet.get(i).copyenemy.add(bufferenemy.get(j));
                            }
                            for (int i = 0; i < mainframe.movecircle.size(); i++) {
                                mainframe.movecircle.get(i).enemy.add(bufferenemy.get(j));
                            }
                            for (int i = 0; i < mainframe.bulletFires.size(); i++) {
                                mainframe.bulletFires.get(i).copyenemy.add(bufferenemy.get(j));
                            }
                            for (int i = 0; i < mainframe.bounceBows.size(); i++) {
                                mainframe.bounceBows.get(i).copyenemy.add(bufferenemy.get(j));
                            }
                            for (int i = 0; i < mainframe.bullet2.size(); i++) {
                                mainframe.bullet2.get(i).copyenemy.add(bufferenemy.get(j));
                            }
                            for (int i = 0; i < mainframe.ice.size(); i++) {
                                mainframe.ice.get(i).enemy.add(bufferenemy.get(j));
                            }
for(int i=0;i<mainframe.accumulateBows.size();i++){
    mainframe.accumulateBows.get(i).copyenemy.add(bufferenemy.get(j));
}
                        }
                        movespeed = random.nextInt(3)+1;
                        move = random.nextInt(4);
                        sleep(1500);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    bosscrash=0;
                } else if (attack == 3 && rate == 0&&y>=0) {
                    movespeed=0;                            //boss向下冲撞
                    int temp = y;
                    while (y < 630) {
                        y += 10;
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (y > temp) {
                        y -= 10;
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bosscrash=1;
                } else if (attack == 4 && rate == 0) {          //子弹打出后分裂
                    try {
                        EnemyBullet e = new EnemyBullet(mainframe, 1, x + width / 2, 0, y + height, 2, 20);
                        e.start();
                        mainframe.enemybullet.add(e);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    bosscrash=0;
                } else if (attack == 5 && rate == 0) {          //boss从一边向另一边连续打子弹
                    movespeed = 0;
                    if (x < 156) {
                        while (x > 0) {
                            x -= 4;
                            try {
                                sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 6,10));
                            while (x < 78) {
                                x += 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 6,10));
                            while (x < 156) {
                                x += 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 6,10));
                            while (x < 234) {
                                x += 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, 6,10));
                            while (x < 312) {
                                x += 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 6,10));

                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else if (x > 156) {
                        while (x < 312) {
                            x += 4;
                            try {
                                sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, 6,10));
                            while (x > 234) {
                                x -= 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 6,10));
                            while (x > 156) {
                                x -= 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, 6,10));
                            while (x > 78) {
                                x -= 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, 6,10));
                            while (x > 0) {
                                x -= 3;
                                sleep(10);
                            }
                            mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 6,10));

                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    bosscrash=0;
                } else if (attack == 6 && rate == 0) {         //boss旋转子弹
                    try {
                        EnemyBullet e = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.0);
                        EnemyBullet e2 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.2);
                        EnemyBullet e3 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.4);
                        EnemyBullet e4 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.6);
                        EnemyBullet e5 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,0.8);
                        EnemyBullet e6 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.0);
                        EnemyBullet e7 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.2);
                        EnemyBullet e8 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.4);
                        EnemyBullet e9 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.6);
                        EnemyBullet e10 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 1.8);
                        mainframe.enemybullet.add(e);
                        mainframe.enemybullet.add(e2);
                        mainframe.enemybullet.add(e3);
                        mainframe.enemybullet.add(e4);
                        mainframe.enemybullet.add(e5);
                        mainframe.enemybullet.add(e6);
                        mainframe.enemybullet.add(e7);
                        mainframe.enemybullet.add(e8);
                        mainframe.enemybullet.add(e9);
                        mainframe.enemybullet.add(e10);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    bosscrash=0;
                } else if (attack == 7 && rate == 0) {        //boss定位导弹

                    Rectangle r;
                    Rectangle r2;
                    while (mainframe.bossFirebowWarnings.size() < 11) {
                        boolean b = true;
                        int randomx = random.nextInt(462);
                        int randomy = random.nextInt(468) + 250;
                        r = new Rectangle(randomx, randomy, 50, 50);
                        for (int i = 0; i < mainframe.bossFirebowWarnings.size(); i++) {
                            r2 = new Rectangle(mainframe.bossFirebowWarnings.get(i).x, mainframe.bossFirebowWarnings.get(i).y, 50, 50);
                            if (r.intersects(r2)) {
                                b = false;
                                break;
                            }
                        }
                        if (b) {
                            BossFirebowWarning boss = new BossFirebowWarning(mainframe, this, randomx, randomy);
                            boss.start();
                            mainframe.bossFirebowWarnings.add(boss);

                        }
                    }

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bosscrash=0;
                }else if(attack==8&&rate==0){           //进入幻境
                    if(mainframe.purgatories.size()==0){
                        Purgatory p=new Purgatory(mainframe,this);
                        p.start();
                        mainframe.purgatories.add(p);
                       double rotationspeed=0.004;
                        try {
                            sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        for(int i=0;i<7;i++){
                           rotationspeed=-rotationspeed;

                           try {
                               EnemyBullet e = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.0,rotationspeed);
                               EnemyBullet e2 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.2,rotationspeed);
                               EnemyBullet e3 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.4,rotationspeed);
                               EnemyBullet e4 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 0.6,rotationspeed);
                               EnemyBullet e5 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,0.8,rotationspeed);
                               EnemyBullet e6 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.0,rotationspeed);
                               EnemyBullet e7 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.2,rotationspeed);
                               EnemyBullet e8 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.4,rotationspeed);
                               EnemyBullet e9 = new EnemyBullet(mainframe, 3, x + width / 2, y + height, 10,1.6,rotationspeed);
                               EnemyBullet e10 = new EnemyBullet(mainframe, 3, x + width / 2, y + height,10, 1.8,rotationspeed);
                               mainframe.enemybullet.add(e);
                               mainframe.enemybullet.add(e2);
                               mainframe.enemybullet.add(e3);
                               mainframe.enemybullet.add(e4);
                               mainframe.enemybullet.add(e5);
                               mainframe.enemybullet.add(e6);
                               mainframe.enemybullet.add(e7);
                               mainframe.enemybullet.add(e8);
                               mainframe.enemybullet.add(e9);
                               mainframe.enemybullet.add(e10);
                           } catch (IOException ioException) {
                               ioException.printStackTrace();
                           }
                           movespeed = random.nextInt(3)+1;
                           move = random.nextInt(4);
                           try {
                               sleep(1400);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                    }

mainframe.bg.ispurgatory=false;

                }else if(attack==9&&rate==0&&mainframe.bossRectangles.size()==0&&mainframe.bossThrowRectangles.size()==0){      //boss扔出禁锢圈
                    BossThrowRectangle b=new BossThrowRectangle(mainframe,x+width/2,y+height);
                    mainframe.bossThrowRectangles.add(b);

                }else if(attack==10&&rate==0&&mainframe.bossDarts.size()==0){   //bossdart
                    BossDart bd=new BossDart(mainframe,this,x+width/2,-5,y+height,7,35);
                    bd.start();
                    mainframe.bossDarts.add(bd);
                    BossDart bd2=new BossDart(mainframe,this,x+width/2,5,y+height,7,35);
                    bd2.start();
                    mainframe.bossDarts.add(bd2);


                }
                movespeed = random.nextInt(3)+1;
                move = random.nextInt(4);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (enemytype == 3 && !isiced) {             //飞机死后会变大速度加快
                r = random.nextInt(3);
                if (r == 0) {
                    try {
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 0, y + height, bulletspeedy,10));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (enemytype == 5 && !isiced) {            //一下打三发敌机
                r = random.nextInt(3);
                if (r == 0) {
                    try {
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, 1, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2, -1, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2, 0, y + height, 4,10));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (enemytype == 6 && !isiced) {          //飞机一下打两发
                r = random.nextInt(3);
                if (r == 0) {
                    try {
                        mainframe.enemybullet.add(new EnemyBullet(mainframe, 0,x + width / 2 - 20, 0, y + height, 4,10));
                        mainframe.enemybullet.add(new EnemyBullet(mainframe,0, x + width / 2 + 20, 0, y + height, 4,10));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (enemytype == 8 && !isiced) {          //敌方飞机打眩晕弹
                r = random.nextInt(3);
                if (r == 0) {
                    try {
                        mainframe.enemybullet.add(new EnemyBullet(mainframe, 4, x + width / 2 - 6, 0, y + height, 4, 30));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (isiced) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void paint(Graphics g) {
        if (enemytype == 1 || enemytype == 4 || enemytype == 5 || enemytype == 6 || enemytype == 7 || enemytype == 8) {
            if (blood > 60) {
                g.setColor(Color.blue);
            } else if (blood > 20 && blood <= 60) {
                g.setColor(Color.yellow);
            } else {
                g.setColor(Color.red);
            }

            g.fillRect(x + 11, y - 3, blood / 2, 5);
            g.drawImage(enemyimg, x += speedx, y += speedy, width, height, null);
        } else if (enemytype == 2) {               //敌机boss
            if (y < 0) {                        //boss出现
                g.setColor(Color.yellow);
                g.drawLine(20, 69, 220, 69);
                g.drawLine(20, 82, 220, 82);
                g.drawLine(19, 70, 19, 82);
                g.drawLine(220, 70, 220, 82);
                if (blood / 40 > 120) {
                    g.setColor(Color.blue);
                } else if (blood / 40 > 40 && blood / 40 <= 120) {
                    g.setColor(Color.yellow);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(20, 70, blood / 40, 12);
                g.drawImage(mainframe.bossenemyimg, x, y += 2, width, height, null);
            } else {
                if (move == 0 && y - movespeed >= 0) {
                    y -= movespeed;
                } else if (move == 1 && y + movespeed < 150) {
                    y += movespeed;
                } else if (move == 2 && x - movespeed >= 0) {
                    x -= movespeed;
                } else if (move == 3 && x + movespeed <= 312) {
                    x += movespeed;
                }
                g.drawImage(mainframe.bossenemyimg, x, y, width, height, null);
                g.setColor(Color.yellow);
                g.drawLine(20, 69, 220, 69);
                g.drawLine(20, 82, 220, 82);
                g.drawLine(19, 70, 19, 82);
                g.drawLine(220, 70, 220, 82);
                if (blood / 40 > 120) {
                    g.setColor(Color.blue);
                } else if (blood / 40 > 40 && blood / 40 <= 120) {
                    g.setColor(Color.yellow);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(20, 70, blood / 40, 12);
            }

        } else if (enemytype == 3) {              //飞机血量低于40时变大速度加快
            if (blood > 60) {
                g.setColor(Color.blue);
            } else if (blood > 20 && blood <= 60) {
                g.setColor(Color.yellow);
            } else {
                g.setColor(Color.red);
            }
            if (blood <= 40 && !isbesetted) {
                x -= 5;
                width += 10;
                y -= 4;
                height += 8;
                speedy += 1;
                isbesetted = true;          //飞机是否已经变大 之后就不在执行变大
                bulletspeedy = 4;
            }
            g.fillRect(x + 6, y - 3, blood / 2, 5);
            g.drawImage(enemyimg, x += speedx, y += speedy, width, height, null);
        }
    }

}


