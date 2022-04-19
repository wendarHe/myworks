import java.awt.*;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.Vector;

public class DeadlyFourBullet {

    int beginx;
    int beginy;
    int endx;
    int endy;
    MainFrame mainframe;
    int count=4;
    public DeadlyFourBullet(MainFrame m){
        mainframe=m;
        beginx=mainframe.myplane.x+mainframe.myplane.width/2;
        beginy=mainframe.myplane.y;
    }
    void paint(Graphics g){
if(Math.abs(beginx-mainframe.myplane.x-mainframe.myplane.width/2)>5||Math.abs(beginy-mainframe.myplane.y)>5){
    mainframe.deadlyFourBullets.remove(this);
}

        endx=mainframe.begin.x;
        endy=mainframe.begin.y;
        if(Math.abs(endy-beginy)> Math.abs(endx-beginx)&&endy<=beginy){
            g.drawImage(mainframe.aimdeadlybulletimg,endx-20,endy-20,40,40,null);
        }
        g.setColor(Color.yellow);
        g.drawLine(mainframe.myplane.x + 6, mainframe.myplane.y - 10, mainframe.myplane.x + 66, mainframe.myplane.y - 10);
        g.drawLine(mainframe.myplane.x + 6, mainframe.myplane.y - 6, mainframe.myplane.x + 66, mainframe.myplane.y - 6);
        g.drawLine(mainframe.myplane.x + 6, mainframe.myplane.y - 10, mainframe.myplane.x + 6, mainframe.myplane.y - 6);
        g.drawLine(mainframe.myplane.x + 66, mainframe.myplane.y - 10, mainframe.myplane.x + 66, mainframe.myplane.y - 6);
        g.setColor(Color.green);
        g.drawLine(mainframe.myplane.x + 21, mainframe.myplane.y - 10, mainframe.myplane.x + 21, mainframe.myplane.y - 6);
        g.drawLine(mainframe.myplane.x + 36, mainframe.myplane.y - 10, mainframe.myplane.x + 36, mainframe.myplane.y - 6);
        g.drawLine(mainframe.myplane.x + 51, mainframe.myplane.y - 10, mainframe.myplane.x + 51, mainframe.myplane.y - 6);
        if (count>1) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(mainframe.myplane.x + 6, mainframe.myplane.y - 10, count * 15, 4);
        Graphics2D g_2d = (Graphics2D) g;
       // Line2D line_1 = new Line2D.Double(enemy2.x + enemy2.width / 2, enemy2.y + enemy2.height / 2, enemy.x + enemy.width / 2, enemy.y + enemy.height / 2);

        Line2D line_1 = new Line2D.Double(beginx+20,beginy-20,beginx+600,beginy-600);
        Line2D line_2 = new Line2D.Double(beginx-20,beginy-20,beginx-600,beginy-600);
        BasicStroke bs_1 = new BasicStroke(3);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.cyan);
        g_2d.draw(line_1);
        g_2d.draw(line_2);
        BasicStroke bs_2 = new BasicStroke(1);
        g_2d.setStroke(bs_2);
    }

}
