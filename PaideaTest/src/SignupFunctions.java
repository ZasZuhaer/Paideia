//this class contains all signuppage components (methods and attributes)

import java.util.regex.*;
import javax.swing.*; 
//import java.awt.event.*;

public class SignupFunctions {
    //signuppage components
    JLabel Title;
    JLabel Name, Email, Username, Password, RtpPassword, DataVerificationMsg;
    JTextField NameTF, EmailTF, UsernameTF;
    JPasswordField PasswordPF, RtpPasswordPF;
    JButton Button;

    public SignupFunctions(){}

    //checking if user entered password in password field
    public boolean checkingPasswordEntry(JFrame mainFrame, SignupFunctions sgnp){
       
        //storing the user typed password to a string object
        String password =  new String(sgnp.PasswordPF.getPassword());

        //checking if user didn't enter any password
        if(password.equals("")){
            sgnp.DataVerificationMsg.setText("Please enter your password"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
        else{
            return true;
        }
    }

    //checking if the user entered password in retype password field
    public boolean checkingRtpPasswordEntry(JFrame mainFrame, SignupFunctions sgnp){
       
        //storing the user typed password to a string object
        String rtpPassword = new String(sgnp.RtpPasswordPF.getPassword());

        //checking if user didn't enter any password
        if(rtpPassword.equals("")){
            sgnp.DataVerificationMsg.setText("Please retype your password"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
        else{
            return true;
        }
    }

    //checking if password and retyped password matches or not
    public boolean checkingPasswordMatch(JFrame mainFrame, SignupFunctions sgnp){
       
        //storing the user typed passwords to a string object
        String password =  new String(sgnp.PasswordPF.getPassword());
        String rtpPassword = new String(sgnp.RtpPasswordPF.getPassword());

        //checking equality
        if(password.equals(rtpPassword)){
            sgnp.DataVerificationMsg.setText(""); //clearing the reports
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return true;
        }
        else{
            sgnp.DataVerificationMsg.setText("Passwords do not match"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
    }

    //checking if the entered password is strong
    public boolean checkingPasswordStrength(JFrame mainFrame, SignupFunctions sgnp){

        //storing the user typed password to a string object
        String password =  new String(sgnp.PasswordPF.getPassword());

        //*****checking strength*****//
        //condition 1: minimum 8 characters
        boolean minEightChars = (password.length() >= 8);
        //condition 2: must contain a number
        boolean containsNumber = Pattern.matches(".*\\d.*", password);
        //condition 3: must contain a uppercase character
        boolean containsUppercase = Pattern.matches(".*[A-Z].*", password);
        //condition 4: must contain a lowercase character
        boolean containsLowercase = Pattern.matches(".*[a-z].*", password);


        //checking all conditions together
        if(minEightChars && containsNumber && containsUppercase && containsLowercase){
            return true;
        }
        else{
            sgnp.DataVerificationMsg.setText("Passwords must contain at least an uppercase character, a lowercase character and a digit"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }

    }
}
