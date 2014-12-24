/**
 * @author Viktoria
 * @version 1.0
 * @created 16-���-2014 23:28:21
 */
public class InventoryController {
	public InventoryForm inventoryForm;
	public PrinterAccessor printerAccessor;
	public InventoryList inventoryList;
    Main mainController;

    public InventoryController() {
        //mainController = main;
		inventoryList = DataAccessor.inventoryList;
        inventoryForm = new InventoryForm(this);
    }

	public void finalize() throws Throwable {
	}

	public void createDocumentForPrint(){
	}

	public void requestForCreate(){
        //catalog()
        inventoryForm.showForm();
	}

	public void requestForPrint(){

	}

	public boolean responseForPrint(){
		return false;
	}


	public boolean saveInventoryList(InventoryList invList){
        return DataAccessor.saveInventoryList(invList);
	}

}