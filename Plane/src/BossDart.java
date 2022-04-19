import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;

public class BossDart extends Thread{
    int x;
    int y;
    int speedx;
    int speedy;
    int tempx;
    int index=0;
    int range;
    int harm=10;
    int tempspeedx;
    boolean issetted=false;
    boolean flag=true;
    MainFrame mainframe;
    Enemy e;
    BufferedImage img;
    Rectangle dart;
    Rectangle boss;
    Vector<MyPlane>myPlanes=new Vector<>();
    public BossDart(MainFrame m,Enemy e,int x,int speedx,int y,int speedy,int range){
        mainframe=m;
        this.x=x;
        tempx=x;
        this.y=y;
        this.speedx=speedx;
        this.tempspeedx=speedx;
        this.speedy=speedy;
        this.e=e;
        this.range=range;
        myPlanes.addAll(mainframe.mylittleplane);
    }

    @Override
    public void run() {
        while(flag){
            //飞镖
            img=mainframe.dart.dart[index];
            index++;
            if(index==38){
                index=0;
            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(y>768+range&&!issetted){

                speedy=0;
                speedx=0;
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tempx =e.x+e.width/2;
                x=tempx;
                speedx=tempspeedx;
                speedy=-7;
                issetted=true;
                myPlanes.clear();
                myPlanes.addAll(mainframe.mylittleplane);
            }

        }


    }

    void paint(Graphics g){
        g.drawImage(img, x , y , range, range, null);
       if(speedy>=0||(speedy<0&&(y+range/2-(e.y+ e.height/2)>=150))){
           if(x<=0||x<=tempx-100){
               speedx*=-1;
           }else if(x>=512-range||x>=tempx+100){
               speedx*=-1;
           }
           y+=speedy;
           x+= speedx;
       }else {
           if (Math.abs(x+range/2 - (e.x+e.width/2)) <= 100) {
               x += (e.x+e.width/2 - x-range/2) / 5;
           } else if (((e.x+e.width/2) - x-range/2) > 100) {
               x += 8;
           } else if ((e.x+e.width/2) - x-range/2 < -100) {
               x -= 8;
           }
           if (Math.abs((e.y+e.height/2) - y-range/2) <= 100) {
               y += (e.y+e.height/2 - y-range/2) / 5;
           } else if (((e.y+e.height/2) - y-range/2) > 100) {
               y += 8;
           } else if ((e.y+e.height/2) - y-range/2 < -100) {
               y -= 8;
           }
          dart=new Rectangle(x,y,range,range);
           boss=new Rectangle(e.x,e.y,e.width,e.height);
           if(dart.intersects(boss)){
               mainframe.bossDarts.remove(this);
               flag=false;
           }

       }



    }
void hit() throws IOException {
        Rectangle dart=new Rectangle(x,y,range,range);
        Rectangle myplane;
        for(int i=0;i<myPlanes.size();i++){
           MyPlane m=myPlanes.get(i);
           myplane=new Rectangle(m.x,m.y,m.width,m.height);
           if(dart.intersects(myplane)){
               myPlanes.remove(m);
               if(m.myplanetype==1){
                   if (!m.isinvincible) {
                       m.blood -= harm;
                       if (m.blood <= 0 ) {
                           Bomb b2 = new Bomb(mainframe, m.x, m.y, m.width, m.height);
                           b2.start();
                           mainframe.bomb.add(b2);
                           m.flag = false;
                           mainframe.mylittleplane.remove(m);
                           GameOver g=new GameOver(mainframe,2);
                           g.start();
                       }
                   }
               }else{
                   m.blood-=harm;
                   if (m.blood <= 0 ) {
                       Bomb b2 = new Bomb(mainframe, m.x, m.y, m.width, m.height);
                       b2.start();
                       mainframe.bomb.add(b2);
                       m.flag = false;
                       mainframe.mylittleplane.remove(m);
                   }

               }

           }
           }

}
}
