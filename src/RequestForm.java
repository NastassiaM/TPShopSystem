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
    private JPanel mainPanel;
    private JButton rightArrow;
    private JButton leftArrow;
    private JTable goodsTable;
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
        for(String good: catalogOfGoods){
            catalogListModel.addElement(good);
        }
    }

    private void initListeners() {
        rightArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel)(goodsTable.getModel());
                DefaultListModel<String> modelCatalogList = (DefaultListModel<String>)(catalogList.getModel());
                modelInventoryTable.addRow(new String[]{catalogList.getSelectedValue(), "0"});
                int i = catalogList.getSelectedIndex();
                if(i >= 0)
                    modelCatalogList.removeElementAt(i);
                i = modelInventoryTable.getRowCount()-1;
                if(i >= 0)
                    goodsTable.setRowSelectionInterval(i, i);
            }
        });

        leftArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelInventoryTable = (DefaultTableModel) (goodsTable.getModel());
                DefaultListModel<String> modelCatalogList = (DefaultListModel<String>) (catalogList.getModel());
                int i = goodsTable.getSelectedRow();

                if (i >= 0) {
                    modelCatalogList.addElement((String) modelInventoryTable.getValueAt(i, 0));
                    modelInventoryTable.removeRow(i);
                }
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
        goodsTable = new JTable(new DefaultTableModel(emptyData ,new String[]{"Column1", "Column2"}));
    }
}
