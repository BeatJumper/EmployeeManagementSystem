///
/// @file login.java
/// @brief 登录界面
/// @author kangyk (1253@mail.nwpu.edu.cn)
/// @version 1.1
/// @date 2025-06-05
///
/// @copyright Copyright (c) 2025
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author  <th>Description
/// <tr><td>2025-05-20 <td>1.0     <td>kangyk  <td>新建
/// <tr><td>2025-05-29 <td>1.1     <td>kangyk  <td>图片嵌入
/// </table>
///

package frame;

import DButils.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class login {
    public static void main(String[] args){
        login l = new login();
        l.loginFrame();
    }

    public void loginFrame() {
        JFrame f = new JFrame();
        f.setSize(800, 500);  // 调整窗口大小为 800x500
        f.setTitle("欢迎来到员工管理系统2025~");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());  // 使用 BorderLayout 布局

        // 左侧图片部分
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(320, 500));  // 左侧占窗口宽度的 2/6

        ImageIcon backgroundIcon = new ImageIcon("res/OIP.jpg"); // 图片路径
        if (backgroundIcon.getIconWidth() == -1) {
            System.out.println("图片加载失败，检查图片路径！");
        } else {
            Image backgroundImage = backgroundIcon.getImage();
            Image scaledImage = backgroundImage.getScaledInstance(320, 500, Image.SCALE_SMOOTH); // 缩放图片
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel backgroundLabel = new JLabel(scaledIcon);
            backgroundLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(backgroundLabel, BorderLayout.CENTER);
        }

        // 右侧登录界面部分
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        loginPanel.setPreferredSize(new Dimension(480, 500));  // 右侧占窗口宽度的 4/6

        JLabel label1 = new JLabel("UID");
        JLabel label2 = new JLabel("pwd");
        JTextField id = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton button = new JButton("login！");

        Dimension d1 = new Dimension(150, 35);
        label1.setPreferredSize(d1);
        label2.setPreferredSize(d1);
        Dimension d2 = new Dimension(200, 35);
        id.setPreferredSize(d2);
        password.setPreferredSize(d2);
        Dimension d3 = new Dimension(200, 35);
        button.setPreferredSize(d3);

        loginPanel.add(label1);
        loginPanel.add(id);
        loginPanel.add(label2);
        loginPanel.add(password);
        loginPanel.add(button);

        // 添加文本说明
        JLabel textLabel = new JLabel("西北工业大学软件工程实验课程设计");
        textLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        textLabel.setForeground(Color.BLACK);
        loginPanel.add(textLabel);

        // 将左右两部分添加到主窗口
        f.add(imagePanel, BorderLayout.WEST);
        f.add(loginPanel, BorderLayout.CENTER);

        f.setVisible(true);
        f.setResizable(false);

        // 登录按钮点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String idText = id.getText();
                String passwordText = new String(password.getPassword());
                try {
                    Connection conn = util.getConn();
                    Statement statement = conn.createStatement();
                    String sql = "select count(M_ID), M_ID, R_ID from member where M_ID=" + idText + " and m_password=" + passwordText;
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

    public boolean validateCredentials(String idText, String passwordText) {
        String sql = "select count(M_ID) from member where M_ID=? and m_password=?";
        try (Connection conn = util.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idText);
            pstmt.setString(2, passwordText);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // 返回是否匹配成功
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
