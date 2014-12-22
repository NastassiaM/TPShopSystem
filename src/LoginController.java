import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 14.12.2014.
 */
public class LoginController
{
    DataAccessor dataAccessor;
    InventoryController inventoryController;

    public LoginController()
    {
        dataAccessor = new DataAccessor();
        inventoryController = new InventoryController();
    }


    public void doLogin(String name, String password)
    {
        User user = new User(name, password);
        if (dataAccessor.checkUser(user))
        {
            switch (user.getPosition())
            {
                case CLERK:
                {
                    JOptionPane.showMessageDialog(null, "Clerk", "LoginController", JOptionPane.OK_OPTION);
                    break;
                }
                case SELLER:
                {
                    //JOptionPane.showMessageDialog(null, "Seller", "LoginController", JOptionPane.OK_OPTION);
                    OrdersForm ordersForm = new OrdersForm();
                    //ordersForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //ordersForm.setVisible(true);
                    break;
                }
                case MANAGER:
                {
                    //JOptionPane.showMessageDialog(null, "Manager", "LoginController", JOptionPane.OK_OPTION);
                    inventoryController.requestForCreate();
                    break;
                }
                default:
                {
                    JOptionPane.showMessageDialog(null, "Wrong position", "LoginController", JOptionPane.OK_OPTION);
                    break;
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Doesn't exist", "LoginController", JOptionPane.OK_OPTION);
        }
    }
}
