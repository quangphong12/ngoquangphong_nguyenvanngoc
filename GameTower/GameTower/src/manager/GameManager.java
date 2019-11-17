package manager;

import entities.*;
import ultil.TowerFrame;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    Tower tower1;
    Tower tower2;
    ArrayList<Bullet> bullets;
    ArrayList<Boss> bossArrayList;
    ArrayList<Explosion> explosions;
    Background bg = new Background(0, 0);
    public void initGame(){
        bossArrayList = new ArrayList<>();
        tower1 = new Tower(550,200);
//        tower2 = new Tower(580,180);
        bullets = new ArrayList<>();
        explosions = new ArrayList<>();

    }

    public void draw(Graphics2D graphics2D){
        bg.draw(graphics2D);
        tower1.draw(graphics2D);
//        tower2.draw(graphics2D);
        for (Bullet bullet : bullets){
            bullet.draw(graphics2D);
        }

        for (Boss boss: bossArrayList) {
            boss.draw(graphics2D);
        }
        for (int i = explosions.size() - 1; i >= 0; i--) {
            boolean delete = explosions.get(i).draw(graphics2D);
            if (delete) {
                explosions.remove(i);
            }
        }
    }

    void initBoss() {
        if (bossArrayList.size() == 0 || bossArrayList.get(bossArrayList.size() -1).y > 500) {
            bossArrayList.add(new Boss());

        }
    }

    public void towerFire(int a, int b){
        tower1.fire(bullets, a, b);
//        tower2.fire(bullets);
    }

    public void towerMove(int orient){
        tower1.orient = orient;
//        tower1.move();
    }
    public boolean checkDie() {
        for (Boss boss : bossArrayList) {
            Rectangle rect1 = boss.getRect()
                    .intersection(tower1.getRect());
//            Rectangle rect2 = boss.getRect()
//                    .intersection(tower2.getRect());
            if (rect1.isEmpty() == false) {
                //SoundLoader.play("cham_xe.wav");
                return true;
            }
        }
        return false;
    }


    public void AI() {

        initBoss();

        for (int i = bossArrayList.size() - 1; i >= 0; i--) {
            if(Math.pow(bossArrayList.get(i).getX() - 550, 2) + Math.pow(bossArrayList.get(i).getY() - 200, 2) <= 10000){
                towerFire(bossArrayList.get(i).getX(), bossArrayList.get(i).getY());
            }
            boolean delete = bossArrayList.get(bossArrayList.size() - 1).move();
            if (delete) {
                bossArrayList.remove(i);
            }else {
                int count = 0;
                for (int j = 0; j < bullets.size(); j++) {
                    Rectangle rect = bossArrayList.get(i).getRect()
                            .intersection(bullets.get(j).getRect());
                    if (rect.isEmpty() == false) {
                        count ++;
                        bullets.remove(j);
                    }
                    if(count == 1){
                        Boss boss = bossArrayList.get(i);
                        int x = boss.x + boss.images[boss.type].getWidth(null) / 2;
                        int y = boss.y + boss.images[boss.type].getHeight(null) / 2;
                        explosions.add(new Explosion(x, y));
//                        bullets.remove(j);
                        bossArrayList.remove(i);
                        count = 0;
                        //SoundLoader.play("eat_explo.wav");
                        break;
                    }
                }
            }
        }

        for (int i = bullets.size() - 1; i >= 0; i--) {
            boolean delete1 = bullets.get(i).move();
            if (delete1) {
                bullets.remove(i);
            }
        }
    }

}
