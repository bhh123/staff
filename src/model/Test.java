package model;

import com.company.ui.MyMouseAdapter;
import com.company.ui.Style;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 柏欢欢 on 2017/12/19.
 */
public class Test {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JLabel label;

    public Test() {
        mainPanel.setBackground(new Color(26,188,156));
        Style.setGroupButtonStyle(button1);

        button1.addMouseListener(new MyMouseAdapter(button1));



    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Test().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
