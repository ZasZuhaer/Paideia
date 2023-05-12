//this class contains all loginpage components (methods and attributes)

import javax.swing.*; 
//import java.awt.event.*;

public class LoginFunctions implements ILoginFunctions{
    //loginpage components
    JLabel Username, Email, Password;
    JTextField UsernameTF, EmailTF;
    JPasswordField PasswordPF;
    JButton ForgotPasswordB;
    JButton WithEmailB, WithUsernameB;
    JButton Button, sgnpButton;

    public LoginFunctions(){
        //creating objects for loginpage components
            //labels
        Username = new JLabel("Username: ");
        Email = new JLabel("Email: ");
        Password = new JLabel("Password: ");
            //textfields
        UsernameTF = new JTextField();
        EmailTF = new JTextField();
        PasswordPF = new JPasswordField();
            //buttons
        ForgotPasswordB = new JButton("Forgot Password?");
        WithEmailB = new JButton("Login with email");
        WithUsernameB = new JButton("Login with Username");
        Button = new JButton("Login");
        sgnpButton = new JButton("Don't have an account?");
    }

    public void loginWithEmail(JFrame mainFrame, LoginFunctions lgn){
        //designing
        /*changing the source button
        *removing username label and textfield
        *addming email label and textfield
        */
        mainFrame.remove(lgn.WithEmailB);
        mainFrame.add(lgn.WithUsernameB);
        mainFrame.remove(lgn.Username);
        mainFrame.remove(lgn.UsernameTF);
        mainFrame.add(lgn.Email);
        mainFrame.add(lgn.EmailTF);
        
        //refreshing mainframe
        SwingUtilities.updateComponentTreeUI(mainFrame);
    }

    public void loginwithUsername(JFrame mainFrame, LoginFunctions lgn){
        //designing
        /*changing the source button
        *removing email label and textfield
        *adding username label and textfield
        */
        mainFrame.add(lgn.WithEmailB);
        mainFrame.remove(lgn.WithUsernameB);
        mainFrame.remove(lgn.Email);
        mainFrame.remove(lgn.EmailTF);
        mainFrame.add(lgn.Username);
        mainFrame.add(lgn.UsernameTF);

        //refreshing mainframe
        SwingUtilities.updateComponentTreeUI(mainFrame);
    }
}
