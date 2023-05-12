//this class contains all signuppage components (methods and attributes)

import java.util.regex.*; //regex patterns are defined in folder: learning files
import javax.swing.*; 
//import java.awt.event.*;

public class SignupFunctions implements ISignupFunctions{
    //signuppage components
    JLabel Name, Email, Username, Password, RtpPassword, DataVerificationMsg;
    JTextField NameTF, EmailTF, UsernameTF;
    JPasswordField PasswordPF, RtpPasswordPF;
    JButton Button;

    public SignupFunctions(){
        //creating objects for signuppage components
            //labels
        Name = new JLabel("Name: ");
        Email = new JLabel("Email: ");
        Username = new JLabel("Username: ");
        Password = new JLabel("Password: ");
        RtpPassword = new JLabel("Retype Password: ");
        DataVerificationMsg = new JLabel("", SwingConstants.CENTER);
            //textfields
        NameTF = new JTextField();
        EmailTF = new JTextField();
        UsernameTF = new JTextField();
        PasswordPF = new JPasswordField();
        RtpPasswordPF = new JPasswordField();
            //buttons
        Button = new JButton("Sign Up");
    }

    //checking if user entered password in password field
    public boolean checkingPasswordEntry(JFrame mainFrame, SignupFunctions sgnp){
       
        //storing the user typed password to a string object
        String password =  new String(sgnp.PasswordPF.getPassword());

        //checking if user didn't enter any password
        if(password.equals("")){ //empty password
            sgnp.DataVerificationMsg.setText("Please enter your password"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
        else{ //valid password
            return true;
        }
    }

    //checking if the user entered password in retype password field
    public boolean checkingRtpPasswordEntry(JFrame mainFrame, SignupFunctions sgnp){
       
        //storing the user typed password to a string object
        String rtpPassword = new String(sgnp.RtpPasswordPF.getPassword());

        //checking if user didn't enter any password
        if(rtpPassword.equals("")){ //empty retype password
            sgnp.DataVerificationMsg.setText("Please retype your password"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
        else{ //valid retype password
            return true;
        }
    }

    //checking if password and retyped password matches or not
    public boolean checkingPasswordMatch(JFrame mainFrame, SignupFunctions sgnp){
       
        //storing the user typed passwords to a string object
        String password =  new String(sgnp.PasswordPF.getPassword());
        String rtpPassword = new String(sgnp.RtpPasswordPF.getPassword());

        //checking equality
        if(password.equals(rtpPassword)){ //password matches
            sgnp.DataVerificationMsg.setText(""); //clearing the reports
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return true;
        }
        else{ //password doesn't match
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
            sgnp.DataVerificationMsg.setText("Passwords must be 8 digit long and contain at least an uppercase character, a lowercase character and a digit"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }

    }

    //checking if user entered a valid name
    public boolean checkingNameEntry(JFrame mainFrame, SignupFunctions sgnp){
        
        //storing the user entered name in a string object
        String name = new String(sgnp.NameTF.getText());

        //checking for empty name entry
        if(name.equals("")){ //empty name
            sgnp.DataVerificationMsg.setText("Please enter your name"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }

        //checking for valid name entry
        if(Pattern.matches("^(?=.*[a-zA-Z])[a-zA-Z\\.\s]*$", name)){ //valid name
            return true;
        }
        else{ //invalid name
            sgnp.DataVerificationMsg.setText("Please enter a valid name"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
        
    }

    //checking if user entered a valid email
    public boolean checkingEmailEntry(JFrame mainFrame, SignupFunctions sgnp){
        
        //storing the user entered email in a string object
        String email = new String(sgnp.EmailTF.getText());

        //checking for empty email entry
        if(email.equals("")){ //empty email
            sgnp.DataVerificationMsg.setText("Please enter your email"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }

        //checking for valid email entry
        //this regex requires more accuracy
        if(Pattern.matches("^(?=.*[a-z])(?=.*[\\.])(?=.*[@])[a-zA-Z0-9\\.@]*$", email)){ //valid email
            return true;
        }
        else{ //invalid email
            sgnp.DataVerificationMsg.setText("Please enter a valid email"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }
        
    }

    //checking if user entered a valid username
    public boolean checkingUsernameEntry(JFrame mainFrame, SignupFunctions sgnp){
        
        //storing the user entered username in a string object
        String username = new String(sgnp.UsernameTF.getText());

        //checking for empty username entry
        if(username.equals("")){ //empty username
            sgnp.DataVerificationMsg.setText("Please enter your username"); //reporting the user, designing
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
            return false;
        }

        else{ //valid username
            return true;
        }
    }

}
