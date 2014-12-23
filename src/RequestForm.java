import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Viktoria on 22.12.2014.
 */
public class RequestForm extends JFrame{
    private RequestController requestController;
    private JTextField textField1;
    private JTextField textField2;
    private JButton saveButton;
    private JList<String> catalogList;
    private JPanel requestTab;
    private JButton rightArrow;
    private JButton leftArrow;
    private JTable goodsTable;
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JList requestsList;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel listOfRequestTab;
    private CatalogOfGoods catalogOfGoods;

    public RequestForm(RequestController requestCtrl) {
        setContentPane(mainPanel);
        catalogOfGoods = new CatalogOfGoods();
        initLists();

        requestController = requestCtrl;
        initListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setBounds(100, 50, 500, 650);
    }


    private void initLists() {
        catalogList.setModel(new DefaultListModel<String>());
        DefaultListModel<String> catalogListModel = (DefaultListModel<String>)(catalogList.getModel());

        requestsList.setModel(new DefaultListModel<String>());
        DefaultListModel<String> requestsListModel = (DefaultListModel<String>)(requestsList.getModel());
        for(Good good: catalogOfGoods){
            catalogListModel.addElement(good.getTitle());
        }
        catalogList.setSelectedIndex(0);
    }

    private void initListeners() {
        rightArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel) (goodsTable.getModel());
                boolean hasInInventList = false;
                int rowIndex = -1,
                        countOfGood = -1;
                for (int i = 0; i < modelInventoryTable.getRowCount(); i++) {
                    if (modelInventoryTable.getValueAt(i, 0).equals(catalogList.getSelectedValue())) {
                        hasInInventList = true;
                        rowIndex = i;
                        Object goodOfIL = modelInventoryTable.getValueAt(i, 1);
                        countOfGood = Integer.parseInt(goodOfIL.toString());
                    }
                }
                if (!hasInInventList)
                    modelInventoryTable.addRow(new String[]{catalogList.getSelectedValue(), "0"});
                else
                    modelInventoryTable.setValueAt(countOfGood + 1, rowIndex, 1);

                int i = modelInventoryTable.getRowCount() - 1;
                if (i >= 0)
                    goodsTable.setRowSelectionInterval(i, i);
            }
        });

        leftArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel) (goodsTable.getModel());
                int i = goodsTable.getSelectedRow();
                if (i >= 0){
                    modelInventoryTable.removeRow(i);
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestsList.getSelectedValue();
            }
        });
    }

    public void showForm(){
        setVisible(true);
    }

    public void createUIComponents(){
        String[][] emptyData = new String[0][2];
        goodsTable = new JTable(new DefaultTableModel(emptyData ,new String[]{"Column1", "Column2"}));
    }
}
