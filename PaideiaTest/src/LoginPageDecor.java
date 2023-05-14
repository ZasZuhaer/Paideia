import java.awt.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*; 
//import java.awt.event.*;

public class LoginPageDecor{
    public LoginPageDecor(JFrame mainFrame, JButton goBack, LoginFunctions lgn){

        //removing homepage components 
        mainFrame.getContentPane().removeAll();
        
        //adding background image on loginpage
        try{
            BufferedImage lgnImage = ImageIO.read(getClass().getResource("Images/Loginpage.PNG"));
            mainFrame.setContentPane(new ImagePanel(lgnImage));
        }
        catch(Exception e){
            System.out.println(e);
        }

        //arranging loginpage components
        lgn.Username.setBounds       (350, 200, 100, 50);
        lgn.Email.setBounds          (340, 200, 100, 50);
        lgn.Password.setBounds       (340, 300, 100, 50);
        lgn.UsernameTF.setBounds     (440, 200, 150, 50);
        lgn.EmailTF.setBounds        (440, 200, 150, 50);
        lgn.PasswordPF.setBounds     (440, 300, 150, 50);       
        lgn.ForgotPasswordB.setBounds (370, 400, 200, 25);
        lgn.WithEmailB.setBounds      (370, 450, 200, 25);
        lgn.WithUsernameB.setBounds   (370, 450, 200, 25);
        lgn.Button.setBounds         (370, 500, 200, 25);
        lgn.sgnpButton.setBounds     (10, 100, 200, 25);
        
        lgn.Username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.Password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.UsernameTF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.PasswordPF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lgn.ForgotPasswordB.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        //adding loginpage components in mainFrame
        mainFrame.add(lgn.Username);
        mainFrame.add(lgn.Password);
        mainFrame.add(lgn.UsernameTF);
        mainFrame.add(lgn.PasswordPF);
        mainFrame.add(lgn.ForgotPasswordB);
        mainFrame.add(lgn.WithEmailB);
        mainFrame.add(lgn.Button);
        mainFrame.add(lgn.sgnpButton);
        //adding go back button in both loginpage and signuppage
        mainFrame.add(goBack);

        //refreshing and updating the mainFrame
        SwingUtilities.updateComponentTreeUI(mainFrame);

    }

}
