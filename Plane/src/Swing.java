
import java.io.IOException;

public class Swing extends Thread {
    MainFrame mainframe;

    public Swing(MainFrame m) throws IOException {
        this.mainframe = m;

    }

    @Override
    public void run() {

            mainframe.ischangeveapon = true;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainframe.ischangeveapon = false;

    }

}
