package ultil;

import entities.Boss;
import manager.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TowerPanel extends JPanel {

    GameManager manager = new GameManager();
    boolean[] flag = new boolean[256];

    public TowerPanel() {
        setBackground(Color.BLACK);
        manager.initGame();
        setFocusable(true);
        addKeyListener(listener);

        Thread t = new Thread(run);
        t.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        super.paintComponent(g);
//        graphics2D.setColor(new Color (0,76, 153));
//        int[] xPos = new int[]{0, 1000, 1000, 0};
//        int[] yPos = new int[]{100, 100,150,150 };
//        graphics2D.fillPolygon(xPos,yPos,4);

        manager.draw(graphics2D);



    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            while (true) {
//                if (flag[KeyEvent.VK_LEFT]) {
//                    manager.towerMove(KeyEvent.VK_LEFT);
//                }
//                if (flag[KeyEvent.VK_RIGHT]) {
//                    manager.towerMove(KeyEvent.VK_RIGHT);
//                }
//                if (flag[KeyEvent.VK_UP]) {
//                    manager.towerMove(KeyEvent.VK_UP);
//                }
//                if (flag[KeyEvent.VK_DOWN]) {
//                    manager.towerMove(KeyEvent.VK_DOWN);
//                }
//                if (flag[KeyEvent.VK_SPACE]) {
//                    manager.towerFire();
//                }
//                Boss Boss = new Boss();
//                if(Math.pow(Boss.getX() - 580, 2) + Math.pow(Boss.getY() - 180, 2) <= 4000){
//                    manager.towerFire();
//                }
                manager.AI();
                boolean die = manager.checkDie();
                if (die) {
                    int result = JOptionPane.showConfirmDialog(
                            null,
                            "Do you want to replay",
                            "Game over",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (result == JOptionPane.YES_OPTION) {
                        manager.initGame();
                        flag = new boolean[256];
                    }else {
                        System.exit(0);
                    }
                }


                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    KeyListener listener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            flag[e.getKeyCode()] = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            flag[e.getKeyCode()] = false;
        }
    };
}
