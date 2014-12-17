import javax.swing.*;

/**
 * @author Viktoria
 * @version 1.0
 * @created 16-���-2014 23:28:21
 */
public class InventoryController {

	public InventoryForm inventoryForm;
	public PrinterAccessor printerAccessor;
	public DatabaseOfGoods databaseOfGoods;
	public InventoryList inventoryList;
    Main mainController;

    public InventoryController(Main main) {
        mainController = main;
    }

    public void showForm(){
        inventoryForm = new InventoryForm(this);
        inventoryForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryForm.setVisible(true);
        inventoryForm.pack();
    }

	public void finalize() throws Throwable {

	}

	public void createDocumentForPrint(){

	}

	public void requestForCreate(){

	}

	public void requestForPrint(){

	}

	public boolean responseForPrint(){
		return false;
	}

	public boolean responseForSave(){
		return false;
	}

	public void saveInventoryList(){

	}

}