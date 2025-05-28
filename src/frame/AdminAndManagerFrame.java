package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAndManagerFrame {
    private String M_ID;
    private String R_ID;

    public AdminAndManagerFrame(String M_ID, String R_ID) {
        this.M_ID = M_ID;
        this.R_ID = R_ID;
    }

    public void aFrame() {
        JFrame a = new JFrame();
        a.setSize(1000, 600);
        a.setTitle("nwpu 员工管理");
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Color lightBlue = new Color(173, 216, 230);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setBackground(lightBlue);
        panel2.setBackground(lightBlue);
        JPanel panel3 = new JPanel();
        panel3.setBackground(lightBlue);
        JPanel panel4 = new JPanel();
        panel4.setBackground(lightBlue);
        Dimension d1 = new Dimension(1200, 50);
        panel1.setPreferredSize(d1);
        Dimension d2 = new Dimension(150, 50);
        panel2.setPreferredSize(d2);
        Dimension d4 = new Dimension(1200, 80);
        panel4.setPreferredSize(d4);
        panel1.setLayout(null);
        JLabel label1 = new JLabel();
        String identity = "";
        if (R_ID.equals(Integer.toString(2))) {
            identity = "企业经理";
        }
        if (R_ID.equals(Integer.toString(3))) {
            identity = "DBA";
        }
        JLabel label3 = new JLabel("你的职位：" + identity);
        label1.setText("ID: " + M_ID);

        label1.setBounds(750, 0, 100, 50);

        label3.setBounds(300, 0, 300, 50);
        Font labelFont1 = new Font("微软雅黑", Font.BOLD, 24);
        Font labelFont2 = new Font("微软雅黑", Font.BOLD, 20);

        label1.setFont(labelFont1);  // 设置 label1 的字体
        label3.setFont(labelFont2);  // 设置 label3 的字体
        panel1.add(label1);

        panel1.add(label3);

        Dimension d_button = new Dimension(150, 35);
        //JButton button1 = new JButton("员工信息管理");
        JButton button2 = new JButton("奖惩管理");
        JButton button3 = new JButton("出差管理");
        JButton button5 = new JButton("培训管理");
        JButton button6 = new JButton("返回登录");
        //button1.setPreferredSize(d_button);
        button2.setPreferredSize(d_button);
        button3.setPreferredSize(d_button);
        button5.setPreferredSize(d_button);
        button6.setPreferredSize(d_button);
        FlowLayout layout = new FlowLayout();
        panel2.setLayout(layout);
        //panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button5);
        panel2.add(button6);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evection_view frame = new evection_view(R_ID);
                frame.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rewards_view frame = new rewards_view(R_ID);
                frame.setVisible(true);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                train_view frame = new train_view(R_ID);
                frame.setVisible(true);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login l=new login();
                a.dispose();
                l.loginFrame();
            }
        });
        a.add(panel1, BorderLayout.NORTH);
        a.add(panel2, BorderLayout.WEST);
        a.setVisible(true);
    }
}