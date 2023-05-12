import javax.swing.*; 
import java.awt.image.BufferedImage;
//import java.io.File;
import javax.imageio.ImageIO;
//import java.awt.event.*;

public class SignupPageDecor {
    public SignupPageDecor(JFrame mainFrame, JButton goBack, SignupFunctions sgnp){
        //removing homepage components 
        mainFrame.getContentPane().removeAll();   
        
        //adding background image on signuppage
        try{
            BufferedImage sgnpImage = ImageIO.read(getClass().getResource("Signuppage.PNG"));
            mainFrame.setContentPane(new ImagePanel(sgnpImage));
        }
        catch(Exception e){
            System.out.println(e);
        }

        //arranging signuppage components
        sgnp.Name.setBounds                 (340, 150, 100, 50);
        sgnp.Email.setBounds                (340, 200, 100, 50);
        sgnp.Username.setBounds             (340, 250, 150, 50);
        sgnp.Password.setBounds             (340, 300, 150, 50); 
        sgnp.RtpPassword.setBounds          (340, 350, 150, 50);
        sgnp.NameTF.setBounds               (500, 160, 150, 25);
        sgnp.EmailTF.setBounds              (500, 210, 150, 25);
        sgnp.UsernameTF.setBounds           (500, 260, 150, 25);
        sgnp.PasswordPF.setBounds           (500, 310, 150, 25); 
        sgnp.RtpPasswordPF.setBounds        (500, 360, 150, 25);
        sgnp.DataVerificationMsg.setBounds  (200, 400, 800, 25);
        sgnp.Button.setBounds               (420, 500, 150, 25);


        //adding signuppage components in mainFrame
        mainFrame.add(sgnp.Name); 
        mainFrame.add(sgnp.Email); 
        mainFrame.add(sgnp.Username); 
        mainFrame.add(sgnp.Password);
        mainFrame.add(sgnp.RtpPassword);
        mainFrame.add(sgnp.NameTF);
        mainFrame.add(sgnp.EmailTF);
        mainFrame.add(sgnp.UsernameTF);
        mainFrame.add(sgnp.PasswordPF); 
        mainFrame.add(sgnp.RtpPasswordPF);
        mainFrame.add(sgnp.DataVerificationMsg);
        mainFrame.add(sgnp.Button);
        //adding go back button in both loginpage and signuppage
        mainFrame.add(goBack);

        //refreshing and updating the mainFrame
        SwingUtilities.updateComponentTreeUI(mainFrame);
    }
}
