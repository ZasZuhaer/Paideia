//this class contains all loginpage components (methods and attributes)

import javax.swing.*; 
//import java.awt.event.*;

public class LoginFunctions {
    //loginpage components
    JLabel Title;
    JLabel Username, Email, Password;
    JTextField UsernameTF, EmailTF;
    JPasswordField PasswordPF;
    JButton ForgotPasswordB;
    JButton WithEmailB, WithUsernameB;
    JButton Button;

    public LoginFunctions(){}

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
