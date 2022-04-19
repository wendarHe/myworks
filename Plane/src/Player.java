

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Player extends KeyAdapter {
    int VeaponType = 9;
    MainFrame mainframe;
    int scattershottimes = 0;
int beginx;int beginy;int endx;int endy;
    public Player(MainFrame m) {
        mainframe = m;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        //System.out.println(keycode);
        switch (keycode) {
            case 10:             //enter键开始游戏
                mainframe.isgamebegin=true;
                break;
            case 16:            //shift键 切换子弹
                try {
                    Swing f = new Swing(mainframe);
                    f.start();
                    scattershottimes = 0;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                mainframe.timeinterval = true;
                if (VeaponType < 10) {
                    VeaponType++;
                    if (VeaponType == 10) {
                        Accumulator a = new Accumulator(mainframe);
                        a.start();
                        mainframe.accumulators.add(a);
                    }


                } else if (VeaponType == 10) {
                    VeaponType = 1;
                    mainframe.accumulators.remove(0);
                }
                break;
            case 38:           //上键

                mainframe.myplane.direction = 1;

                break;
            case 40:           //下键

                mainframe.myplane.direction = 2;

                break;
            case 37:            //左键

                mainframe.myplane.direction = 3;

                break;
            case 39:          //右键

                mainframe.myplane.direction = 4;

                break;
            case 32:            //空格键发射子弹
                if (mainframe.timeinterval&&mainframe.myplane.iscanmove) {
                    if (VeaponType == 1) {
                        try {
                            addbullet();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 200);
                        t.start();
                    } else if (VeaponType == 2) {
                        try {
                            addbullet2();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 400);
                        t.start();
                    } else if (VeaponType == 3) {
                        try {
                            addbullet3();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 400);
                        t.start();
                    } else if (VeaponType == 4) {
                        try {
                            addbullet4();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 400);
                        t.start();
                    } else if (VeaponType == 5) {
                        try {
                            addbullet5();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 400);
                        t.start();
                    } else if (VeaponType == 6) {
                        try {
                            MissileShoot m = new MissileShoot(mainframe);
                            m.start();
                            addguidedmssile();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 400);
                        t.start();
                    } else if (VeaponType == 7) {
                        addarrowbullet();
                        TimeInterval t = new TimeInterval(mainframe, 380);
                        t.start();
                    } else if (VeaponType == 8) {
                        if (scattershottimes != 4) {
                            addscattershot();
                            TimeInterval t = new TimeInterval(mainframe, 500);
                            t.start();
                            scattershottimes++;
                        } else if (scattershottimes == 4) {
                            ScatterShot s1 = new ScatterShot(mainframe, 10);
                            s1.start();
                            scattershottimes = 0;
                            TimeInterval t = new TimeInterval(mainframe, 500);
                            t.start();
                        }

                    } else if (VeaponType == 9) {
                        try {
                            addfirebullet();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        TimeInterval t = new TimeInterval(mainframe, 400);
                        t.start();
                    } else if (VeaponType == 10) {
                        addaccumutebow();
                    }
                }


                break;
            case 74:
               if (MyPlane.energy >=40&&!mainframe.isshield) {
                    try {
                        Shield s = new Shield(mainframe);
                        s.start();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
//                    MyPlane.energy -=40;
                }

                break;
            case 75:
               if (MyPlane.energy == 100&& mainframe.lightbow.size()==0&&mainframe.lightBowBefores.size()==0) {

                        LightBowBefore l=new LightBowBefore(mainframe);
                        mainframe.lightBowBefores.add(l);
//                    MyPlane.energy -=100;
               }
                break;
            case 76:
               if (MyPlane.energy >= 60&&mainframe.mylittleplane.size()==1) {
                    try {
                        addlittleplane();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
//                   MyPlane.energy -=60;
               }
                break;
            case 72:
               if (MyPlane.energy >= 80&&mainframe.movecircle.size()==0) {
                    MoveCircle m = new MoveCircle(mainframe);
                    m.start();
                    mainframe.movecircle.add(m);
//                   MyPlane.energy -=80;
                }
                break;
            case 71:
                if(MyPlane.energy>=30&& !mainframe.myplane.crash){
                    mainframe.myplane.crash = true;
//                    MyPlane.energy-=30;
                }

                break;
            case 70:

                if(MyPlane.energy==100&&mainframe.bounceBows.size()==0){
                    addbouncebow();
//                    MyPlane.energy-=100;
                }else if(mainframe.bounceBows.size()==1){
                    hitbouncebow();
                }

                break;
            case 68:
                if(MyPlane.energy>=70&&mainframe.lasers.size()==0){
                    addlaser();
//                    MyPlane.energy-=70;
                }


                break;
            case 83:
                if(MyPlane.energy>=50&&mainframe.roundBullets.size()==0){
                    addroundbullet();
//                    MyPlane.energy-=50;
                }

                break;
            case 65:
                if (MyPlane.energy>=50&&mainframe.icedinterval.size() == 0) {
                    addice();
//                    MyPlane.energy-=50;
                }

                break;
            case  77:
                if(mainframe.deadlyFourBullets.size()==0&&MyPlane.energy>=70){
                    DeadlyFourBullet d=new DeadlyFourBullet(mainframe);
                    mainframe.deadlyFourBullets.add(d);
//                    MyPlane.energy-=70;
                }else if(mainframe.deadlyFourBullets.size()==1){
                   beginx=mainframe.myplane.x+mainframe.myplane.width/2;
                   beginy=mainframe.myplane.y;
                   endx=mainframe.begin.x;
                   endy=mainframe.begin.y;
                    if(Math.abs(endy-beginy)> Math.abs(endx-beginx)&&endy<=beginy){
                        DeadlyFourBulletFire d=new DeadlyFourBulletFire(mainframe,beginx,beginy,endx,endy);
                        mainframe.deadlyFourBulletFires.add(d);
                        mainframe.deadlyFourBullets.get(0).count-=1;
                        if( mainframe.deadlyFourBullets.get(0).count==0){
                            mainframe.deadlyFourBullets.remove(0);
                        }
                    }


                }

                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {         //松开按键direction = 0
        mainframe.myplane.direction = 0;
    }

    void addbullet() throws IOException {
        Bullet b = new Bullet(mainframe, 0, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);

        mainframe.bullet.add(b);
    }

    void addbullet2() throws IOException {

        Bullet b3 = new Bullet(mainframe, 0, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
        mainframe.bullet.add(b3);
        Bullet b2 = new Bullet(mainframe, -2, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
        mainframe.bullet.add(b2);
        Bullet b1 = new Bullet(mainframe, 2, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
        mainframe.bullet.add(b1);

    }

    void addbullet3() throws IOException {
        BulletofTurnRight b = new BulletofTurnRight(mainframe, 10, 9, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
        b.start();
        mainframe.bulletofturnright.add(b);
        BulletofTurnRight b2 = new BulletofTurnRight(mainframe, -10, 8, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
        b2.start();
        mainframe.bulletofturnright.add(b2);
    }

    void addbullet4() throws IOException {
        Bullet2 b = new Bullet2(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, mainframe.myplane.y - 15);
        //b.start();
        mainframe.bullet2.add(b);
    }

    void addbullet5() throws IOException {
        Bullet3 b = new Bullet3(mainframe, 0, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
        mainframe.bullet3.add(b);
    }

    void addguidedmssile() throws IOException {
        if (mainframe.enemy.size() != 0) {
            GuidedMisssile g = new GuidedMisssile(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2 - 10, mainframe.myplane.y - 15);
            mainframe.guidedmissile.add(g);
        }
        if (mainframe.enemy.size() != 0) {
            GuidedMisssile g2 = new GuidedMisssile(mainframe, mainframe.myplane.x - 15, mainframe.myplane.y);
            mainframe.guidedmissile.add(g2);
        }
        if (mainframe.enemy.size() != 0) {
            GuidedMisssile g3 = new GuidedMisssile(mainframe, mainframe.myplane.x + mainframe.myplane.width, mainframe.myplane.y);
            mainframe.guidedmissile.add(g3);
        }

    }

    void addlittleplane() throws IOException {
        MyPlane m = new MyPlane(mainframe, 2, 50, 39);
        LittlePlaneVanish l = new LittlePlaneVanish(mainframe, m);
        l.start();
        m.start();
        mainframe.mylittleplane.add(m);
        MyPlane m2 = new MyPlane(mainframe, 3, 50, 39);
        LittlePlaneVanish l2 = new LittlePlaneVanish(mainframe, m2);
        l2.start();
        m2.start();
        mainframe.mylittleplane.add(m2);
    }

    void addarrowbullet() {
        ArrowBullet a = new ArrowBullet(mainframe, mainframe.myplane.x + 19, mainframe.myplane.y - 40, 6);
        mainframe.arrowbullet.add(a);
    }

    void addscattershot() {
        ScatterShot s1 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, -2, mainframe.myplane.y, 10, 8);
        ScatterShot s2 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, -1, mainframe.myplane.y, 10, 10);
        ScatterShot s3 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 0, mainframe.myplane.y, 10, 12);
        ScatterShot s4 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 1, mainframe.myplane.y, 10, 14);
        ScatterShot s5 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 2, mainframe.myplane.y, 10, 12);
        ScatterShot s6 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, -3, mainframe.myplane.y, 10, 10);
        ScatterShot s7 = new ScatterShot(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, 3, mainframe.myplane.y, 10, 8);
        mainframe.scattershot.add(s1);
        mainframe.scattershot.add(s2);
        mainframe.scattershot.add(s3);
        mainframe.scattershot.add(s4);
        mainframe.scattershot.add(s5);
        mainframe.scattershot.add(s6);
        mainframe.scattershot.add(s7);
    }

    void addfirebullet() throws IOException {
        BulletFire b = new BulletFire(mainframe, 0, mainframe.myplane.x + mainframe.myplane.width / 2 - 17, mainframe.myplane.y);
        mainframe.bulletFires.add(b);
    }

    void addbouncebow() {

            if (mainframe.myplane.x > 312) {
                BounceBow b = new BounceBow(mainframe, 312, 6, 200, 167);
                mainframe.bounceBows.add(b);
            } else {
                BounceBow b = new BounceBow(mainframe, mainframe.myplane.x, 6, 200, 167);
                mainframe.bounceBows.add(b);
            }

    }
void hitbouncebow(){
    BounceBow b = mainframe.bounceBows.get(0);
    Rectangle r = new Rectangle(b.x, b.y, b.width, b.height);
    Rectangle r2 = new Rectangle(mainframe.myplane.x, mainframe.myplane.y, mainframe.myplane.width, mainframe.myplane.height);
    if (r.intersects(r2) && !b.issetted) {
        b.issetted = true;
    }
}
    void addlaser() {
        Laser l = new Laser(mainframe);
        l.start();
        mainframe.lasers.add(l);
    }

    void addroundbullet() {
        RoundBullet r = new RoundBullet(mainframe);
        r.start();
        mainframe.roundBullets.add(r);
    }

    void addice() {
        Ice ic = new Ice(mainframe, mainframe.myplane.x + mainframe.myplane.width / 2, mainframe.myplane.y + mainframe.myplane.height / 2);
        mainframe.ice.add(ic);
        IcedInterval ii = new IcedInterval(mainframe);
        ii.start();
        mainframe.icedinterval.add(ii);
    }

    void addaccumutebow() {
        if (mainframe.accumulatenumber >= 20) {
            AccumulateBow a = new AccumulateBow(mainframe, mainframe.myplane.y, 10);
            mainframe.accumulateBows.add(a);
            mainframe.accumulatenumber = 0;
        }
    }
}
