import java.awt.*;

public class BossThrowRectangle {
    MainFrame mainframe;
    int x;int y;int aimx;int aimy;
    public BossThrowRectangle(MainFrame m,int x,int y){
        mainframe=m;
        this.x=x;
        this.y=y;
    }
    void paint(Graphics g){
       aimx=mainframe.myplane.x+mainframe.myplane.width/2;
       aimy=mainframe.myplane.y+mainframe.myplane.height/2;

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
       g.drawImage(mainframe.bossrectangleimg,x-30,y-30,60,60,null);
        if (Math.abs(x - aimx) < 20 && Math.abs(y - aimy) < 20) {
            if(mainframe.myplane.x+150>=512){
                x=512-300;
            }else if(mainframe.myplane.x<=150){
                x=0;
            }else{
                x=mainframe.myplane.x-150;
            }
            if(mainframe.myplane.y+150>=768){
                y=768-300;
            }else if(mainframe.myplane.y<=150){
                y=0;
            }else{
                y=mainframe.myplane.y-150;
            }
            BossRectangle b=new BossRectangle(mainframe,x,y);
            b.start();
            mainframe.bossRectangles.add(b);
            mainframe.bossThrowRectangles.remove(this);
        }
    }
}
