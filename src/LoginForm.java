import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nastassia on 14.12.2014.
 */
public class LoginForm extends JFrame{
    JTextField userName;
    JTextField userPassword;
    JButton okButton;
    LoginController loginController;


    public LoginForm(LoginController loginCtrl) throws HeadlessException{
        super();

        this.setTitle("Login");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        loginController = loginCtrl;

        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3, 1));

        JLabel labelUser = new JLabel();
        labelUser.setText("Username:");
        labelUser.setHorizontalAlignment(JLabel.CENTER);
        labelUser.setVerticalAlignment(JLabel.TOP);
        JPanel userNamePanel = new JPanel();
        userName = new JTextField(20);
        userNamePanel.add(labelUser);
        userNamePanel.add(userName);
        c.add(userNamePanel);

        JLabel labelPassword = new JLabel();
        labelPassword.setText("Password:");
        labelPassword.setHorizontalAlignment(JLabel.CENTER);
        labelPassword.setVerticalAlignment(JLabel.TOP);
        JPanel userPasswordPanel = new JPanel();
        userPassword = new JTextField(20);
        userPasswordPanel.add(labelPassword);
        userPasswordPanel.add(userPassword);
        c.add(userPasswordPanel);

        JPanel okButtonPanel = new JPanel();
        okButton = new JButton("Log In");
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loginController.doLogin(userName.getText(), userPassword.getText());
            }
        });
        okButtonPanel.add(okButton);
        c.add(okButtonPanel);
    }
}
