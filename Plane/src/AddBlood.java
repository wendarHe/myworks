public class AddBlood extends Thread {
    MainFrame mainframe;
    boolean flag = true;

    public AddBlood(MainFrame m) {
        mainframe = m;
    }

    @Override
    public void run() {
        while (flag) {
            mainframe.isaddblood = true;
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            mainframe.isaddblood = false;
        }


    }
}
