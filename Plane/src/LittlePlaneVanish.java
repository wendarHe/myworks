import java.io.IOException;

public class LittlePlaneVanish extends Thread {
    MainFrame mainframe;
    MyPlane myplane;


    public LittlePlaneVanish(MainFrame m, MyPlane myplane) throws IOException {
        this.mainframe = m;
        this.myplane = myplane;
    }

    @Override
    public void run() {

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myplane.isalive = false;
            myplane.flag = false;

    }
}
