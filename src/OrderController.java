/**
 * Created by NotePad on 22.12.2014.
 */
public class OrderController {
    public OrdersForm ordersForm;
    public DataAccessor dataAccessor;

    public OrderController() {
        //mainController = main;
        dataAccessor = new DataAccessor();
        ordersForm = new OrdersForm(this);
    }

    public void finalize() throws Throwable {

    }

    public void requestForCreate(){
        //catalog()
        ordersForm.showForm();
    }
}
