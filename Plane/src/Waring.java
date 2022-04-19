import java.io.IOException;
            //boss出现时的警告图标
public class Waring extends Thread {
    MainFrame mainframe;
    boolean flag = true;

    public Waring(MainFrame m) throws IOException {
        this.mainframe = m;

    }

    @Override
    public void run() {
        while (flag) {
            mainframe.iswarning = true;
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainframe.iswarning = false;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainframe.iswarning = true;
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainframe.iswarning = false;

            try {
                Enemy e = new Enemy(mainframe, mainframe.bossenemyimg, 2, 156, -128, 200, 128, 8000);
                e.start();
                mainframe.enemy.add(e);
                for (int i = 0; i < mainframe.lightbow.size(); i++) {
                    mainframe.lightbow.get(i).copyenemy.add(e);
                }
                for (int i = 0; i < mainframe.bulletFires.size(); i++) {
                    mainframe.bulletFires.get(i).copyenemy.add(e);
                }
                for (int i = 0; i < mainframe.bounceBows.size(); i++) {
                    mainframe.bounceBows.get(i).copyenemy.add(e);
                }
                for (int i = 0; i < mainframe.bullet2.size(); i++) {
                    mainframe.bullet2.get(i).copyenemy.add(e);
                }
                for (int i = 0; i < mainframe.arrowbullet.size(); i++) {
                    mainframe.arrowbullet.get(i).copyenemy.add(e);
                }
                for (int i = 0; i < mainframe.movecircle.size(); i++) {
                    mainframe.movecircle.get(i).enemy.add(e);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            flag = false;


        }
    }
}
