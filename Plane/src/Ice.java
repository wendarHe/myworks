import java.awt.*;
import java.io.IOException;
import java.util.Vector;

public class Ice {
    Vector<Enemy> enemy = new Vector<>();
    Vector<EnemyFuryPlane> enemyfury = new Vector<>();
    int x;
    int y;
    int width;
    int height;
    MainFrame mainframe;
             //技能冰冻
    public Ice(MainFrame m, int x, int y) {
        mainframe = m;
        this.x = x;
        this.y = y;
        enemyfury.addAll(mainframe.enemyFuryPlanes);
        enemy.addAll(mainframe.enemy);
    }

    void paint(Graphics g) {
        if (height > 1536) {
            mainframe.ice.remove(this);
        } else {
            g.drawImage(mainframe.bluecircleimg, x -= 10, y -= 10, width += 20, height += 20, null);
        }


    }

    void hit() throws IOException {
        Rectangle bull = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle enemyrec;
        for (int i = 0; i < enemy.size(); i++) {
            Enemy e = enemy.get(i);
            enemyrec = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemyrec.intersects(bull)) {
                enemy.remove(e);
                Iced iced = new Iced(mainframe, e);
                iced.start();
                mainframe.iced.add(iced);
            }
        }
        for (int i = 0; i < enemyfury.size(); i++) {
            EnemyFuryPlane e = enemyfury.get(i);
            enemyrec = new Rectangle(e.x, e.y, e.width, e.height);
            if (enemyrec.intersects(bull)) {
                enemyfury.remove(e);
                Iced iced = new Iced(mainframe, e);
                iced.start();
                mainframe.iced.add(iced);
            }
        }

    }

}
