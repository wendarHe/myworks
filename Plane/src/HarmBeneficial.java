import java.awt.*;

public class HarmBeneficial extends Thread {
    MainFrame mainframe;
    MyPlane myplane;
    boolean flag = true;
    int progress = 50;
             //血瓶吃完加伤害
    public HarmBeneficial(MainFrame m, MyPlane m2) {
        myplane = m2;
        mainframe = m;
    }

    @Override
    public void run() {
        while (flag) {
            MyPlane.beneficialharm = 5;
            for (int i = 0; i < 50; i++) {
                progress -= 1;
                try {
                    sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MyPlane.beneficialharm = 0;
            flag = false;
            mainframe.harmbeneficial.remove(this);
        }


    }

    void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(myplane.x + 10, myplane.y, progress, 3);
        g.drawImage(mainframe.purple, myplane.x + 18, myplane.y + 10, 30, 30, null);
    }
}
