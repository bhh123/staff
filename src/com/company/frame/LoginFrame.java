package com.company.frame;

import com.company.ui.ImagePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 柏欢欢 on 2017/12/20.
 */
public class LoginFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel centrePanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;

    public LoginFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setVisible(true);
        setTitle("登录界面");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel = new ImagePanel(LoginFrame.this.getWidth(),LoginFrame.this.getHeight(),"26.jpg");
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,600,80));
        add(mainPanel);
        mainPanel.add(centrePanel);
        centrePanel.setPreferredSize(new Dimension(700,600));
        centrePanel.setBackground(new Color(255,255,255,100));//设置透明度
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
