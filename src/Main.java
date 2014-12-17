import javax.swing.*;

public class Main {
    InventoryController inventoryController;
    LoginController loginController;
    OrderController orderController;

    Main(){
        loginController = new LoginController(this);
        inventoryController = new InventoryController(this);
        orderController = new OrderController(this);

        loginController.showForm();
    }

    void loginResponse(Position position) {
        switch (position) {
            case CLERK: {
                JOptionPane.showMessageDialog(null, "Clerk", "LoginController", JOptionPane.OK_OPTION);
                orderController.showForm();
                break;
            }
            case SELLER: {
                JOptionPane.showMessageDialog(null, "Seller", "LoginController", JOptionPane.OK_OPTION);
                // here should be called controller
                break;
            }
            case MANAGER: {
                JOptionPane.showMessageDialog(null, "Manager", "LoginController", JOptionPane.OK_OPTION);
                inventoryController.showForm();
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "Wrong position", "LoginController", JOptionPane.OK_OPTION);
                break;
            }
        }
    }

    public static void main(String[] args){
        Main application = new Main();
    }
}