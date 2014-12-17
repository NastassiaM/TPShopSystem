import javax.swing.*;

/**
 * Created by NotePad on 14.12.2014.
 */
public class LoginController{
    DataAccessor dataAccessor;
    Main mainController;
    LoginForm loginForm;

    public LoginController(Main main){
        mainController = main;
        dataAccessor = new DataAccessor();
    }

    public void showForm(){
        loginForm = new LoginForm(this);
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);
    }

    public void doLogin(String name, String password){
        User user = new User(name, password);
        if (dataAccessor.checkUser(user)){
            mainController.loginResponse(user.getPosition());
        }
        else{
            JOptionPane.showMessageDialog(null, "Doesn't exist", "LoginController", JOptionPane.OK_OPTION);
        }
    }
}
