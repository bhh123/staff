package com.company.frame;

import com.company.factory.ServiceFactory;
import com.company.model.RewardPublish;
import com.company.service.RpService;
import com.company.ui.Style;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 柏欢欢 on 2017/12/21.
 */
public class RpPanel extends JPanel implements ActionListener {
    private List<String> rpList = new ArrayList<>();
    private CardLayout card = new CardLayout();
    private JPanel centerPanel = new JPanel();
    private String account;
    private RpService rpService = ServiceFactory.getRpServiceInstance();

    public RpPanel(List<String> rpList,String account) {
        this.rpList = rpList;
        this.account = account;
        init();
    }

    public void init(){
        JButton[] jButtons = new JButton[rpList.size()];
        int i=0;
        for ( String str:rpList) {
            jButtons[i]= new JButton(str);
            jButtons[i].addActionListener(this);
            i++;

        }
        this.setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(153,153,153));
        westPanel.setLayout(new GridLayout(5,1,0,100));
        JLabel jLabel = new JLabel();
        westPanel.add(jLabel);
        for(int rp =0; rp < jButtons.length; rp++){
            westPanel.add(jButtons[rp]);
            Style.setItemButtonStyle(jButtons[rp]);
        }
        add(BorderLayout.WEST,westPanel);
        centerPanel.setLayout(card);
        /**
         * 个人奖惩 card1
         */
        JPanel card1= new JPanel();
        card1.setLayout(new GridLayout(1,2,0,0));
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(1,194,196));
        //leftPanel.setLayout(new GridLayout(2,1,0,0));
        JLabel jLabel1 = new JLabel("个人奖励情况");
        jLabel1.setFont(new Font("微软雅黑",Font.PLAIN,24));
        leftPanel.add(jLabel1);
        JScrollPane jScrollPane = new JScrollPane();
        //jScrollPane.setBackground(new Color(255,255,255,0));
//        List<RewardPublish> list = rpService.getRP(account);
//        for (RewardPublish rp : list) {
//            if ("奖".equals(rp.getFlag())) {
//                JTextArea textArea = new JTextArea(rp.getRp_name() + "   " + rp.getRp_time() + "\r\n");
//                textArea.setFont(new Font("", Font.PLAIN, 20));
//                jScrollPane.add(textArea);
                  leftPanel.add(BorderLayout.CENTER,jScrollPane);
//                JList list1 = new JList(rp.getRp_name() +" " +rp.getRp_time() + "    ");
//                jScrollPane.add(list1);
  //          }
//            if ("惩".equals(rp.getMark())) {
//                JLabel jLabel = new JLabel(rp.getTime() + " "+ rp.getInfo() + "    ");
//                publishPanel.add(jLabel);
//                jLabel.setFont(new Font("",Font.PLAIN,20));
//            }
   //     }
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255,194,150));
        JLabel jLabel2 = new JLabel("个人惩罚情况");
        jLabel2.setFont(new Font("微软雅黑",Font.PLAIN,24));
        rightPanel.add(jLabel2);
        card1.add(leftPanel);
        card1.add(rightPanel);

        /**
         * 奖惩管理 card2
         */
        JPanel card2 = new JPanel();
        card2.setBackground(new Color(186,194,196));

        centerPanel.add(card1,"1");
        centerPanel.add(card2,"2");
        add(BorderLayout.CENTER,centerPanel);



    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        List<String> list = new ArrayList<>();
        list.add("个人奖惩");
        list.add("奖惩管理");
        frame.add(new RpPanel(list,"1001"));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("个人奖惩")){
            card.show(centerPanel,"1");
        }
        if(e.getActionCommand().equals("奖惩管理")){
            card.show(centerPanel,"2");
        }
    }
}
