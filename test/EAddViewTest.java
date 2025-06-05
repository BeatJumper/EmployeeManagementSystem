import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;
import frame.e_AddView;

public class EAddViewTest {
    @Test
    void testSaveButtonWithValidInput() {
        e_AddView view = new e_AddView();
        JTextField T_IDText = (JTextField) view.getContentPane().getComponent(1);
        JTextField destinationText = (JTextField) view.getContentPane().getComponent(3);
        JTextField objectiveText = (JTextField) view.getContentPane().getComponent(5);

        T_IDText.setText("123");
        destinationText.setText("北京");
        objectiveText.setText("商务会议");

        JButton saveBtn = (JButton) view.getContentPane().getComponent(7);
        saveBtn.doClick();

        // 验证是否弹出成功提示框
        assertEquals("添加成功!", JOptionPane.showInputDialog(null));
    }

    @Test
    void testSaveButtonWithEmptyFields() {
        e_AddView view = new e_AddView();
        JTextField T_IDText = (JTextField) view.getContentPane().getComponent(1);
        JTextField destinationText = (JTextField) view.getContentPane().getComponent(3);
        JTextField objectiveText = (JTextField) view.getContentPane().getComponent(5);

        T_IDText.setText("");
        destinationText.setText("");
        objectiveText.setText("");

        JButton saveBtn = (JButton) view.getContentPane().getComponent(7);
        saveBtn.doClick();

        // 验证是否弹出警告提示框
        assertEquals("请输入时间ID", JOptionPane.showInputDialog(null));
    }
}