import java.awt.*;
import java.awt.geom.Line2D;

public class BossRectangle extends Thread{
    int x;
    int y;
    MainFrame mainframe;
    public BossRectangle(MainFrame m,int x,int y){
        mainframe=m;
        this.x=x;
        this.y=y;
    }

    @Override
    public void run() {
mainframe.myplane.boderup=y;
mainframe.myplane.boderleft=x;
mainframe.myplane.boderright=x+300-mainframe.myplane.width;
mainframe.myplane.boderdown=y+300-mainframe.myplane.height;
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainframe.myplane. boderup=35;
        mainframe.myplane. boderdown=707;
        mainframe.myplane. boderleft=0;
        mainframe.myplane. boderright=432;
        mainframe.bossRectangles.remove(this);
    }

    void paint(Graphics g){
        g.drawImage(mainframe.bossrectangle02img,x-10,y-10,320,320,null);
//          g.drawLine(x,y,x+300,y);
//        g.drawLine(x,y,x,y+300);
//        g.drawLine(x+300,y,x+300,y+300);
//        g.drawLine(x,y+300,x+300,y+300);
        Graphics2D g_2d = (Graphics2D) g;
        //Line2D line_1 = new Line2D.Double(enemy2.x + enemy2.width / 2, enemy2.y + enemy2.height / 2, enemy.x + enemy.width / 2, enemy.y + enemy.height / 2);

        Line2D line_1 = new Line2D.Double(mainframe.myplane.x+mainframe.myplane.width/2,mainframe.myplane.y+mainframe.myplane.height/2,x,y);
        Line2D line_2 = new Line2D.Double(mainframe.myplane.x+mainframe.myplane.width/2,mainframe.myplane.y+mainframe.myplane.height/2,x+300,y);
        Line2D line_3 = new Line2D.Double(mainframe.myplane.x+mainframe.myplane.width/2,mainframe.myplane.y+mainframe.myplane.height/2,x,y+300);
        Line2D line_4 = new Line2D.Double(mainframe.myplane.x+mainframe.myplane.width/2,mainframe.myplane.y+mainframe.myplane.height/2,x+300,y+300);
        BasicStroke bs_1 = new BasicStroke(3);
        g_2d.setStroke(bs_1);
        g_2d.setColor(Color.red);
        g_2d.draw(line_1);
        g_2d.draw(line_2);
        g_2d.draw(line_3);
        g_2d.draw(line_4);
        BasicStroke bs_2 = new BasicStroke(1);
        g_2d.setStroke(bs_2);
    }
}
