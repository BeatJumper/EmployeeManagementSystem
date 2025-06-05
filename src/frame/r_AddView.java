///
/// @file r_AddView.java
/// @brief 增加视图
/// @author 四维数组
/// @version 1.1
/// @date 2025-05-29
///
/// @copyright Copyright (c) 2025
///
/// @par 修改日志:
/// <table>
/// <tr><th>Date       <th>Version <th>Author       <th>Description
/// <tr><td>2025-05-20 <td>1.0     <td>siweishuzu   <td>新建
/// <tr><td>2025-05-29 <td>1.1     <td>siweishuzu   <td>注释增加
/// </table>
///

package frame;


import DAO.rewardsDAO;
import model.rewards_log;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class r_AddView extends JFrame {

    private JPanel contentPane;
    private JTextField mIDText;
    private JTextField rIDText;
    private JTextField rnameText;
    private JTextField typeText;
    private rewardsDAO rewardsDAO = new rewardsDAO();


    public r_AddView() {
        setTitle("奖惩信息添加");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("员工ID：");
        lblNewLabel.setBounds(110, 100, 60, 15);
        contentPane.add(lblNewLabel);

        mIDText = new JTextField();
        mIDText.setBounds(180, 100, 160, 21);
        contentPane.add(mIDText);
        mIDText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("奖惩ID：");
        lblNewLabel_1.setBounds(110, 150, 60, 15);
        contentPane.add(lblNewLabel_1);

        rIDText = new JTextField();
        rIDText.setBounds(180, 150, 160, 21);
        contentPane.add(rIDText);
        rIDText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("奖惩名称：");
        lblNewLabel_2.setBounds(110, 200, 65, 15);
        contentPane.add(lblNewLabel_2);

        rnameText = new JTextField();
        rnameText.setBounds(180, 200, 160, 21);
        contentPane.add(rnameText);
        rnameText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("奖惩类型：");
        lblNewLabel_3.setBounds(110, 250, 65, 15);
        contentPane.add(lblNewLabel_3);

        typeText = new JTextField();
        typeText.setBounds(180, 250, 160, 21);
        contentPane.add(typeText);
        typeText.setColumns(10);

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String M_ID = mIDText.getText();
                String rewards_ID = rIDText.getText();
                String rewards_Name = rnameText.getText();
                String rewards_type = typeText.getText();
                if(M_ID == null || "".equals(M_ID)){
                    JOptionPane.showMessageDialog(contentPane, "请输入员工ID", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(rewards_ID == null || "".equals(rewards_ID)){
                    JOptionPane.showMessageDialog(contentPane, "请输入奖惩ID", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(rewards_Name == null || "".equals(rewards_Name)){
                    JOptionPane.showMessageDialog(contentPane, "请输入奖惩名称", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(rewards_type == null || "".equals(rewards_type)){
                    JOptionPane.showMessageDialog(contentPane, "请输入奖惩类型", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                rewards_log rewardsLog = new rewards_log();
                rewardsLog.setM_ID(M_ID);
                rewardsLog.setRewards_ID(rewards_ID);
                rewardsLog.setRewards_name(rewards_Name);
                rewardsLog.setRewards_type(rewards_type);
                boolean flag = rewardsDAO.save(rewardsLog);
                if(flag){
                    dispose();
                    JOptionPane.showMessageDialog(contentPane, "添加成功!");
                }else{
                    JOptionPane.showMessageDialog(contentPane, "操作失败", "系统提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        saveBtn.setBounds(150, 300, 74, 23);
        contentPane.add(saveBtn);
        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelBtn.setBounds(240, 300, 74, 23);
        contentPane.add(cancelBtn);
    }

}
