import java.awt.*;
import java.awt.image.BufferedImage;
            //血瓶
public class BloodBottle {
    BufferedImage img;
    int type;
    int x;
    int y;
    int width = 23;
    int height = 30;
    int speedy = 3;
    int speedx = 1;
    int temp;
    MainFrame mainframe;

    public BloodBottle(MainFrame m, int type, int x, int y) {
        this.x = x;
        this.y = y;
        mainframe = m;
        temp = x;
        this.type = type;
        if (type % 2 == 0) {
            img = mainframe.bloodbottleimg;
        } else if (type % 2 == 1) {
            img = mainframe.harmbenificialimg;
        }
    }

    public void paint(Graphics g) {
        if (x > temp + 40 || (x > 482 && x < temp + 40)) {
            speedx *= -1;
        } else if (x < temp - 40 || (x < 0 && x > temp - 40)) {
            speedx *= -1;
        }
        g.drawImage(img, x += speedx, y += speedy, width, height, null);
    }

    void addblood() {
        Rectangle b = new Rectangle(this.x, this.y, width, height);
        Rectangle myplane = new Rectangle(mainframe.myplane.x, mainframe.myplane.y, mainframe.myplane.width, mainframe.myplane.height);
        if (b.intersects(myplane)) {
            if (type % 2 == 0) {             //加血
                if(mainframe.myplane.blood+10<=100){
                    mainframe.myplane.blood += 10;
                }

                AddBlood a = new AddBlood(mainframe);
                a.start();
                mainframe.addblood.add(a);
            } else if (type % 2 == 1) {           //加伤害
                if (mainframe.harmbeneficial.size() != 0) {
                    mainframe.harmbeneficial.clear();
                    HarmBeneficial h = new HarmBeneficial(mainframe, mainframe.myplane);
                    h.start();
                    mainframe.harmbeneficial.add(h);
                } else {
                    HarmBeneficial h = new HarmBeneficial(mainframe, mainframe.myplane);
                    h.start();
                    mainframe.harmbeneficial.add(h);
                }
            }

            mainframe.bloodbottle.remove(this);
        }
    }
}
