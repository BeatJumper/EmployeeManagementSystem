package frame;

import DAO.trainDAO;
import model.train_log;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class t_AddView extends JFrame {

    private JPanel contentPane;
    private JTextField train_contentText;
    private JTextField train_achieveText;
    private JTextField T_IDText;
    private DAO.trainDAO trainDAO = new trainDAO();

    public t_AddView() {
        setTitle("培训信息添加");
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

        JLabel lblNewLabel_1 = new JLabel("培训内容：");
        lblNewLabel_1.setBounds(110, 150, 60, 15);
        contentPane.add(lblNewLabel_1);

        train_contentText = new JTextField();
        train_contentText.setBounds(180, 150, 160, 21);
        contentPane.add(train_contentText);
        train_contentText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("培训成果：");
        lblNewLabel_2.setBounds(110, 200, 65, 15);
        contentPane.add(lblNewLabel_2);

        train_achieveText = new JTextField();
        train_achieveText.setBounds(180, 200, 160, 21);
        contentPane.add(train_achieveText);
        train_achieveText.setColumns(10);

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String T_ID = T_IDText.getText();
                String train_content = train_contentText.getText();
                String train_achieve = train_achieveText.getText();

                if(T_ID == null || "".equals(T_ID)){
                    JOptionPane.showMessageDialog(contentPane, "请输入时间ID", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(train_content== null || "".equals(train_content)){
                    JOptionPane.showMessageDialog(contentPane, "请输入培训内容", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(train_achieve == null || "".equals(train_achieve)){
                    JOptionPane.showMessageDialog(contentPane, "请输入培训成果", "系统提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                train_log trainLog = new train_log();
                trainLog.setT_ID(T_ID);
                trainLog.settrain_content(train_content);
                trainLog.settrain_achieve(train_achieve);
                boolean flag = trainDAO.save(trainLog);
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

