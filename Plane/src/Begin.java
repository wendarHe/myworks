import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
           //开始的界面
public class Begin extends MouseAdapter {
    int x;
    int y;
    boolean ishelptext=false;
    MainFrame mainframe;
    public Begin(MainFrame m){
        mainframe=m;

    }

  MouseAdapter mm=new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
          if(!ishelptext){
              if(x>=200&&x<=330&&y>=600&&y<=642){
                  mainframe.isgamebegin=true;
              }
              if(x>=212&&x<=315&&y>=650&&y<=692){
                  ishelptext=true;
              }
          }else{
              if(x>=200&&x<=314&&y>=600&&y<=640){
                 ishelptext=false;
              }
          }

      }

      @Override
      public void mouseMoved(MouseEvent e) {
          x=e.getX();
          y=e.getY();

      }
  };
    void paint(Graphics g){
        if(ishelptext){
            g.drawImage(mainframe.helptextimg,0,0,null);
if(x>=200&&x<=314&&y>=600&&y<=640){
    g.drawImage(mainframe.back02img,200,600,114,40,null);
}else{
    g.drawImage(mainframe.back01img,200,600,114,40,null);
}

        }else{
            g.drawImage(mainframe.startimg,0,0,512,768,null);
            if(x>=200&&x<=330&&y>=600&&y<=642){
                g.drawImage(mainframe.playbuttonpresedimg,200,600,130,42,null);
            }else{
                g.drawImage(mainframe.playbuttonimg,200,600,130,42,null);
            }
            if(x>=212&&x<=315&&y>=650&&y<=692){
                g.drawImage(mainframe.help02img,212,650,103,42,null);
            }else{
                g.drawImage(mainframe.helpimg,212,650,103,42,null);
            }
        }


    }
}
