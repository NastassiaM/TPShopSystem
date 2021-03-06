import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 * Created by Viktoria on 16.12.2014.
 */
public class InventoryForm extends JFrame{
    private JList<String> catalogList;
    private JButton rightArrow;
    private JButton leftArrow;
    private JButton saveButton;
    private JButton printButton;
    private JButton editButton;
    private JPanel mainPanel;
    private JTable inventoryTable;
    private InventoryController inventoryController;

    public InventoryForm(InventoryController inventoryCtrl) {
        setContentPane(mainPanel);
        DataAccessor.catalogOfGoods = new CatalogOfGoods();
        initLists();

        inventoryController = inventoryCtrl;
        initListeners();

        initInventoryTable();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setBounds(100, 50, 500, 650);
    }

    private void initLists() {
        catalogList.setModel(new DefaultListModel<String>());
        DefaultListModel<String> catalogListModel = (DefaultListModel<String>)(catalogList.getModel());
        for(Good good: DataAccessor.catalogOfGoods){
            catalogListModel.addElement(good.getTitle());
        }
        catalogList.setSelectedIndex(0);
    }

    private void initInventoryTable(){
        DefaultTableModel modelInventoryTable = (DefaultTableModel)(inventoryTable.getModel());
        for (Good good:DataAccessor.inventoryList){
            modelInventoryTable.addRow(new String[]{good.getTitle(), String.valueOf(good.getCount()), String.valueOf(good.getPrice())});
        }
    }

    private void initListeners() {
        rightArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel)(inventoryTable.getModel());
                boolean hasInInventList = false;
                String nameOfGood = catalogList.getSelectedValue();
                int rowIndex = (modelInventoryTable.getRowCount() > 0? modelInventoryTable.getRowCount(): 0),
                    countOfGood = 0;
                for(int i = 0; i < modelInventoryTable.getRowCount(); i++){
                    if(modelInventoryTable.getValueAt(i,0).equals(nameOfGood)){
                        hasInInventList = true;
                        rowIndex = i;
                        Object goodOfIL = modelInventoryTable.getValueAt(i,1);
                        countOfGood = Integer.parseInt(goodOfIL.toString());
                    }
                }
                if(!hasInInventList) {
                    modelInventoryTable.addRow(new String[]{nameOfGood, "1"});
                }
                else {
                    modelInventoryTable.setValueAt(countOfGood + 1, rowIndex, 1);
                }

                modelInventoryTable.setValueAt(DataAccessor.catalogOfGoods.getGood(nameOfGood).getPrice()*(countOfGood+1), rowIndex, 2);

                int i = modelInventoryTable.getRowCount()-1;
                if(i >= 0)
                   inventoryTable.setRowSelectionInterval(i, i);
            }
        });

        leftArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel) (inventoryTable.getModel());
                int i = inventoryTable.getSelectedRow();
                if (i >= 0){
                    //modelInventoryTable.removeRow(i);
                    Object goodOfIL = modelInventoryTable.getValueAt(i,1);
                    int countOfGood = Integer.parseInt(goodOfIL.toString());
                    if (countOfGood == 1){
                        modelInventoryTable.removeRow(i);
                    }
                    else{
                        modelInventoryTable.setValueAt(--countOfGood, i, 1);
                    }
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryList list = new InventoryList();
                DefaultTableModel modelInventoryTable = (DefaultTableModel)(inventoryTable.getModel());
                for(int i = 0; i < modelInventoryTable.getRowCount(); i++){
                    String name = modelInventoryTable.getValueAt(i,0).toString();
                    int count = Integer.valueOf(modelInventoryTable.getValueAt(i, 1).toString());
                    double price = Double.valueOf(modelInventoryTable.getValueAt(i,2).toString());
                    list.add(new Good(name, count, price));
                }
                if(!inventoryController.saveInventoryList(list)){
                    JOptionPane.showMessageDialog(null, "Not save", "Error", JOptionPane.OK_OPTION);
                }else{
                    JOptionPane.showMessageDialog(null, "Save succeed", "Success save", JOptionPane.OK_OPTION);
                }
            }
        });
    }

    public void showForm(){
        setVisible(true);
    }

    public void createUIComponents(){
        String[][] emptyData = new String[0][3];
        inventoryTable = new JTable(new DefaultTableModel(emptyData ,new String[]{"Column1", "Column2", "Column3"}));
    }
}
