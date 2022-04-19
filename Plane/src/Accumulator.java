import java.awt.*;

public class Accumulator extends Thread {
    MainFrame mainframe;
    boolean flag = true;

    public Accumulator(MainFrame m) {
        mainframe = m;

    }

    @Override
    public void run() {
        while (flag) {
            if (mainframe.accumulatenumber < 60) {
                mainframe.accumulatenumber += 1;
            }
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void paint(Graphics g) {
        if(mainframe.myplane.flag){
            g.setColor(Color.yellow);
            g.drawLine(mainframe.myplane.x + 6, mainframe.myplane.y - 10, mainframe.myplane.x + 66, mainframe.myplane.y - 10);
            g.drawLine(mainframe.myplane.x + 6, mainframe.myplane.y - 6, mainframe.myplane.x + 66, mainframe.myplane.y - 6);
            g.drawLine(mainframe.myplane.x + 6, mainframe.myplane.y - 10, mainframe.myplane.x + 6, mainframe.myplane.y - 6);
            g.drawLine(mainframe.myplane.x + 66, mainframe.myplane.y - 10, mainframe.myplane.x + 66, mainframe.myplane.y - 6);

            if (mainframe.accumulatenumber < 60) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }
            g.fillRect(mainframe.myplane.x + 6, mainframe.myplane.y - 10, mainframe.accumulatenumber, 4);
        }

    }


}
