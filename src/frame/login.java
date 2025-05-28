package frame;

import DButils.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login {
    public static void main(String[] args){
        login l = new login();
        l.loginFrame();
    }

    public void loginFrame() {
        JFrame f = new JFrame();
        f.setSize(500, 550);  // 增加界面高度到 500x550
        f.setTitle("欢迎来到员工管理系统2025~");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout();
        f.setLayout(layout);

        // 创建输入框部分
        JLabel label1 = new JLabel("UID");
        JLabel label2 = new JLabel("pwd");
        //JLabel label3 = new JLabel("西北工业大学数据库系统课程设计");
        JTextField id = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton button = new JButton("login！");
        Dimension d1 = new Dimension(150, 35);
        label1.setPreferredSize(d1);
        label2.setPreferredSize(d1);
        //label3.setPreferredSize(d1);
        Dimension d2 = new Dimension(200, 35);
        id.setPreferredSize(d2);
        password.setPreferredSize(d2);
        Dimension d3 = new Dimension(400, 35);
        button.setPreferredSize(d3);
        //label3.setBounds(0, 500, 400, 35);

        f.add(label1);
        f.add(id);
        f.add(label2);
        f.add(password);
        f.add(button);

        // 增加图片
        // 创建一个面板，用来放置图片
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        // 加载图片
        ImageIcon backgroundIcon = new ImageIcon("res/login.jpg"); // 图片路径
        if (backgroundIcon.getIconWidth() == -1) {
            System.out.println("图片加载失败，检查图片路径！");
        } else {
            // 缩放图片
            Image backgroundImage = backgroundIcon.getImage();
            Image scaledImage = backgroundImage.getScaledInstance(500, 300, Image.SCALE_SMOOTH); // 缩放图片
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // 显示图片
            JLabel backgroundLabel = new JLabel(scaledIcon);
            backgroundLabel.setHorizontalAlignment(JLabel.CENTER);  // 图片居中显示
            imagePanel.add(backgroundLabel, BorderLayout.CENTER);

            // 将图片面板添加到 JFrame 的 South（底部）区域
            f.add(imagePanel, BorderLayout.SOUTH);
        }
        // 增加文本
        JPanel textPanel = new JPanel();  // 创建一个面板用于显示文本
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // 居中显示文本

        // 创建 JLabel 来显示文本
        JLabel textLabel = new JLabel("西北工业大学软件工程实验课程设计");
        textLabel.setFont(new Font("微软雅黑", Font.PLAIN, 26));  // 设置字体和大小
        textLabel.setForeground(Color.BLACK);  // 设置字体颜色

        // 将文本标签添加到面板
        textPanel.add(textLabel);

        // 将文本面板添加到 JFrame 的 South（底部）区域
        f.add(textPanel, BorderLayout.SOUTH);
        f.setVisible(true);
        f.setResizable(false);

        // 登录按钮点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String idText = id.getText();
                String passwordText = new String(password.getPassword());
                String sql = null;
                try {
                    Connection conn = util.getConn();
                    Statement statement = conn.createStatement();
                    sql = "select count(M_ID), M_ID, R_ID from member where M_ID=" + idText + " and m_password=" + passwordText;
                    ResultSet rs = statement.executeQuery(sql);
                    rs.next();
                    String R_ID = rs.getString("R_ID");
                    String M_ID = rs.getString("M_ID");

                    int ok = rs.getInt(1);
                    if (ok > 0) {
                        f.dispose();
                        JOptionPane.showMessageDialog(null, "匹配成功，欢迎来到员工管理系统！");
                        if (R_ID.equals(Integer.toString(1))) {
                            userFrame uframe = new userFrame(M_ID);
                            uframe.uFrame();
                        } else {
                            AdminAndManagerFrame aframe = new AdminAndManagerFrame(M_ID, R_ID);
                            aframe.aFrame();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "你的密码或者UID错误！");
                    }
                } catch (Exception e) {
                    System.out.println("检测到数据库的连接异常！请确认网络状况。。。");
                }
            }
        });
    }
}
