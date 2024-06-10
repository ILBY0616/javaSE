package aParkingSystem.panel;

import javax.swing.*;
import java.awt.*;

public class PhotoPanel extends JPanel {

    private final Image image;

    public PhotoPanel(Image bgImage) {
        this.image = bgImage;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
