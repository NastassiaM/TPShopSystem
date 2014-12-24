import javax.swing.*;

/**
 * Created by NotePad on 14.12.2014.
 */
public class LoginController {
    DataAccessor dataAccessor;
    OrderController orderController;
    InventoryController inventoryController;
    DemandController demandController;

    LoginForm loginForm;

    public LoginController(){
        dataAccessor = new DataAccessor();
        orderController = new OrderController();
        inventoryController = new InventoryController();
        demandController = new DemandController();
    }

    public void doLogin(String name, String password){
        User user = new User(name, password);
        if (dataAccessor.checkUser(user)){
            switch (user.getPosition()) {
                case CLERK:
                    demandController.requestForCreate();
                    break;
                case SELLER:
                    orderController.requestForCreate();
                    break;
                case MANAGER:
                    inventoryController.requestForCreate();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong position", "LoginController", JOptionPane.OK_OPTION);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Doesn't exist", "LoginController", JOptionPane.OK_OPTION);
        }
        loginForm.dispose();
    }

    public void showForm() {
        loginForm = new LoginForm(this);
    }
}
