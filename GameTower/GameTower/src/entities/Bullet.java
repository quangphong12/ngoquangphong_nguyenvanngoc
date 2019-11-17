package entities;

import java.awt.*;

public class Bullet {
    int x;
    int y;
    int speed = 2;
    int x1;
    int y1;
    Image image = ImageLoader.getImage("bullet.png");

    public Bullet(int x, int y, int x1, int y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }
    public void draw(Graphics2D graphics2D){
//        graphics2D.drawImage(image,x,y,null);
        graphics2D.drawLine(x, y, x1, y1);
        graphics2D.setColor(Color.RED);
    }

    public boolean move(){
        x = x1;
        y = y1;
        return x<=0;
    }

    public Rectangle getRect(){
        Rectangle rect = new Rectangle(x,y,image.getWidth(null),image.getHeight(null));
        return rect;
    }
}
