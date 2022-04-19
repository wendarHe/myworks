

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class MainFrame extends JFrame {

//    BufferedImage bgnormalimg = ImageIO.read(new File("src\\image\\bg2.jpg"));
//   // BufferedImage bgnormalimg = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\bg2.jpg"));
//    BufferedImage bgpurgatoryimg = ImageIO.read(new File("D:\\钉钉\\images\\background1.bmp"));
//    BufferedImage startimg = ImageIO.read(new File("D:\\钉钉\\images\\start.bmp"));
//    BufferedImage playbuttonimg = ImageIO.read(new File("D:\\图片\\start02.png"));
//    BufferedImage playbuttonpresedimg = ImageIO.read(new File("D:\\图片\\start04.png"));
//    BufferedImage helpimg = ImageIO.read(new File("D:\\图片\\help03.png"));
//    BufferedImage helptextimg = ImageIO.read(new File("D:\\图片\\helptext02.jpg"));
//    BufferedImage help02img = ImageIO.read(new File("D:\\图片\\help04.png"));
//    BufferedImage back01img = ImageIO.read(new File("D:\\图片\\back01.png"));
//    BufferedImage back02img = ImageIO.read(new File("D:\\图片\\back02.png"));
//    BufferedImage bullet3img = ImageIO.read(new File("D:\\钉钉\\img\\fire.png"));
//    BufferedImage bulletimg = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\die04.png"));
//    BufferedImage fs = ImageIO.read(new File("D:\\图片\\swing.png"));//swing
//    boolean ischangeveapon = false;
//    BufferedImage shield = ImageIO.read(new File("D:\\图片\\shield2.png"));//shield
//    boolean isshield = false;
//    BufferedImage bombimg = ImageIO.read(new File("D:\\图片\\bomb1.png"));
//    BufferedImage enemy1img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy07.png"));
//    BufferedImage myplaneimg = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\myplane.png"));
//    BufferedImage littleplane = ImageIO.read(new File("D:\\钉钉\\images\\plane2.png"));
//    BufferedImage lightbowimg = ImageIO.read(new File("D:\\图片\\lightbow2.png"));
//    BufferedImage lightbowleftimg = ImageIO.read(new File("D:\\图片\\lightbowleft02.png"));
//    BufferedImage lightbowupimg = ImageIO.read(new File("D:\\图片\\lightbowup02.png"));
//    BufferedImage lightbowrightimg = ImageIO.read(new File("D:\\图片\\lightbowright02.png"));
//    BufferedImage lightbowdownimg = ImageIO.read(new File("D:\\图片\\lightbowdown02.png"));
//    BufferedImage enemybulletimg = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\die04.png"));//
//    BufferedImage bulletofturnrightimg = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\die04.png"));//
//    BufferedImage arrowimg = ImageIO.read(new File("D:\\图片\\arrow.png"));
//    BufferedImage sixstarimg = ImageIO.read(new File("D:\\图片\\sixstar.png"));
//    BufferedImage enemyimg2 = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy08.png"));
//    BufferedImage warningimg = ImageIO.read(new File("D:\\图片\\warning2.png"));
//    BufferedImage bloodbottleimg = ImageIO.read(new File("D:\\图片\\bloodbottle2.png"));
//    BufferedImage harmbenificialimg = ImageIO.read(new File("D:\\图片\\harmbeneficial.png"));
//    BufferedImage green = ImageIO.read(new File("D:\\图片\\green.png"));
//    BufferedImage purple = ImageIO.read(new File("D:\\图片\\purple2.png"));
//    BufferedImage redbomb = ImageIO.read(new File("D:\\图片\\紫色光圈.png"));
//    BufferedImage enemy01img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy05.png"));
//    BufferedImage enemy02img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy01.png"));
//    BufferedImage enemy03img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy09.png"));
//    BufferedImage enemy04img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy02.png"));
//    BufferedImage enemy05img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy06.png"));
//    BufferedImage enemy05plusimg = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy06狂怒.png"));
//    BufferedImage enemy06img = ImageIO.read(new File("D:\\钉钉\\图片素材\\img\\enemy03.png"));
//    BufferedImage gm = ImageIO.read(new File("D:\\图片\\guidedmissile02.png"));
//    //Image iginitionimg = Toolkit.getDefaultToolkit().getImage("D:\\图片\\飞机起火gif.gif");
//    Image iginitionimg = Toolkit.getDefaultToolkit().getImage("src\\image\\飞机起火gif.gif");
//    BufferedImage missileshoot = ImageIO.read(new File("D:\\图片\\missileshoot04.png"));
//    BufferedImage bluecircleimg = ImageIO.read(new File("D:\\图片\\bluecircleimg.png"));
//    BufferedImage crashswingimg = ImageIO.read(new File("D:\\图片\\crashswing.png"));
//    BufferedImage crashfireimg = ImageIO.read(new File("D:\\图片\\crashfire.png"));
//    BufferedImage firebowimg = ImageIO.read(new File("D:\\图片\\火球.png"));
//    BufferedImage aimingimg = ImageIO.read(new File("D:\\图片\\瞄准\\瞄准.png"));
//    BufferedImage planefirebowimg = ImageIO.read(new File("D:\\图片\\火焰波02.png"));
//    BufferedImage bouncebowimg01 = ImageIO.read(new File("D:\\图片\\反弹波\\反弹波01.png"));
//    BufferedImage bouncebowimg02 = ImageIO.read(new File("D:\\图片\\反弹波\\反弹波02.png"));
//    BufferedImage fivestarimg = ImageIO.read(new File("D:\\图片\\五角星04.png"));
//    BufferedImage immobilizeimg = ImageIO.read(new File("D:\\图片\\眩晕.png"));
//    Image laserfireGIF = Toolkit.getDefaultToolkit().getImage("D:\\图片\\激光火焰gif.gif");
//    BufferedImage accumutebowimg = ImageIO.read(new File("D:\\图片\\蓄力波3.png"));
//    // Image firebomingimg=Toolkit.getDefaultToolkit().getImage("D:\\图片\\火焰喷发01.gif" );
//    BufferedImage circleimg = ImageIO.read(new File("D:\\图片\\圆环02.png"));
//    BufferedImage victoryimg = ImageIO.read(new File("D:\\图片\\奖杯01.png"));
//    BufferedImage failerimg = ImageIO.read(new File("D:\\图片\\失败01.png"));
//    BufferedImage prugatoryimg = ImageIO.read(new File("D:\\图片\\彩色光环01.png"));
//    BufferedImage bossrectangleimg = ImageIO.read(new File("D:\\图片\\bossrectangle.png"));
//    BufferedImage bossrectangle02img = ImageIO.read(new File("D:\\图片\\rectangle.png"));
//    BufferedImage aimdeadlybulletimg = ImageIO.read(new File("D:\\图片2\\瞄准02.png"));
//    BufferedImage bossenemyimg = ImageIO.read(new File("D:\\图片2\\boss.png"));
//    BufferedImage deadlybulletimg = ImageIO.read(new File("D:\\图片2\\致命子弹02.png"));

    BufferedImage bgnormalimg = ImageIO.read(new File("src\\image\\bg2.jpg"));
    //BufferedImage bgpurgatoryimg = ImageIO.read(new File("src\\image\\background1.bmp"));
    BufferedImage bgpurgatoryimg = ImageIO.read(new File("src\\image\\bg5.jpg"));
    BufferedImage startimg = ImageIO.read(new File("src\\image\\start.bmp"));
    BufferedImage playbuttonimg = ImageIO.read(new File("src\\image\\start02.png"));
    BufferedImage playbuttonpresedimg = ImageIO.read(new File("src\\image\\start04.png"));
    BufferedImage helpimg = ImageIO.read(new File("src\\image\\help03.png"));
    BufferedImage helptextimg = ImageIO.read(new File("src\\image\\helptext02.jpg"));
    BufferedImage help02img = ImageIO.read(new File("src\\image\\help04.png"));
    BufferedImage back01img = ImageIO.read(new File("src\\image\\back01.png"));
    BufferedImage back02img = ImageIO.read(new File("src\\image\\back02.png"));
    BufferedImage bullet3img = ImageIO.read(new File("src\\image\\fire.png"));
    BufferedImage bulletimg = ImageIO.read(new File("src\\image\\die04.png"));
    BufferedImage fs = ImageIO.read(new File("src\\image\\swing.png"));//swing
    boolean ischangeveapon = false;
    BufferedImage shield = ImageIO.read(new File("src\\image\\shield2.png"));//shield
    boolean isshield = false;
    BufferedImage bombimg = ImageIO.read(new File("src\\image\\bomb1.png"));
    BufferedImage enemy1img = ImageIO.read(new File("src\\image\\enemy07.png"));
    BufferedImage myplaneimg = ImageIO.read(new File("src\\image\\myplane.png"));
    BufferedImage littleplane = ImageIO.read(new File("src\\image\\plane2.png"));
    BufferedImage lightbowimg = ImageIO.read(new File("src\\image\\lightbow2.png"));
    BufferedImage lightbowleftimg = ImageIO.read(new File("src\\image\\lightbowleft02.png"));
    BufferedImage lightbowupimg = ImageIO.read(new File("src\\image\\lightbowup02.png"));
    BufferedImage lightbowrightimg = ImageIO.read(new File("src\\image\\lightbowright02.png"));
    BufferedImage lightbowdownimg = ImageIO.read(new File("src\\image\\lightbowdown02.png"));
    BufferedImage enemybulletimg = ImageIO.read(new File("src\\image\\die04.png"));//
    BufferedImage bulletofturnrightimg = ImageIO.read(new File("src\\image\\die04.png"));//
    BufferedImage arrowimg = ImageIO.read(new File("src\\image\\arrow.png"));
    BufferedImage sixstarimg = ImageIO.read(new File("src\\image\\sixstar.png"));
    BufferedImage enemyimg2 = ImageIO.read(new File("src\\image\\enemy08.png"));
    BufferedImage warningimg = ImageIO.read(new File("src\\image\\warning2.png"));
    BufferedImage bloodbottleimg = ImageIO.read(new File("src\\image\\bloodbottle2.png"));
    BufferedImage harmbenificialimg = ImageIO.read(new File("src\\image\\harmbeneficial.png"));
    BufferedImage green = ImageIO.read(new File("src\\image\\green.png"));
    BufferedImage purple = ImageIO.read(new File("src\\image\\purple2.png"));
    BufferedImage redbomb = ImageIO.read(new File("src\\image\\紫色光圈.png"));
    BufferedImage enemy01img = ImageIO.read(new File("src\\image\\enemy05.png"));
    BufferedImage enemy02img = ImageIO.read(new File("src\\image\\enemy01.png"));
    BufferedImage enemy03img = ImageIO.read(new File("src\\image\\enemy09.png"));
    BufferedImage enemy04img = ImageIO.read(new File("src\\image\\enemy02.png"));
    BufferedImage enemy05img = ImageIO.read(new File("src\\image\\enemy06.png"));
    BufferedImage enemy05plusimg = ImageIO.read(new File("src\\image\\enemy06狂怒.png"));
    BufferedImage enemy06img = ImageIO.read(new File("src\\image\\enemy03.png"));
    BufferedImage gm = ImageIO.read(new File("src\\image\\guidedmissile02.png"));
    Image iginitionimg = Toolkit.getDefaultToolkit().getImage("src\\image\\飞机起火gif.gif");
    BufferedImage missileshoot = ImageIO.read(new File("src\\image\\missileshoot04.png"));
    BufferedImage bluecircleimg = ImageIO.read(new File("src\\image\\bluecircleimg.png"));
    BufferedImage crashswingimg = ImageIO.read(new File("src\\image\\crashswing.png"));
    BufferedImage crashfireimg = ImageIO.read(new File("src\\image\\crashfire.png"));
    BufferedImage firebowimg = ImageIO.read(new File("src\\image\\火球.png"));
    BufferedImage aimingimg = ImageIO.read(new File("src\\image\\瞄准.png"));
    BufferedImage planefirebowimg = ImageIO.read(new File("src\\image\\火焰波02.png"));
    BufferedImage bouncebowimg01 = ImageIO.read(new File("src\\image\\反弹波01.png"));
    BufferedImage bouncebowimg02 = ImageIO.read(new File("src\\image\\反弹波02.png"));
    BufferedImage fivestarimg = ImageIO.read(new File("src\\image\\五角星04.png"));
    BufferedImage immobilizeimg = ImageIO.read(new File("src\\image\\眩晕.png"));
    Image laserfireGIF = Toolkit.getDefaultToolkit().getImage("src\\image\\激光火焰gif.gif");
    BufferedImage accumutebowimg = ImageIO.read(new File("src\\image\\蓄力波3.png"));
    BufferedImage circleimg = ImageIO.read(new File("src\\image\\圆环02.png"));
    BufferedImage victoryimg = ImageIO.read(new File("src\\image\\奖杯01.png"));
    BufferedImage failerimg = ImageIO.read(new File("src\\image\\失败01.png"));
    BufferedImage prugatoryimg = ImageIO.read(new File("src\\image\\彩色光环01.png"));
    BufferedImage bossrectangleimg = ImageIO.read(new File("src\\image\\bossrectangle.png"));
    BufferedImage bossrectangle02img = ImageIO.read(new File("src\\image\\rectangle.png"));
    BufferedImage aimdeadlybulletimg = ImageIO.read(new File("src\\image\\瞄准02.png"));
    BufferedImage bossenemyimg = ImageIO.read(new File("src\\image\\boss.png"));
    BufferedImage deadlybulletimg = ImageIO.read(new File("src\\image\\致命子弹02.png"));
    Blood blood = new Blood(this);
    int sleeptime = 1000;
    static int score = 0;
    int accumulatenumber = 60;
    boolean isbosscome = false;
    boolean iswarning = false;
    boolean isaddblood = false;
    boolean timeinterval = true;
    boolean ismissileshoot = false;
    boolean crash = false;
    boolean isiced = false;
    boolean isgamebegin=false;
   int gameover=0;
    MainFrame mainframe;
    Image offscreen;
    Vector<Enemy> enemy = new Vector<>();
    Vector<Bullet> bullet = new Vector<>();
    Vector<Bomb> bomb = new Vector<>();
    Vector<EnemyBullet> enemybullet = new Vector<>();
    Vector<BulletofTurnRight> bulletofturnright = new Vector<>();
    Vector<Bullet2> bullet2 = new Vector<>();
    Vector<DrawLine> drawline = new Vector<>();
    Vector<Bullet3> bullet3 = new Vector<>();
    Vector<GuidedMisssile> guidedmissile = new Vector<>();
    Vector<LightBow> lightbow = new Vector<>();
    Vector<ArrowBullet> arrowbullet = new Vector<>();
    Vector<MyPlane> mylittleplane = new Vector<>();
    Vector<SlowEnemySpeed> slowenemyspeed = new Vector<>();
    Vector<BloodBottle> bloodbottle = new Vector<>();
    Vector<HarmBeneficial> harmbeneficial = new Vector<>();
    Vector<AddBlood> addblood = new Vector<>();
    Vector<EnemyBullet2> enemyBullet2 = new Vector<>();
    Vector<DrawLineHarm> drawlineharm = new Vector<>();
    Vector<MoveCircle> movecircle = new Vector<>();
    Vector<ScatterShot> scattershot = new Vector<>();
    Vector<Crash> crashvector = new Vector<>();
    Vector<BossFirebowWarning> bossFirebowWarnings = new Vector<>();
    Vector<BulletFire> bulletFires = new Vector<>();
    Vector<Iginition> iginitions = new Vector<>();
    Vector<BounceBow> bounceBows = new Vector<>();
    Vector<Laser> lasers = new Vector<>();
    Vector<EnemyFuryPlane> enemyFuryPlanes = new Vector<>();
    Vector<Immobilize> immobilizes = new Vector<>();
    Vector<RoundBullet> roundBullets = new Vector<>();
    Vector<Ice> ice = new Vector<>();
    Vector<Iced> iced = new Vector<>();
    Vector<IcedInterval> icedinterval = new Vector<>();
    Vector<Accumulator> accumulators = new Vector<>();
    Vector<AccumulateBow> accumulateBows = new Vector<>();
    Vector<Purgatory>purgatories=new Vector<>();
    Vector<LightBowBefore>lightBowBefores=new Vector<>();
Vector<BossRectangle>bossRectangles=new Vector<>();
Vector<BossThrowRectangle>bossThrowRectangles=new Vector<>();
Vector<DeadlyFourBullet>deadlyFourBullets=new Vector<>();
    Vector<DeadlyFourBulletFire>deadlyFourBulletFires=new Vector<>();
    Vector<BossDart>bossDarts=new Vector<>();
    MyPlane myplane = new MyPlane(this, 1);
    BackGround bg = new BackGround(this);
    Player player = new Player(this);
    Begin begin=new Begin(this);
    Waring waring = new Waring(this);
    DartImage dart=new DartImage();
    Random r = new Random();

    public MainFrame() throws IOException {

        mainframe = this;
        setPreferredSize(new Dimension(512, 768));
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(player);
        addMouseListener(begin.mm);
        addMouseMotionListener(begin.mm);
        myplane.start();
mylittleplane.add(myplane);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                        repaint();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (score >=2 && !isbosscome) {  //********
                            waring.start();
                            isbosscome = true;
                            sleeptime = 3000;
                        }

                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                  if(isgamebegin&&gameover==0&&!bg.ispurgatory){
                      if (!isiced) {                 //检测是否被冰冻

                          int ran = r.nextInt(430);       //随机生成敌机x坐标
                          int enemyrandow = r.nextInt(8);    //随机生成敌机类型

                          try {
                              Enemy en = null;
                              if (enemyrandow == 0 || enemyrandow == 1) {
                                  en = new Enemy(mainframe, enemy1img, 1, ran, 0, 0, 2, 70, 50, 100);
                                  en.start();
                                  enemy.add(en);


                              } else if (enemyrandow == 2) {
                                  en = new Enemy(mainframe, enemyimg2, 3, ran, 0, 0, 2, 60, 46, 100);
                                  en.start();
                                  enemy.add(en);


                              } else if (enemyrandow == 3) {
                                  en = new Enemy(mainframe, enemy01img, 4, ran, 0, 0, 2, 60, 45, 100);
                                  en.start();
                                  enemy.add(en);


                              } else if (enemyrandow == 4) {
                                  en = new Enemy(mainframe, enemy02img, 5, ran, 0, 0, 2, 65, 47, 100);
                                  en.start();
                                  enemy.add(en);


                              } else if (enemyrandow == 5) {
                                  en = new Enemy(mainframe, enemy04img, 6, ran, 0, 0, 2, 70, 54, 100);
                                  en.start();
                                  enemy.add(en);

                              } else if (enemyrandow == 6) {
                                  en = new Enemy(mainframe, enemy05img, 7, ran, 0, 0, 2, 80, 55, 100);
                                  en.start();
                                  enemy.add(en);

                              } else if (enemyrandow == 7) {
                                  en = new Enemy(mainframe, enemy06img, 8, ran, 0, 0, 2, 70, 53, 100);
                                  en.start();
                                  enemy.add(en);
                              }

                              for (int i = 0; i < lightbow.size(); i++) {
                                  lightbow.get(i).copyenemy.add(en);
                              }
                              for (int i = 0; i < arrowbullet.size(); i++) {
                                  arrowbullet.get(i).copyenemy.add(en);
                              }
                              for (int i = 0; i < movecircle.size(); i++) {
                                  movecircle.get(i).enemy.add(en);
                              }
                              for (int i = 0; i < bulletFires.size(); i++) {
                                  bulletFires.get(i).copyenemy.add(en);
                              }
                              for (int i = 0; i < bounceBows.size(); i++) {
                                  bounceBows.get(i).copyenemy.add(en);
                              }
                              for (int i = 0; i < bullet2.size(); i++) {
                                  bullet2.get(i).copyenemy.add(en);
                              }
                              for (int i = 0; i < ice.size(); i++) {
                                  ice.get(i).enemy.add(en);
                              }

                          } catch (IOException e) {
                              e.printStackTrace();
                          }
                          try {
                              Thread.sleep(sleeptime);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      } else {
                          try {
                              Thread.sleep(10);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }

                  }else{
                      try {
                          Thread.sleep(10);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {

        offscreen = this.createImage(512, 768);
        Graphics gr = offscreen.getGraphics();
        if(isgamebegin&&gameover==0){

            bg.paint(gr);

            for(int i=0;i<purgatories.size();i++){
                Purgatory p=purgatories.get(i);
                p.paint(gr);
            }
            for(int i=0;i<lightBowBefores.size();i++){
                LightBowBefore l=lightBowBefores.get(i);
                try {
                    l.paint(gr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for(int i=0;i<bossRectangles.size();i++){
                BossRectangle b=bossRectangles.get(i);
                b.paint(gr);
            }
            for (int i = 0; i < mylittleplane.size(); i++) {
                MyPlane m = mylittleplane.get(i);
                if (!m.isalive) {
                    mylittleplane.remove(i);
                } else {
                    try {
                        m.planehitenemy();
                        m.planehitenemybullet();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    m.paint(gr);
                }
            }

            for (DrawLine d : drawline) {             //激光画线
                d.paint(gr);
            }
            for (int i = 0; i < drawlineharm.size(); i++) {         //画线加伤害
                DrawLineHarm d = drawlineharm.get(i);
                try {
                    d.hit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                d.paint(gr);
            }
            for(int j=0;j<enemy.size();j++){
                Enemy e=enemy.get(j);
                if(e.y<768){
                    e.paint(gr);
                }else {
                    enemy.remove(e);
                }
            }
            for(int i=0;i<deadlyFourBullets.size();i++){
                DeadlyFourBullet d=deadlyFourBullets.get(i);
                d.paint(gr);
            }
            //*************
for(int i=0;i<deadlyFourBulletFires.size();i++){
    DeadlyFourBulletFire d=deadlyFourBulletFires.get(i);
    try {
        d.hit2();
    } catch (IOException e) {
        e.printStackTrace();
    }
    d.paint(gr);
}


            for (int i = 0; i < bulletFires.size(); i++) {
                BulletFire b = bulletFires.get(i);
                if (b.y < 0) {
                    bulletFires.remove(b);
                } else {
                    try {
                        b.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    b.paint(gr);
                }
            }

for(int i=0;i<bossDarts.size();i++){
    BossDart b=bossDarts.get(i);
    try {
        b.hit();
    } catch (IOException e) {
        e.printStackTrace();
    }
    b.paint(gr);
}
//***********************************

            for (int i = 0; i < immobilizes.size(); i++) {
                Immobilize immo = immobilizes.get(i);
                immo.paint(gr);
            }
            if (player.VeaponType == 8&&deadlyFourBullets.size()==0) {
                gr.setColor(Color.yellow);
                gr.drawLine(myplane.x + 6, myplane.y - 10, myplane.x + 66, myplane.y - 10);
                gr.drawLine(myplane.x + 6, myplane.y - 6, myplane.x + 66, myplane.y - 6);
                gr.drawLine(myplane.x + 6, myplane.y - 10, myplane.x + 6, myplane.y - 6);
                gr.drawLine(myplane.x + 66, myplane.y - 10, myplane.x + 66, myplane.y - 6);
                gr.setColor(Color.green);
                gr.drawLine(myplane.x + 21, myplane.y - 10, myplane.x + 21, myplane.y - 6);
                gr.drawLine(myplane.x + 36, myplane.y - 10, myplane.x + 36, myplane.y - 6);
                gr.drawLine(myplane.x + 51, myplane.y - 10, myplane.x + 51, myplane.y - 6);
                if (player.scattershottimes < 4) {
                    gr.setColor(Color.green);
                } else {
                    gr.setColor(Color.red);
                }
                gr.fillRect(myplane.x + 6, myplane.y - 10, player.scattershottimes * 15, 4);
            }
            if (crash) {
                gr.drawImage(crashswingimg, myplane.x - 35, myplane.y, 130, 49, null);
                gr.drawImage(crashfireimg, myplane.x + myplane.width / 2 - 7, myplane.y + myplane.height - 5, 15, 48, null);
            }
            blood.paint(gr);
            if (ischangeveapon) {
                gr.drawImage(fs, myplane.x, myplane.y, myplane.width, myplane.height, null);
            }
            if (isshield) {
                gr.drawImage(shield, myplane.x - 15, myplane.y - 15, 100, 47, null);
            }
            if (isaddblood) {
                gr.drawImage(green, myplane.x, myplane.y, 70, 70, null);
            }
            if (ismissileshoot) {
                gr.drawImage(missileshoot, myplane.x + 2, myplane.y, 20, 20, null);
                gr.drawImage(missileshoot, myplane.x + 40, myplane.y, 20, 20, null);
            }


            for (int i = 0; i < crashvector.size(); i++) {
                Crash c = crashvector.get(i);
                c.paint(gr);
            }
            for (int i = 0; i < movecircle.size(); i++) {
                MoveCircle m = movecircle.get(i);
                m.paint(gr);
            }
            for (int i = 0; i < harmbeneficial.size(); i++) {
                HarmBeneficial h = harmbeneficial.get(i);
                h.paint(gr);
            }

            for (int i = 0; i < arrowbullet.size(); i++) {
                ArrowBullet a = arrowbullet.get(i);
                if (a.y < 0) {
                    arrowbullet.remove(a);
                } else {
                    try {
                        a.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    a.paint(gr);
                }
            }

            for (int i = 0; i < accumulateBows.size(); i++) {
                AccumulateBow a = accumulateBows.get(i);
                if (a.y < 0) {
                    accumulateBows.remove(i);
                } else {
                    try {
                        a.hit2();
                        a.paint(gr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            for (int i = 0; i < accumulators.size(); i++) {
                Accumulator a = accumulators.get(i);
                a.paint(gr);
            }

//for(int i=0;i<bossRectangles.size();i++){
//    BossRectangle b=bossRectangles.get(i);
//    b.paint(gr);
//}
            for(int i=0;i<bossThrowRectangles.size();i++){
                BossThrowRectangle b=bossThrowRectangles.get(i);
                b.paint(gr);
            }          //****************
            for (int i = 0; i < enemyFuryPlanes.size(); i++) {
                EnemyFuryPlane e = enemyFuryPlanes.get(i);
                e.paint(gr);
            }

            for (int i = 0; i < iced.size(); i++) {
                Iced ic = iced.get(i);
                ic.paint(gr);
            }
//        for(int i=0;i<bulletFires.size();i++){
//            BulletFire b=bulletFires.get(i);
//            if(b.y<0){
//                bulletFires.remove(b);
//            }else{
//                try {
//                    b.hit();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                b.paint(gr);
//            }
//        }
            for (int i = 0; i < iginitions.size(); i++) {
                Iginition igi = iginitions.get(i);
                try {
                    igi.hit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                igi.paint(gr);
            }


            for (int i = 0; i < lasers.size(); i++) {
                Laser l = lasers.get(i);
                l.paint(gr);
            }


            for (int i = 0; i < lightbow.size(); i++) {
                LightBow l = lightbow.get(i);
                if (l.y < -200) {
                    lightbow.remove(i);
                } else {
                    try {
                        l.hit2();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    l.paint(gr);
                }
            }

            for (int i = 0; i < bounceBows.size(); i++) {
                BounceBow b = bounceBows.get(i);
                if (b.y < -427 || b.y > 935) {
                    bounceBows.remove(i);

                } else {
                    try {
                        b.hit2();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    b.paint(gr);
                }
            }

            for (int i = 0; i < bullet3.size(); i++) {
                Bullet3 b = bullet3.get(i);
                if (b.y < 0) {
                    bullet3.remove(i);
                } else {
                    try {
                        b.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    b.paint(gr);
                }
            }

            for (int i = 0; i < bullet.size(); i++) {
                Bullet c = bullet.get(i);
                if (c.y < 0) {
                    bullet.remove(c);
                } else {
                    try {
                        c.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    c.paint(gr);
                }
            }

            for (int i = 0; i < roundBullets.size(); i++) {
                RoundBullet r = roundBullets.get(i);
                try {
                    r.hit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                r.paint(gr);
            }

            for (int i = 0; i < scattershot.size(); i++) {
                ScatterShot c = scattershot.get(i);
                if (c.y < 0) {
                    scattershot.remove(c);
                } else {
                    try {
                        c.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    c.paint(gr);
                }
            }

            for (int i = 0; i < bullet2.size(); i++) {
                Bullet2 c = bullet2.get(i);
                if (c.y < 0) {
                    bullet2.remove(c);
                } else {
                    try {
                        c.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    c.paint(gr);
                }
            }

            for (int i = 0; i < guidedmissile.size(); i++) {
                GuidedMisssile gm = guidedmissile.get(i);
                if (gm.x < 0 || gm.x > 512 || gm.y < 0 || gm.y > 768) {
                    guidedmissile.remove(i);
                } else {
                    try {
                        gm.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    gm.paint(gr);
                }
            }

            for (int i = 0; i < bulletofturnright.size(); i++) {
                BulletofTurnRight b = bulletofturnright.get(i);
                if (b.y < 0) {
                    bulletofturnright.remove(b);
                } else {
                    try {
                        b.hit();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    b.paint(gr);
                }
            }



            for (int i = 0; i < bloodbottle.size(); i++) {
                BloodBottle b = bloodbottle.get(i);
                if (b.y > 768) {
                    bloodbottle.remove(i);
                } else {
                    b.addblood();
                    b.paint(gr);
                }
            }

            for (int i = 0; i < slowenemyspeed.size(); i++) {
                SlowEnemySpeed s = slowenemyspeed.get(i);
                if (!s.e.isalive) {
                    slowenemyspeed.remove(s);
                } else {
                    s.paint(gr);
                }
            }

            for (int k = 0; k < bomb.size(); k++) {
                Bomb b = bomb.get(k);
                b.paint(gr);
            }

            for (int l = 0; l < enemybullet.size(); l++) {
                EnemyBullet enemybull = enemybullet.get(l);
                if ((enemybull.y > 778 || enemybull.x < -10 || enemybull.x > 522 || enemybull.y < -10)&&enemybull.enemybullettype!=6) {
                    enemybullet.remove(enemybull);
                } else {
                    enemybull.paint(gr);
                }
            }

            for (int l = 0; l < enemyBullet2.size(); l++) {
                EnemyBullet2 enemybull = enemyBullet2.get(l);
                try {
                    enemybull.paint(gr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < ice.size(); i++) {
                Ice ic = ice.get(i);
                try {
                    ic.hit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ic.paint(gr);
            }

            for (int i = 0; i < bossFirebowWarnings.size(); i++) {
                bossFirebowWarnings.get(i).paint(gr);
            }

            if (iswarning) {
                gr.drawImage(warningimg, 106, 232, 300, 305, null);
            }
            gr.setColor(Color.BLACK);
            gr.setFont(new Font("仿宋", Font.BOLD, 30));
            gr.drawString("积分: " + score, 30, 60);
        }else if(!isgamebegin&&gameover==0){
            begin.paint(gr);
        }else if(gameover==1){         //游戏胜利
            bg.paint(gr);
gr.drawImage(victoryimg,65,200,400,375,null);
        }else if(gameover==2){          //游戏失败
            bg.paint(gr);
            gr.drawImage(failerimg,65,200,400,360,null);
        }
        g.drawImage(offscreen, 0, 0, null);


    }


    public static void main(String[] args) throws IOException {
        new MainFrame();
    }
}
