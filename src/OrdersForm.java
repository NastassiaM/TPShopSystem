import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by NotePad on 17.12.2014.
 */
public class OrdersForm extends JFrame {
    private JTabbedPane tabbedPane1;
    private JTable tableDemands;
    private JButton buttonCreateOrder;
    private JTable table2;
    private JButton buttonEditOrder;
    private JPanel Test;
    private JPanel qwe;

    OrderController orderController;

   /* public static void main(String[] args) {
        JFrame frame = new JFrame("OrdersForm");
        frame.setContentPane(new OrdersForm().Test);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
   public OrdersForm(OrderController orderControl) {
       setContentPane(tabbedPane1);

       orderController = orderControl;

       initLists();

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();
       setBounds(100, 50, 500, 650);
   }

    public void showForm(){
        setVisible(true);
    }

    public void initLists(){
        //tableDemands.setModel(new DefaultTableModel());
        DefaultTableModel demandTableModel = (DefaultTableModel)(tableDemands.getModel());
        for(Demand demand:DataAccessor.demandList){
            demandTableModel.addRow(new String[]{demand.getId(), String.valueOf(demand.isAvailable)});
        }
    }

    private void createUIComponents() {
        String[][] emptyData = new String[0][3];
        tableDemands = new JTable(new DefaultTableModel(emptyData ,new String[]{"Column1", "Column2"}));
    }
}
