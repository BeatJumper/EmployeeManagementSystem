///
/// @file evection_view.java
/// @brief 出差视图
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

import DAO.evectionDAO;
import model.evection_log;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class evection_view extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JTextField idText;
    private DAO.evectionDAO evectionDAO=new evectionDAO();
    private String R_ID;
    public evection_view(String R_ID) {
        this.R_ID=R_ID;
        setTitle("出差信息列表");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 39, 580, 300);
        contentPane.add(scrollPane);

        Object[] columns = {"ID", "出差地点", "出差目的", "开始时间","结束时间" };
        Object[][] data = null;
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        table(null);
        scrollPane.setViewportView(table);

        /*JLabel lblNewLabel = new JLabel("时间ID");//
        lblNewLabel.setBounds(10, 10, 42, 15);
        contentPane.add(lblNewLabel);

        idText = new JTextField();
        idText.setBounds(44, 8, 115, 21);
        contentPane.add(idText);
        idText.setColumns(10);

        //查询按钮
        JButton searchBtn = new JButton("查询");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table(idText.getText());
            }
        });
        searchBtn.setBounds(169, 8, 63, 23);
        contentPane.add(searchBtn);*/

        //添加按钮
        JButton addBtn = new JButton("添加");
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                e_AddView view = new e_AddView();//
                view.setVisible(true);
            }
        });
        addBtn.setBounds(365, 8, 63, 23);
        contentPane.add(addBtn);

        //修改按钮
        JButton updateBtn = new JButton("修改");
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取选中行
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(R_ID.equals(Integer.toString(3))){
                    String T_ID =table.getValueAt(row, 3).toString();
                    e_UpdateView view = new e_UpdateView(T_ID);
                    view.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(contentPane, "您没有权限修改此条记录！", "系统提示", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        updateBtn.setBounds(438, 8, 63, 23);

        //删除按钮
        JButton deleteBtn = new JButton("删除");
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 获取选中行
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int result = JOptionPane.showConfirmDialog(contentPane, "确认删除该记录吗？", "提示",
                        JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    if(R_ID.equals(Integer.toString(3))){
                        String T_ID = table.getValueAt(row, 3).toString();
                        boolean flag = evectionDAO.delete(T_ID);

                        if(flag){
                            JOptionPane.showMessageDialog(contentPane, "删除成功!");
                            table(null);
                        }else{
                            JOptionPane.showMessageDialog(contentPane, "操作失败", "系统提示", JOptionPane.WARNING_MESSAGE);
                        }}
                    else {
                        JOptionPane.showMessageDialog(contentPane, "您没有权限删除此条记录！", "系统提示", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });
        deleteBtn.setBounds(511, 8, 63, 23);
        contentPane.add(deleteBtn);
        contentPane.add(updateBtn);
    }

    // 填充表格数据
    public void table(String T_ID){
        List<evection_log> list = evectionDAO.queryList(T_ID);
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);// 刷新
        // 填充数据
        for (evection_log item : list) {
            String[] arr = new String[5];
            arr[0] = item.getT_ID() + "";
            arr[1] = item.getdestination();
            arr[2] = item.getobjective();
            arr[3] = "2009-10-18";
            arr[4] = "2009-10-20";
            // 写于2024年,用2009只是说明资历老
            // 添加数据到表格
            tableModel.addRow(arr);
        }
    }
}


