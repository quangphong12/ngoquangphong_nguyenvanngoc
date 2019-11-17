package entities;

import ultil.TowerFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Tower {
    public int x;
    public int y;
    Image image = ImageLoader.getImage("tower00.png");
    public int speed = 1;
    public int orient;

    public Tower(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(image,x,y,null);
    }

    long t;
    public void fire(ArrayList<Bullet> bullets, int x1, int y1){
        long T = System.currentTimeMillis();
        if (T-t <500){
            return;
        }
        t = T;

        int xB = x + image.getWidth(null)/2;
        Bullet bullet = new Bullet(xB,y, x1, y1);
        bullets.add(bullet);

    }

    public Rectangle getRect(){
        Rectangle rect = new Rectangle(x,y,image.getWidth(null),image.getHeight(null));
        return rect;
    }

//    public void move(){
//        int xR = x;
//        int yR = y;
//
//        switch (orient) {
//            case KeyEvent.VK_LEFT:
//                x -= speed;
//                break;
//            case KeyEvent.VK_RIGHT:
//                x += speed;
//                break;
//            case KeyEvent.VK_UP:
//                y -= speed;
//                break;
//            case KeyEvent.VK_DOWN:
//                y += speed + 1;
//                break;
//        }
//
////        if (y <= 0 ||
////                y >= TowerFrame.h - image.getHeight(null) - 35) {
////            y = yR;
////        }
////        if (x <= 140 || x >= TowerFrame.w - 170) { // 140 - 170
////            x = xR;
////        }
//    }

}
