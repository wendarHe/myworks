public class MissileShoot extends Thread {
    MainFrame m;

    public MissileShoot(MainFrame m) {
        this.m = m;
    }

    @Override
    public void run() {
        m.ismissileshoot = true;
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.ismissileshoot = false;

    }
}
