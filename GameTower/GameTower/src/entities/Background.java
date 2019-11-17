package entities;

import java.awt.*;

public class Background {
    public int x;
    public int y;
    Image image = ImageLoader.getImage("map11.png");
    public Background(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, x, y, null);
    }
}
