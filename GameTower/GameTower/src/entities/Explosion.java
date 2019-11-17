package entities;

import java.awt.*;

public class Explosion {
    public int x;
    public int y;
    public int index;
    public Image[] images = {
            ImageLoader.getImage("imgBoomSky1.png"),
            ImageLoader.getImage("imgBoomSky2.png"),
            ImageLoader.getImage("imgBoomSky3.png"),
            ImageLoader.getImage("imgBoomSky4.png"),
            ImageLoader.getImage("imgBoomSky5.png"),
            ImageLoader.getImage("imgBoomSky6.png"),
            ImageLoader.getImage("imgBoomSky7.png"),
            ImageLoader.getImage("imgBoomSky8.png"),
            ImageLoader.getImage("imgBoomSky9.png"),
            ImageLoader.getImage("imgBoomSky10.png"),
            ImageLoader.getImage("imgBoomSky11.png"),
            ImageLoader.getImage("imgBoomSky12.png"),
            ImageLoader.getImage("imgBoomSky13.png"),
            ImageLoader.getImage("imgBoomSky14.png"),
            ImageLoader.getImage("imgBoomSky15.png"),
            ImageLoader.getImage("imgBoomSky16.png"),
            ImageLoader.getImage("imgBoomSky17.png"),
            ImageLoader.getImage("imgBoomSky18.png"),
            ImageLoader.getImage("imgBoomSky19.png"),
            ImageLoader.getImage("imgBoomSky20.png")
    };

    public Explosion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int count;
    public boolean draw(Graphics2D g2d) {
        int w = images[index].getWidth(null) / 2;
        int h = images[index].getHeight(null) / 2;
        g2d.drawImage(images[index], x - w, y - h, null);

        count++;
        if (count >= 2) {
            index++;
            count = 0;
        }

        return index >=  images.length;
    }
}
