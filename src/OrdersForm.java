import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 17.12.2014.
 */
public class OrdersForm extends JFrame {
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JButton buttonCreateOrder;
    private JTable table2;
    private JButton buttonEditOrder;
    private JButton exitButton;
    private JPanel Test;
    private JPanel qwe;

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrdersForm");
        frame.setContentPane(new OrdersForm().Test);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
