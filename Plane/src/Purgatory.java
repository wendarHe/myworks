import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Vector;

public class Purgatory extends Thread{
    Vector<Enemy>bufferenemy=new Vector<>();
    MainFrame mainframe;
    Enemy e;
    int count=0;
    int width=0;
    int height=0;
    int x;
    int y;
    boolean issstted=false;
    public Purgatory(MainFrame m,Enemy e){
        mainframe=m;
        this.e=e;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        count=1;
    }
    void paint(Graphics g){
        if(count==0){
            g.setColor(Color.red);
            g.drawImage(mainframe.prugatoryimg,mainframe.myplane.x-10,mainframe.myplane.y-10,mainframe.myplane.width+20,mainframe.myplane.height+20,null);
            Graphics2D g_2d = (Graphics2D) g;
            Line2D line_1 = new Line2D.Double(mainframe.myplane.x+mainframe.myplane.width/2,mainframe.myplane.y+mainframe.myplane.height/2,e.x+e.width/2,e.y+e.height/2);
            BasicStroke bs_1 = new BasicStroke(4);
            g_2d.setStroke(bs_1);
            g_2d.setColor(Color.red);
            g_2d.draw(line_1);
            BasicStroke bs_2 = new BasicStroke(1);
            g_2d.setStroke(bs_2);
        }else if(count==1){

            g.drawImage(mainframe.bluecircleimg,e.x+e.width/2-(x+=20),e.y+e.height/2-(y+=20),width+=40,height+=40,null);
            if(height>800&&!issstted){
                mainframe.bg.ispurgatory=true;
                for(int i=0;i<mainframe.enemy.size();i++){
                    Enemy en=mainframe.enemy.get(i);
                    if(en.enemytype!=2){
                        bufferenemy.add(en);
                    }
                }
                for (int i = 0; i < bufferenemy.size(); i++) {
                    Enemy en=bufferenemy.get(i);
                    en.isalive=false;
                       en.flag=false;
                        mainframe.enemy.remove(en);
                }
                mainframe.enemybullet.clear();
                issstted=true;

            }
if(height>=2000){
    mainframe.purgatories.remove(this);
}
        }


    }
}
