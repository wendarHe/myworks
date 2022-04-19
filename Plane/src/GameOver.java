public class GameOver extends Thread{
    MainFrame mainframe;
    int type;
    public GameOver(MainFrame m,int type){
        this.type=type;
        mainframe=m;
    }

    @Override
    public void run() {
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainframe.gameover=type;
    }
}
