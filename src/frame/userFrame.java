package frame;

import DButils.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class userFrame {
    private String M_ID;
    public userFrame(String M_ID){
        this.M_ID=M_ID;
    }
    public void uFrame(){
        JFrame u=new JFrame();
        u.setSize(1200,800);
        u.setTitle("雷煜笙 康懿坤 李明泽 员工管理系统");
        u.setLocationRelativeTo(null);
        u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Color lightBlue = new Color(173, 216, 230);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setBackground(lightBlue);
        panel2.setBackground(lightBlue);
        JPanel panel3 = new JPanel();
        Dimension d1 = new Dimension(1100,150);
        panel1.setPreferredSize(d1);
        Dimension d2 = new Dimension(150,50);
        panel2.setPreferredSize(d2);
        panel1.setLayout(null);
        JLabel label1 = new JLabel();
        JLabel label3 = new JLabel("And in case I don't see you, good afternoon, good evening and good night!");
        label1.setText("你的UID: " + M_ID);

        // 设置标签文本的字体和大小
        Font labelFont1 = new Font("微软雅黑", Font.BOLD, 24);
        Font labelFont2 = new Font("微软雅黑", Font.BOLD, 20);

        label1.setFont(labelFont1);  // 设置 label1 的字体
        label3.setFont(labelFont2);  // 设置 label3 的字体

        label1.setBounds(180, 50 ,1000,50);
        label3.setBounds(400, 50 ,1000,50);
        panel1.add(label1);
        panel1.add(label3);
        Dimension d_button = new Dimension(150,35);
        JButton button1=new JButton("我的信息");
        JButton button2=new JButton("我的信息修改");
        JButton button3=new JButton("我的奖惩记录");
        JButton button4=new JButton("我的出差记录");
        JButton button5=new JButton("我的培训记录");
        JButton button6=new JButton("返回至主界面");
        button1.setPreferredSize(d_button);
        button2.setPreferredSize(d_button);
        button3.setPreferredSize(d_button);
        button4.setPreferredSize(d_button);
        button5.setPreferredSize(d_button);
        button6.setPreferredSize(d_button);
        FlowLayout layout = new FlowLayout();
        panel2.setLayout(layout);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        JButton button7 = new JButton("奖惩记录统计");
        button7.setPreferredSize(new Dimension(150, 35));
        panel2.add(button7);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login l=new login();
                u.dispose();
                l.loginFrame();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = null;
                try {
                    panel3.removeAll(); // 移除原有内容
                    u.remove(panel3); // 移除面板
                    Connection conn = util.getConn();
                    Statement statement = conn.createStatement();
                    sql = "select count(M_ID), M_ID, M_Name, entryTime, position, phone, status from memberinfo where M_ID=" + M_ID;
                    ResultSet rs = statement.executeQuery(sql);
                    rs.next();
                    String M_ID = rs.getString(2);
                    int ok = rs.getInt(1);
                    String M_Name = rs.getString(3);
                    Date entryTime = rs.getDate(4);
                    String position = rs.getString(5);
                    String phone = rs.getString(6);
                    String status = rs.getString(7);

                    if (ok > 0) {
                        // 设置统一的字体
                        Font largeFont = new Font("微软雅黑", Font.BOLD, 20);

                        // 设置BoxLayout布局让字段纵向排列
                        BoxLayout boxLayout = new BoxLayout(panel3, BoxLayout.Y_AXIS);
                        panel3.setLayout(boxLayout);

                        // 增加间距
                        panel3.add(Box.createVerticalStrut(20));  // 上间距

                        // ID字段
                        JLabel j1 = new JLabel("ID: " + M_ID);
                        j1.setFont(largeFont); // 设置字体
                        j1.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中显示
                        panel3.add(j1);

                        panel3.add(Box.createVerticalStrut(10));  // 字段之间的间距

                        // 姓名字段
                        JLabel j2 = new JLabel("姓名: " + M_Name);
                        j2.setFont(largeFont); // 设置字体
                        j2.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中显示
                        panel3.add(j2);

                        panel3.add(Box.createVerticalStrut(10));  // 字段之间的间距

                        // 入职日期
                        JTextArea j3 = new JTextArea("入职日期: " + entryTime);
                        j3.setFont(largeFont); // 设置字体
                        j3.setEditable(false);  // 设置为不可编辑
                        j3.setBackground(new Color(0, 0, 0, 0)); // 设置背景透明
                        j3.setLineWrap(true);  // 自动换行
                        j3.setWrapStyleWord(true); // 保证不会拆字
                        j3.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中显示
                        panel3.add(j3);

                        panel3.add(Box.createVerticalStrut(10));  // 字段之间的间距

                        // 职位
                        JTextArea j4 = new JTextArea("职位: " + position);
                        j4.setFont(largeFont); // 设置字体
                        j4.setEditable(false);  // 设置为不可编辑
                        j4.setBackground(new Color(0, 0, 0, 0)); // 设置背景透明
                        j4.setLineWrap(true);  // 自动换行
                        j4.setWrapStyleWord(true); // 保证不会拆字
                        j4.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中显示
                        panel3.add(j4);

                        panel3.add(Box.createVerticalStrut(10));  // 字段之间的间距

                        // 联系方式
                        JTextArea j5 = new JTextArea("联系方式: " + phone);
                        j5.setFont(largeFont); // 设置字体
                        j5.setEditable(false);  // 设置为不可编辑
                        j5.setBackground(new Color(0, 0, 0, 0)); // 设置背景透明
                        j5.setLineWrap(true);  // 自动换行
                        j5.setWrapStyleWord(true); // 保证不会拆字
                        j5.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中显示
                        panel3.add(j5);

                        panel3.add(Box.createVerticalStrut(10));  // 字段之间的间距

                        // 状态
                        JTextArea j6 = new JTextArea("状态: " + status);
                        j6.setFont(largeFont); // 设置字体
                        j6.setEditable(false);  // 设置为不可编辑
                        j6.setBackground(new Color(0, 0, 0, 0)); // 设置背景透明
                        j6.setLineWrap(true);  // 自动换行
                        j6.setWrapStyleWord(true); // 保证不会拆字
                        j6.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中显示
                        panel3.add(j6);

                        // 添加完字段后，重新布局
                        u.add(panel3, BorderLayout.CENTER);
                        u.validate();  // 刷新界面，添加新内容
                    }

                    u.revalidate();
                    u.repaint();
                } catch (Exception exception) {
                    System.out.println("DB connect error QAQ");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空主内容区域
                u.remove(panel3);
                panel3.removeAll();

                // 设置为纵向排列布局
                BoxLayout boxLayout = new BoxLayout(panel3, BoxLayout.Y_AXIS);
                panel3.setLayout(boxLayout);

                // 设置组件字体为微软雅黑，字号为16
                Font font = new Font("微软雅黑", Font.PLAIN, 16);

                // 弹出权限提示框
                JOptionPane.showMessageDialog(null, "您只有修改密码和电话的权限");

                // 创建新内容组件
                JLabel l1 = new JLabel("新密码");
                JLabel l3 = new JLabel("请再次输入新密码");
                JLabel l2 = new JLabel("电话");
                JTextField f1 = new JTextField();
                JTextField f2 = new JTextField();
                JTextField f3 = new JTextField();
                JButton button = new JButton("确认修改");

                // 设置字体
                l1.setFont(font);
                l2.setFont(font);
                l3.setFont(font);
                f1.setFont(font);
                f2.setFont(font);
                f3.setFont(font);
                button.setFont(font);

                // 设置组件尺寸
                l1.setPreferredSize(new Dimension(150, 35));
                l2.setPreferredSize(new Dimension(150, 35));
                l3.setPreferredSize(new Dimension(150, 35));
                Dimension d = new Dimension(200, 35);
                f1.setPreferredSize(d);
                f2.setPreferredSize(d);
                f3.setPreferredSize(d);
                button.setPreferredSize(new Dimension(200, 50));

                // 添加组件到panel3
                panel3.add(l1);
                panel3.add(f1);
                panel3.add(l3);
                panel3.add(f3);
                panel3.add(l2);
                panel3.add(f2);
                panel3.add(button);

                // 添加间隔
                panel3.add(Box.createVerticalStrut(20)); // 添加字段之间的间隔

                // 刷新并显示panel3
                panel3.revalidate(); // 重新布局panel3
                panel3.repaint();    // 重绘panel3
                u.add(panel3, BorderLayout.CENTER); // 添加panel3到主界面
                u.revalidate(); // 刷新主界面布局
                u.repaint();    // 重绘主界面

                // 按钮功能：确认修改
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String passwordtext = f1.getText();
                        String passwordtext2 = f3.getText();
                        String phonetext = f2.getText();
                        String sql;
                        String sql1;

                        if (passwordtext.equals(passwordtext2)) {
                            try {
                                Connection conn = util.getConn();
                                Statement statement = conn.createStatement();
                                sql = "update member set m_password='" + passwordtext + "' where M_ID=" + M_ID;
                                sql1 = "update memberinfo set phone='" + phonetext + "' where M_ID=" + M_ID;
                                statement.addBatch(sql);
                                statement.addBatch(sql1);
                                int[] rs = statement.executeBatch();
                                if (rs[0] > 0) {
                                    JOptionPane.showMessageDialog(null, "修改成功！");
                                }
                            } catch (Exception e1) {
                                JOptionPane.showMessageDialog(null, "数据库错误！");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重新输入！");
                        }
                    }
                });
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空主内容区域
                u.remove(panel3);
                panel3.removeAll();
                panel3.setLayout(new BorderLayout()); // 使用适合表格显示的布局

                // 定义表格列和数据
                Object[] columns = {"奖惩ID", "奖惩名称", "奖惩类型", "奖惩时间"};
                Object[][] data = new fun().table1(); // 获取表格数据

                // 创建表格并设置其属性
                JTable table = new JTable(data, columns);
                table.setRowHeight(40); // 设置每行高度
                table.setPreferredScrollableViewportSize(new Dimension(950, 650)); // 设置表格大小

                // 将表格放入滚动面板
                JScrollPane scrollPane = new JScrollPane(table);
                panel3.add(scrollPane, BorderLayout.CENTER); // 添加滚动面板到panel3

                // 刷新并显示panel3
                panel3.revalidate(); // 重新布局panel3
                panel3.repaint();    // 重绘panel3
                u.add(panel3, BorderLayout.CENTER); // 将panel3添加回主界面
                u.revalidate(); // 刷新主界面布局
                u.repaint();    // 重绘主界面
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空主内容区域
                u.remove(panel3);
                panel3.removeAll();
                panel3.setLayout(new BorderLayout()); // 使用适合表格显示的布局

                // 定义表格列和数据
                Object[] columns = {"ID", "出差地点", "出差目的", "开始时间", "结束时间"};
                Object[][] data = new fun().table2(); // 获取表格数据

                // 创建表格并设置其属性
                JTable table = new JTable(data, columns);
                table.setRowHeight(40); // 设置每行高度
                table.setPreferredScrollableViewportSize(new Dimension(950, 650)); // 设置表格显示范围

                // 将表格放入滚动面板
                JScrollPane scrollPane = new JScrollPane(table);
                panel3.add(scrollPane, BorderLayout.CENTER); // 将滚动面板添加到panel3

                // 刷新并显示panel3
                panel3.revalidate(); // 重新布局panel3
                panel3.repaint();    // 重绘panel3
                u.add(panel3, BorderLayout.CENTER); // 添加panel3到主界面
                u.revalidate(); // 刷新主界面布局
                u.repaint();    // 重绘主界面
            }
        });


        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空主内容区域
                u.remove(panel3);
                panel3.removeAll();
                panel3.setLayout(new BorderLayout()); // 使用适合表格显示的布局

                // 定义表格列和数据
                Object[] columns = {"ID", "培训内容", "培训成果", "开始时间", "结束时间"};
                Object[][] data = new fun().table3(); // 获取表格数据

                // 创建表格并设置其属性
                JTable table = new JTable(data, columns);
                table.setRowHeight(40); // 设置每行高度
                table.setPreferredScrollableViewportSize(new Dimension(950, 650)); // 设置表格显示范围

                // 将表格放入滚动面板
                JScrollPane scrollPane = new JScrollPane(table);
                panel3.add(scrollPane, BorderLayout.CENTER); // 将滚动面板添加到panel3

                // 刷新并显示panel3
                panel3.revalidate(); // 重新布局panel3
                panel3.repaint();    // 重绘panel3
                u.add(panel3, BorderLayout.CENTER); // 添加panel3到主界面
                u.revalidate(); // 刷新主界面布局
                u.repaint();    // 重绘主界面
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清空主内容区域
                u.remove(panel3);
                panel3.removeAll();

                // 设置panel3的布局为居中
                panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

                // 统计奖励次数和惩罚次数
                fun funObj = new fun();
                int[] counts = funObj.getRewardAndPunishmentCount(M_ID);

                int rewardCount = counts[0];
                int punishmentCount = counts[1];

                // 创建显示文本
                String message = String.format("你今年接受奖励%d次，接受惩罚%d次，加油哦φ(゜▽゜*)♪", rewardCount, punishmentCount);

                // 显示文本
                JLabel label = new JLabel(message);
                label.setFont(new Font("微软雅黑", Font.PLAIN, 20));  // 设置字体为微软雅黑，字号20
                label.setHorizontalAlignment(JLabel.CENTER); // 居中显示

                // 将文本添加到panel3
                panel3.add(label);

                // 刷新界面
                panel3.revalidate();
                panel3.repaint();
                u.add(panel3, BorderLayout.CENTER);
                u.revalidate();
                u.repaint();
            }
        });

        u.add(panel1,BorderLayout.NORTH);
        u.add(panel2,BorderLayout.WEST);
        u.setVisible(true);
    }

    class fun{
        // 返回奖励和惩罚的次数
        public int[] getRewardAndPunishmentCount(String M_ID) {
            int[] counts = new int[2]; // counts[0] 用于奖励次数，counts[1] 用于惩罚次数
            Connection conn = null;
            PreparedStatement st = null;
            ResultSet rsReward = null;
            ResultSet rsPunishment = null;

            try {
                conn = util.getConn();

                // 查询奖励次数
                String sqlReward = "SELECT COUNT(*) FROM rewards_log WHERE rewards_type = '奖励' AND YEAR(rewards_time) = YEAR(CURDATE()) AND M_ID = ?";
                st = conn.prepareStatement(sqlReward);
                st.setString(1, M_ID);
                rsReward = st.executeQuery();
                if (rsReward.next()) {
                    counts[0] = rsReward.getInt(1); // 奖励次数
                }

                // 查询惩罚次数
                String sqlPunishment = "SELECT COUNT(*) FROM rewards_log WHERE rewards_type = '惩罚' AND YEAR(rewards_time) = YEAR(CURDATE()) AND M_ID = ?";
                st = conn.prepareStatement(sqlPunishment);
                st.setString(1, M_ID);
                rsPunishment = st.executeQuery();
                if (rsPunishment.next()) {
                    counts[1] = rsPunishment.getInt(1); // 惩罚次数
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rsReward != null) rsReward.close();
                    if (rsPunishment != null) rsPunishment.close();
                    if (st != null) st.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return counts;
        }

        public Object[][] table1(){
            Object[][] data = new String[20][4];
            Connection conn = null;
            PreparedStatement st = null;
            ResultSet rs = null;
            try {
                conn = util.getConn();
                String sql = "SELECT rewards_ID, rewards_Name, rewards_type,rewards_time FROM rewards_log WHERE M_ID = ?";//编写sql
                st = conn.prepareStatement(sql);//预编译
                st.setString(1,M_ID);
                rs = st.executeQuery();//执行
                for (int i=0; rs.next(); i++){
                    data[i][0] = rs.getString("rewards_ID");
                    data[i][1] = rs.getString("rewards_Name");
                    data[i][2] = rs.getString("rewards_type");
                    data[i][3] = rs.getString("rewards_time");
                }
                return data;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return data;
        }
        public Object[][] table2(){
            Object[][] data = new String[20][5];
            Connection conn = null;
            PreparedStatement st = null;
            ResultSet rs = null;
            try {
                conn = util.getConn();
                String sql1 = "select time.T_ID,destination,objective,start_time,end_time from time,evection_log where time.T_ID=evection_log.T_ID and M_ID = ?";//编写sql
                st = conn.prepareStatement(sql1);//预编译
                st.setString(1,M_ID);
                rs = st.executeQuery();//执行
                for (int i=0; rs.next(); i++){
                    data[i][0] = rs.getString("time.T_ID");
                    data[i][1] = rs.getString("destination");
                    data[i][2] = rs.getString("objective");
                    data[i][3] = rs.getString("start_time");
                    data[i][4] = rs.getString("end_time");
                }
                return data;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return data;
        }
        public Object[][] table3(){
            Object[][] data = new String[20][5];
            Connection conn = null;
            PreparedStatement st = null;
            ResultSet rs = null;
            try {
                conn = util.getConn();
                String sql1 = "select time.T_ID,train_content,train_achieve,start_time,end_time from time,train_log where time.T_ID=train_log.T_ID and M_ID = ?";
                st = conn.prepareStatement(sql1);//预编译
                st.setString(1,M_ID);
                rs = st.executeQuery();//执行
                for (int i=0; rs.next(); i++){
                    data[i][0] = rs.getString("time.T_ID");
                    data[i][1] = rs.getString("train_content");
                    data[i][2] = rs.getString("train_achieve");
                    data[i][3] = rs.getString("start_time");
                    data[i][4] = rs.getString("end_time");
                }
                return data;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return data;
        }
    }
}

