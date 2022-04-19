

import java.awt.*;
import java.io.IOException;

public class MyPlane extends Thread {
    boolean flag = true;
boolean isinvincible = true;
    boolean isalive = true;
    boolean isbeating = false;
    boolean crash = false;
    boolean iscanmove = true;
    int blood = 100;
    int direction;
    int myplanetype;
    int tempy;
    static int beneficialharm;
    MainFrame mainframe;
    final int speed = 10;
    int x = 200;
    int y = 650;
    int width = 65;
    int height = 51;
    static int energy = 100;
int boderup=35;
int boderdown=707;
int boderleft=0;
int boderright=432;
    public MyPlane(MainFrame m, int myplanetype) throws IOException {
        mainframe = m;
        this.myplanetype = myplanetype;
    }

    public MyPlane(MainFrame m, int myplanetype, int width, int height) throws IOException {
        mainframe = m;
        this.myplanetype = myplanetype;
        this.width = width;
        this.height = height;
        if (myplanetype == 2) {
            this.x = mainframe.myplane.x - 50;
            this.y = mainframe.myplane.y + 20;
            blood = 60;
        } else if (myplanetype == 3) {
            this.x = mainframe.myplane.x + 80;
            this.y = mainframe.myplane.y + 20;
            blood = 60;
        }
    }

    void paint(Graphics g) {
        if (myplanetype == 1) {
            g.setColor(Color.green);
            g.drawLine(390, 63, 490, 63);
            g.drawLine(389, 63, 389, 69);
            g.drawLine(490, 63, 490, 69);
            g.drawLine(390, 69, 490, 69);
            if (energy > 100) {
                energy = 100;
            }
            g.fillRect(390, 63, energy, 6);
            g.drawImage(mainframe.myplaneimg, x, y, width, height, null);
        } else if (myplanetype == 2) {
            this.x = mainframe.myplane.x - 50;
            this.y = mainframe.myplane.y + 20;
            g.drawImage(mainframe.littleplane, x, y, width, height, null);
        } else if (myplanetype == 3) {
            this.x = mainframe.myplane.x + 70;
            this.y = mainframe.myplane.y + 20;
            g.drawImage(mainframe.littleplane, x, y, width, height, null);
        }
    }

    @Override
    public void run() {
        while (flag) {
            if (iscanmove) {
                if (myplanetype == 1) {          //主飞机
                    if (!crash) {
                        if (direction == 1 && y >= boderup) {
                            y -= speed;
                        } else if (direction == 2 && y < boderdown) {
                            y += speed;
                        } else if (direction == 3 && x > boderleft) {
                            x -= speed;
                        } else if (direction == 4 && x < boderright) {
                            x += speed;
                        }
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            planehitenemy();
                            planehitenemybullet();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        isinvincible = true;
                        mainframe.crash = true;
                        tempy = y;
                        while (y > tempy - 170 && y - 30 >= boderup) {
                            y -= 12;
                            try {
                                planehitenemy();
                                planehitenemybullet();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        crash = false;
                        mainframe.crash = false;
                        Crash c = new Crash(mainframe);
                        c.start();
                        mainframe.crashvector.add(c);
                    }
                } else if (myplanetype == 2) {         //僚机
                    try {
                        mainframe.bullet.add(new Bullet(mainframe, x + 20, 0, y, 15, 15, 15));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (myplanetype == 3) {        //僚机
                    try {
                        mainframe.bullet.add(new Bullet(mainframe, x + 20, 0, y, 15, 15, 15));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void planehitenemy() throws IOException {   //我方飞机撞到敌机
        Rectangle plane = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemy;
        boolean temp = false;
        for (int i = 0; i < mainframe.enemyFuryPlanes.size(); i++) {            //是否撞到狂暴飞机
            EnemyFuryPlane e = mainframe.enemyFuryPlanes.get(i);
            enemy = new Rectangle(e.x, e.y, e.width, e.height);
            if (plane.intersects(enemy)) {
                Bomb b = new Bomb(mainframe, e.x, e.y + 10, e.width, e.height);
                b.start();
                mainframe.bomb.add(b);
                mainframe.enemyFuryPlanes.remove(e);
                if (!isinvincible) {
                    blood -= Enemy.harm;
                    if (blood <= 0 ) {           //这里最后还需要完善
                        Bomb b2 = new Bomb(mainframe, x, y, width, height);
                        b2.start();
                        mainframe.bomb.add(b2);
                        flag = false;
                        mainframe.mylittleplane.remove(this);
                        if(myplanetype==1){
                            GameOver g=new GameOver(mainframe,2);
                            g.start();
                        }
                    }
                }

            }
        }
        for (int i = 0; i < mainframe.enemy.size(); i++) {
            Enemy e = mainframe.enemy.get(i);
            enemy = new Rectangle(e.x, e.y, e.width, e.height);

            if (plane.intersects(enemy)) {
                temp = true;
                if (!isbeating) {
                    if (e.enemytype != 2) {
                        Bomb b = new Bomb(mainframe, e.x, e.y, e.width, e.height);
                        b.start();
                        mainframe.bomb.add(b);
                        e.flag = false;
                        e.isalive = false;
                        mainframe.enemy.remove(e);
                    }

                    if (!isinvincible) {
                        blood -= Enemy.harm;
                        if (blood <= 0 ) {
                            Bomb b2 = new Bomb(mainframe, x, y, width, height);
                            b2.start();
                            mainframe.bomb.add(b2);
                            flag = false;
                            mainframe.mylittleplane.remove(this);
                            if(myplanetype==1){
                                GameOver g=new GameOver(mainframe,2);
                                g.start();
                            }
                        }
                    }
                    isbeating = true;
                }

            }

        }
        if (!temp) {
            isbeating = false;
        }

    }

    void planehitenemybullet() throws IOException {   //我方飞机撞到敌方子弹
        Rectangle plane = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemybullet;
        for (int i = 0; i < mainframe.enemybullet.size(); i++) {
            EnemyBullet e = mainframe.enemybullet.get(i);
            enemybullet = new Rectangle(e.x, e.y, e.range, e.range);
            if (plane.intersects(enemybullet)) {
                if (e.enemybullettype == 4) {
                    if (mainframe.immobilizes.size() == 0) {
                        Immobilize immo = new Immobilize(this, mainframe);
                        immo.start();
                        mainframe.immobilizes.add(immo);
                    }

                } else {
                    Bomb b = new Bomb(mainframe, e.x, e.y, e.range, e.range);
                    b.start();
                    mainframe.bomb.add(b);
                }

                mainframe.enemybullet.remove(e);
                if (!isinvincible) {
                    blood -= EnemyBullet.harm;
                    if (blood <= 0 ) {
                        Bomb b2 = new Bomb(mainframe, x, y, width, height);
                        b2.start();
                        mainframe.bomb.add(b2);
                        flag = false;
                        mainframe.mylittleplane.remove(this);
                        if(myplanetype==1){
                            GameOver g=new GameOver(mainframe,2);
                            g.start();
                        }
                    }
                }


            }

        }
    }
}
