package aParkingSystem.dialog;

import aParkingSystem.adapter.WindowCloser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageDialog extends Dialog implements ActionListener {
    JButton confirm = new JButton("确认");

    public ManageDialog(Frame parent, String tip) {
        super(parent, "提示");
        setUp(tip);
        confirm.addActionListener(this);
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        addWindowListener(new WindowCloser());
    }

    private void setUp(String tip) {
        JLabel tipLabel = new JLabel(tip, JLabel.CENTER);
        Panel tipPanel = new Panel(new GridLayout(2, 1));
        tipPanel.add(tipLabel);
        tipPanel.add(confirm);
        add(tipPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            ManageDialog.this.dispose();
        }

    }
}
