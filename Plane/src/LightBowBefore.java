import java.awt.*;
import java.io.IOException;


public class LightBowBefore {
    MainFrame mainframe;
    int length=100;
    int speed=4;
    public LightBowBefore(MainFrame m){
      mainframe=m;
    }
    void paint(Graphics g) throws IOException {
       g.drawImage(mainframe.lightbowdownimg,mainframe.myplane.x+10,mainframe.myplane.y+length,40,46,null);
g.drawImage(mainframe.lightbowupimg,mainframe.myplane.x+10,mainframe.myplane.y-length,40,46,null);
        g.drawImage(mainframe.lightbowleftimg,mainframe.myplane.x-length,mainframe.myplane.y,46,40,null);
        g.drawImage(mainframe.lightbowrightimg,mainframe.myplane.x+length+10,mainframe.myplane.y,46,40,null);
        length-=3;
        if(length<=10){
            LightBow l = new LightBow(mainframe, 6);
                        mainframe.lightbow.add(l);
            mainframe.lightBowBefores.remove(this);
        }
    }
}
