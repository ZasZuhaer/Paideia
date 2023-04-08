import java.awt.*;
import javax.swing.*; 
//import java.awt.event.*;

public class LoginPageDecor{
    public LoginPageDecor(JFrame mainFrame, JButton lgnHButton, JButton sgnpHButton, JButton goBack, LoginFunctions lgn){

        //removing homepage components 
        mainFrame.remove(sgnpHButton);
        mainFrame.remove(lgnHButton);            

        //arranging loginpage components
        lgn.Title.setBounds          (400, 50, 400, 100);
        lgn.Username.setBounds       (340, 200, 100, 50);
        lgn.Email.setBounds          (340, 200, 100, 50);
        lgn.Password.setBounds       (340, 300, 100, 50);
        lgn.UsernameTF.setBounds     (440, 200, 150, 50);
        lgn.EmailTF.setBounds        (440, 200, 150, 50);
        lgn.PasswordPF.setBounds     (440, 300, 150, 50);        
        lgn.ForgotPasswordB.setBounds (370, 400, 200, 25);
        lgn.WithEmailB.setBounds      (370, 450, 200, 25);
        lgn.WithUsernameB.setBounds   (370, 450, 200, 25);
        lgn.Button.setBounds         (370, 500, 200, 25);
        
        
        lgn.Title.setFont(new Font("Times New Roman", Font.PLAIN, 65));
        lgn.Username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.Password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.UsernameTF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.PasswordPF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.ForgotPasswordB.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        //adding loginpage components in mainFrame
        mainFrame.add(lgn.Title);
        mainFrame.add(lgn.Username);
        mainFrame.add(lgn.Password);
        mainFrame.add(lgn.UsernameTF);
        mainFrame.add(lgn.PasswordPF);
        mainFrame.add(lgn.ForgotPasswordB);
        mainFrame.add(lgn.WithEmailB);
        mainFrame.add(lgn.Button);

        //refreshing and updating the mainFrame
        SwingUtilities.updateComponentTreeUI(mainFrame);

    }

}
