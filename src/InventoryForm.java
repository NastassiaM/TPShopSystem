import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 * Created by Viktoria on 16.12.2014.
 */
public class InventoryForm extends JFrame{
    private JList<String> catalogList;
    private JList<String> inventoryList;
    private JButton rightArrow;
    private JButton leftArrow;
    private JButton saveButton;
    private JButton printButton;
    private JButton editButton;
    private JPanel mainPanel;
    private InventoryController inventoryController;

    public InventoryForm(InventoryController inventoryCtrl) {
        setContentPane(mainPanel);

        inventoryController = inventoryCtrl;
        initListeners();
    }

    private void initListeners() {
        rightArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = (DefaultListModel<String>) inventoryList.getModel();
                model.addElement(catalogList.getSelectedValue());
                inventoryList.setSelectedIndex(model.size()-1);
            }
        });

        leftArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = (DefaultListModel<String>) catalogList.getModel();
                model.addElement(inventoryList.getSelectedValue());
                catalogList.setSelectedIndex(model.size()-1);
            }
        });
    }
}
