package ultil;

import javax.swing.*;
import java.awt.*;

public class TowerFrame extends JFrame {
    public static final int w = 900;
    public static final int h = 540;

    public TowerFrame() throws HeadlessException {
        setSize(w,h);
        setTitle("Game Tower");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TowerPanel panel = new TowerPanel();
        add(panel);

    }
}
