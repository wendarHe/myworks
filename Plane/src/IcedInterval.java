public class IcedInterval extends Thread {
    MainFrame mainframe;

    public IcedInterval(MainFrame m) {
        mainframe = m;
    }

    @Override
    public void run() {
        mainframe.isiced = true;
        try {
            sleep(2300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainframe.isiced = false;
        mainframe.icedinterval.remove(this);
    }
}
