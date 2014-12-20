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
    CatalogOfGoods catalogOfGoods;
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
        catalogOfGoods = new CatalogOfGoods();
        initLists();

        inventoryController = inventoryCtrl;
        initListeners();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setBounds(100, 50, 500, 650);
    }

    private void initLists() {
        catalogList.setModel(new DefaultListModel<String>());
        DefaultListModel<String> catalogListModel = (DefaultListModel<String>)(catalogList.getModel());
        for(String good: catalogOfGoods){
            catalogListModel.addElement(good);
        }
    }

    private void initListeners() {
        rightArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel)(inventoryTable.getModel());
                DefaultListModel<String> modelCatalogList = (DefaultListModel<String>)(catalogList.getModel());
                modelInventoryTable.addRow(new String[]{catalogList.getSelectedValue(), "0"});
                int i = catalogList.getSelectedIndex();
                if(i >= 0)
                    modelCatalogList.removeElementAt(i);
                i = modelInventoryTable.getRowCount()-1;
                if(i >= 0)
                    inventoryTable.setRowSelectionInterval(i, i);
            }
        });

        leftArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel) (inventoryTable.getModel());
                DefaultListModel<String> modelCatalogList = (DefaultListModel<String>) (catalogList.getModel());
                int i = inventoryTable.getSelectedRow();
                modelCatalogList.addElement((String)modelInventoryTable.getValueAt(i, 0));
                if (i >= 0)
                    modelInventoryTable.removeRow(i);
                i = modelCatalogList.size() - 1;
                if (i >= 0)
                    catalogList.setSelectedIndex(i);
            }
        });
    }

    public void showForm(){
        setVisible(true);
    }

    public void createUIComponents(){
        String[][] emptyData = new String[0][2];
        inventoryTable = new JTable(new DefaultTableModel(emptyData ,new String[]{"Column1", "Column2"}));
    }
}
