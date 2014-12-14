import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nastassia on 14.12.2014.
 */
public class LoginForm extends JFrame
{
    JTextField userName;
    JTextField userPassword;
    JButton okButton;
    LoginController loginController;


    public LoginForm() throws HeadlessException
    {
        super();

        this.setTitle("Login");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(3, 2));

        JLabel labelUser = new JLabel();
        labelUser.setText("Username");
        this.add(labelUser);
        userName = new JTextField();
        this.add(userName);
        JLabel labelPassword = new JLabel();
        labelPassword.setText("Password");
        this.add(labelPassword);
        userPassword = new JTextField();
        this.add(userPassword);
        JPanel spacePanel = new JPanel();
        this.add(spacePanel);
        loginController = new LoginController();
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loginController.doLogin(userName.getText(), userPassword.getText());
            }
        });
        this.add(okButton);
    }
}
