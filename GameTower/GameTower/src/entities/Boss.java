package entities;

import ultil.TowerFrame;

import java.awt.*;
import java.util.Random;

public class Boss {
    Random random = new Random();
    public int type = random.nextInt(2);
    public int x = 0;
    public int y = 145;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //    public int y = -100;
//    public int x = 140 + random.nextInt(TowerFrame.w - 310);
    public Image[] images = {
      ImageLoader.getImage("item.png"),
      ImageLoader.getImage("arrow.png")
    };

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[type], x, y, null);
    }

    public int speed = 1;
    public boolean move() {
        int xR = x;
        int yR = y;
        if (y <= 0 || y >= TowerFrame.h) {
            y = yR;
        }
        if (x <= 140 || x >= TowerFrame.w) {
            x = xR;
        }
        if(x < 240){
            x += speed;
        }
        if(x >= 210 && x < 240){
            y += speed;
        }

        if(x == 240 && y <= 400){
            y += speed;
            //return y > TowerFrame.h;
        }


        if(y == 400 && x <= 460){
            x += speed;
            //return x > TowerFrame.w;
        }
        if(x == 460 && y <= 400 && y >= 105){
            y -= speed;
            //return x > TowerFrame.w;
        }
        if(y == 105 && x <= 690 && x >= 460){
            x += speed;
        }
        if(x == 690 && y >= 105 && y <= 310){
            y += speed;
        }
        if(y == 310 && x >= 680){
            x += speed;
        }
        return x > TowerFrame.w;
    }
    public Rectangle getRect() {
        Rectangle rect = new Rectangle(
                x,
                y,
                images[type].getWidth(null),
                images[type].getHeight(null)
        );
        return rect;
    }
}
