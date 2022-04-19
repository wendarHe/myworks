
import java.io.IOException;
            //技能护盾
public class Shield extends Thread {

    MainFrame mainframe;
    public Shield(MainFrame m) throws IOException {
        mainframe = m;
    }

    @Override
    public void run() {

            mainframe.myplane.isinvincible = true;
            mainframe.isshield = true;
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainframe.myplane.isinvincible = false;
            mainframe.isshield = false;

    }


}
