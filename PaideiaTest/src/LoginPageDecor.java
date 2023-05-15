import java.awt.*;
import java.awt.image.BufferedImage;
//import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*;
//import java.awt.event.*;

public class LoginPageDecor {
    public LoginPageDecor(JFrame mainFrame, JButton goBack, LoginFunctions lgn) {

        // removing homepage components
        mainFrame.getContentPane().removeAll();

        // adding background image on loginpage
        try {
            BufferedImage lgnImage = ImageIO.read(getClass().getResource("Images/Loginpage.PNG"));
            mainFrame.setContentPane(new ImagePanel(lgnImage));
        } catch (Exception e) {
            System.out.println(e);
        }

        // arranging loginpage components
        // lgn.Username.setBounds(100, 100, 40, 50);
        // lgn.Email.setBounds(140, 100, 100, 50);
        // lgn.Password.setBounds(140, 10, 100, 50);
        lgn.UsernameTF.setBounds(621, 290, 245, 30);
        lgn.EmailTF.setBounds(621, 300, 245, 30);
        lgn.PasswordPF.setBounds(621, 330, 245, 30);
        lgn.ForgotPasswordB.setBounds(670, 430, 150, 16);
        // lgn.WithEmailB.setBounds(370, 450, 200, 25);
        // lgn.WithUsernameB.setBounds(370, 450, 200, 25);
        lgn.Button.setBounds(670, 386, 150, 38);
        lgn.sgnpButton.setBounds(670, 452, 150, 16);
        goBack.setBounds(15, 24, 121, 33);

        lgn.Username.setFont(new Font("Poppins", Font.PLAIN, 20));
        lgn.Email.setFont(new Font("Poppins", Font.PLAIN, 20));
        lgn.Password.setFont(new Font("Poppins", Font.PLAIN, 20));
        lgn.UsernameTF.setFont(new Font("Poppins", Font.PLAIN, 20));
        lgn.PasswordPF.setFont(new Font("Poppins", Font.PLAIN, 20));
        lgn.ForgotPasswordB.setFont(new Font("Poppins", Font.PLAIN, 12));
        lgn.Button.setFont(new Font("Poppins", Font.PLAIN, 21));
        lgn.sgnpButton.setFont(new Font("Poppins", Font.PLAIN, 12));
        goBack.setFont(new Font("Poppins", Font.PLAIN, 16));

        // Setting Color
        lgn.Button.setBackground(new Color(55, 54, 116));
        lgn.Button.setForeground(Color.WHITE);
        lgn.Button.setBackground(new Color(55, 54, 116));
        lgn.Button.setForeground(Color.WHITE);
        goBack.setBackground(Color.WHITE);
        lgn.PasswordPF.setBackground(Color.WHITE);
        lgn.ForgotPasswordB.setBackground(Color.WHITE);
        lgn.sgnpButton.setBackground(Color.WHITE);

        // adding loginpage components in mainFrame
        mainFrame.add(lgn.Username);
        mainFrame.add(lgn.Password);
        mainFrame.add(lgn.UsernameTF);
        mainFrame.add(lgn.PasswordPF);
        mainFrame.add(lgn.ForgotPasswordB);
        mainFrame.add(lgn.WithEmailB);
        mainFrame.add(lgn.Button);
        mainFrame.add(lgn.sgnpButton);
        // adding go back button in both loginpage and signuppage
        mainFrame.add(goBack);

        // refreshing and updating the mainFrame
        SwingUtilities.updateComponentTreeUI(mainFrame);

    }

}
