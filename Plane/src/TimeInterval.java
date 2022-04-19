public class TimeInterval extends Thread {    //发射炮弹的时间间隔,防止按着连发
    MainFrame mainframe;
    int sleeptime;

    public TimeInterval(MainFrame m, int sleeptime) {
        mainframe = m;
        this.sleeptime = sleeptime;
    }

    @Override
    public void run() {
        mainframe.timeinterval = false;
        try {
            sleep(sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainframe.timeinterval = true;
    }
}
