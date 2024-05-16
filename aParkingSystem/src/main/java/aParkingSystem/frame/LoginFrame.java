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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginFrame extends JFrame implements ActionListener {

    private final Font maxFont = new Font("楷体",Font.BOLD,35);
    private final Font midFont = new Font("楷体",Font.BOLD,20) ;
    private final Font minFont = new Font("宋体",Font.BOLD,17) ;

    private final JPanel loginPanel = new JPanel(new GridLayout(3, 2));
    private final JPanel buttonPanel = new JPanel();

    private final JLabel tip = new JLabel("欢 迎 登 录", JLabel.CENTER);

    private final JLabel userName = new JLabel("用户名", JLabel.CENTER);
    private final JLabel userPassword = new JLabel("密码", JLabel.CENTER);
    private final JTextField nameText = new JTextField();
    private final JTextField passwordText = new JTextField();

    private final JButton login = new JButton("登录");
    private final JButton register = new JButton("注册");

    public LoginFrame() {

        super("停车场管理系统");

        setUp();

        login.addActionListener(this);
        register.addActionListener(this);
        nameText.setEditable(true);
        passwordText.setEditable(true);

        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowCloser());
    }

    private void setUp() {
        JPanel allPanel;
        try {
            File imgFile = new File("D:\\IDEA\\WorkPlace\\javaSE\\aParkingSystem\\src\\main\\resources\\aParkingSystem\\image\\login.jpg");
            if (imgFile.exists()) {
                BufferedImage img = ImageIO.read(imgFile);
                allPanel = new PhotoPanel(img);
            } else {
                System.out.println("文件不存在，请检查路径：" + imgFile.getAbsolutePath());
                allPanel = new JPanel();  // 使用默认面板防止NullPointerException
            }
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
            allPanel = new JPanel();  // 在异常情况下使用默认面板防止NullPointerException
        }

        tip.setFont(maxFont);
        tip.setForeground(Color.YELLOW);
        // 设置透明
        tip.setOpaque(false);
        userName.setFont(midFont);
        userName.setForeground(Color.YELLOW);
        userPassword.setFont(midFont);
        userPassword.setForeground(Color.YELLOW);
        login.setFont(minFont);
        register.setFont(minFont);

        // 设置透明
        loginPanel.setOpaque(false);
        loginPanel.add(userName);
        loginPanel.add(nameText);
        loginPanel.add(userPassword);
        loginPanel.add(passwordText);
        loginPanel.setBackground(new Color(170,210,230));

        // 设置透明
        buttonPanel.setOpaque(false);
        buttonPanel.add(login);
        buttonPanel.add(register);
        buttonPanel.setBackground(new Color(170,210,230));

        allPanel.setLayout(new GridLayout(3, 1));
        allPanel.add(tip);
        allPanel.add(loginPanel);
        allPanel.add(buttonPanel);

        add(allPanel);
    }

    public void actionPerformed(ActionEvent e) {
        // 跳转管理界面
        if (e.getSource() == login) {
            // 检测用户是否已经注册
            try {
                FileInputStream fis = new FileInputStream("D:\\IDEA\\WorkPlace\\javaSE\\aParkingSystem\\src\\main\\resources\\aParkingSystem\\data\\user.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                int judge = 0;
                User inManager;
                while (fis.available() > 0) {
                    inManager = (User) ois.readObject();
                    // 避免多对象文件读取头文件报错
                    fis.skip(4);
                    if (nameText.getText().equals(inManager.getName())
                            && passwordText.getText().equals(inManager.getPassword())) {
                        // 判断用户已经注册
                        judge = 1;
                        break;
                    }
                }
                fis.close();
                if (nameText.getText().isEmpty() || passwordText.getText().isEmpty()) {
                    new RegisterDialog(this, "格 式 错 误");
                } else {
                    if (judge == 1) {
                        // 登录成功
                        new ManageFrame();
                        LoginFrame.this.dispose();
                    } else {
                        new RegisterDialog(this, "输 入 错 误");
                    }
                }
            } catch (IOException | ClassNotFoundException ioe) {
                System.out.println("error: " + ioe.getMessage());
            }
        }
        // 跳转注册界面
        else {
            new RegisterFrame();
        }
    }
}
