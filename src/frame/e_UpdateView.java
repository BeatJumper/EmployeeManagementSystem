package frame;

import DAO.evectionDAO;
import model.evection_log;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class e_UpdateView extends JFrame {

    private JPanel contentPane;
    private JTextField destinationText;
    private JTextField objectiveText;
    private JTextField T_IDText;
    private DAO.evectionDAO evectionDAO = new evectionDAO();

    public e_UpdateView(String T_ID) {
        setTitle("出差信息修改");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("时间ID：");
        lblNewLabel.setBounds(110, 100, 60, 15);
        contentPane.add(lblNewLabel);

        T_IDText = new JTextField();
        T_IDText.setBounds(180, 100, 160, 21);
        contentPane.add(T_IDText);
        T_IDText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("出差地点：");
        lblNewLabel_1.setBounds(110, 150, 60, 15);
        contentPane.add(lblNewLabel_1);

        destinationText = new JTextField();
        destinationText.setBounds(180, 150, 160, 21);
        contentPane.add(destinationText);
        destinationText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("出差目的：");
        lblNewLabel_2.setBounds(110, 200, 65, 15);
        contentPane.add(lblNewLabel_2);

        objectiveText = new JTextField();
        objectiveText.setBounds(180, 200, 160, 21);
        contentPane.add(objectiveText);
        objectiveText.setColumns(10);

        /*JTextField typeText = new JTextField();
        typeText.setBounds(180, 250, 160, 21);
        contentPane.add(typeText);
        typeText.setColumns(10);*/

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String T_ID = T_IDText.getText();
                String destination = destinationText.getText();
                String objective = objectiveText.getText();

                if(T_ID == null || "".equals(T_ID)){
                    JOptionPane.showMessageDialog(contentPane, "请输入时间ID", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(destination == null || "".equals(destination)){
                    JOptionPane.showMessageDialog(contentPane, "请输入出差地点", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(objective == null || "".equals(objective)){
                    JOptionPane.showMessageDialog(contentPane, "请输入出差目的", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                evection_log evectionLog = new evection_log();
                evectionLog.setT_ID(T_ID);
                evectionLog.setdestination(destination);
                evectionLog.setobjective(objective);
                boolean flag = evectionDAO.save(evectionLog);
                if(flag){
                    dispose();
                    JOptionPane.showMessageDialog(contentPane, "修改成功!");
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

