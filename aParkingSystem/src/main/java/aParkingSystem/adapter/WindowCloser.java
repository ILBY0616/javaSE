package aParkingSystem.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
