package aParkingSystem.frame;

import aParkingSystem.adapter.WindowCloser;
import aParkingSystem.dialog.RegisterDialog;
import aParkingSystem.panel.PhotoPanel;
import aParkingSystem.pojo.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RegisterFrame extends JFrame implements ActionListener {
    private final Font maxFont = new Font("楷体", Font.BOLD, 35);
    private final Font midFont = new Font("楷体", Font.BOLD, 20);
    private final Font minFont = new Font("宋体", Font.BOLD, 17);
    private JPanel allPanel;
    private final JPanel registerPanel = new JPanel(new GridLayout(2, 2));
    private final JPanel buttonPanel = new JPanel();
    private final JLabel tip = new JLabel("注 册 界 面", JLabel.CENTER);
    private final JLabel userName = new JLabel("用户名：", JLabel.CENTER);
    private final JLabel userPassword = new JLabel("密码：", JLabel.CENTER);
    private final JTextField nameText = new JTextField();
    private final JTextField passwordText = new JTextField();
    private final JButton register = new JButton("注册");
    private final JButton back = new JButton("返回");

    public RegisterFrame() {
        super("停车场管理系统");

        setUp();

        register.addActionListener(this);
        back.addActionListener(this);

        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowCloser());
    }

    private void setUp() {
        try {
            allPanel = new PhotoPanel(ImageIO.read(new File("src/packingLotSystem.photo/register.jpg")));
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }

        tip.setFont(maxFont);
        tip.setForeground(Color.YELLOW);
        // 设置透明
        tip.setOpaque(false);
        userName.setFont(midFont);
        userName.setForeground(Color.YELLOW);
        userPassword.setFont(midFont);
        userPassword.setForeground(Color.YELLOW);
        register.setFont(minFont);
        back.setFont(minFont);

        // 设置透明
        registerPanel.setOpaque(false);
        registerPanel.add(userName);
        registerPanel.add(nameText);
        registerPanel.add(userPassword);
        registerPanel.add(passwordText);

        // 设置透明
        buttonPanel.setOpaque(false);
        buttonPanel.add(register);
        buttonPanel.add(back);

        allPanel.setLayout(new GridLayout(3, 1));
        allPanel.add(tip);
        allPanel.add(registerPanel);
        allPanel.add(buttonPanel);

        add(allPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            // 检测用户是否已经注册
            try {
                FileInputStream fis = new FileInputStream("src/data/user.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                int judge = 0;
                User inManager;
                while (fis.available() > 0) {
                    inManager = (User) ois.readObject();
                    // 避免多对象文件读取头文件报错
                    fis.skip(4);
                    if (nameText.getText().equals(inManager.getName())) {
                        // 判断用户已经注册
                        judge = 1;
                        break;
                    }
                }
                fis.close();
                if (nameText.getText().isEmpty() || passwordText.getText().isEmpty()) {
                    new RegisterDialog(this, "格 式 错 误");
                } else if (judge == 1) {
                    new RegisterDialog(this, "该 用 户 已 注 册");
                } else {
                    creatFile();
                }
            } catch (IOException | ClassNotFoundException ioe) {
                System.out.println("error: " + ioe.getMessage());
            }
        } else {
            RegisterFrame.this.dispose();
        }
    }

    public void creatFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src/data/user.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            User outManager = new User();
            outManager.setName(nameText.getText());
            outManager.setPassword(passwordText.getText());
            oos.writeObject(outManager);
            new RegisterDialog(this, "注 册 成 功");
            fos.close();
        } catch (IOException I) {
            System.out.println("error: " + I.getMessage());
        }
    }
}