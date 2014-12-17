import javax.swing.*;

/**
 * Created by Viktoria on 17.12.2014.
 */
public class OrderController {
    OrderForm orderForm;
    Main mainController;

    OrderController(Main main) {
        mainController = main;
    }
    void showForm(){
        orderForm = new OrderForm();
        orderForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderForm.setVisible(true);
    }
}
