package model;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CheckPanel extends JPanel implements ActionListener{
    private List<String>checkList = new ArrayList<>();
    private CardLayout card = new CardLayout();
    private JPanel centerPanel = new JPanel();
    public CheckPanel(List<String>checkList){

        this.checkList =checkList;
        init();


    }
    public void init(){
        JButton[] jButtons = new JButton[checkList.size()];
        int i=0;
        for ( String str:checkList) {
            jButtons[i]= new JButton(str);
            jButtons[i].addActionListener(this);
            i++;
        }

        this.setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(7,1,0,50));
        for(int c=0;c<jButtons.length;c++){
           westPanel.add(jButtons[c]);
        }
        add(BorderLayout.WEST,westPanel);
        centerPanel.setLayout(card);
        /**
         * 个人考勤 card1
         */
        JPanel card1= new JPanel();
        card1.setBackground(Color.red);
        /**
         * 考勤管理 card2
         */
        JPanel card2 = new JPanel();
        card2.setBackground(Color.BLACK);
        centerPanel.add(card1,"1");
        centerPanel.add(card2,"2");
        add(BorderLayout.CENTER,centerPanel);



    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        List<String>list = new ArrayList<>();
        list.add("个人考勤");
        list.add("考勤管理");
        frame.add(new CheckPanel(list));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("个人考勤"))
            card.show(centerPanel,"1");
        if(e.getActionCommand().equals("考勤管理"))
            card.show(centerPanel,"2");
    }
}
