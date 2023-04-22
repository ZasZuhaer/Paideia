//import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

/* 
 * keywords to search for homepage items:           "homepage components"
 * keywords to search for login page items:         "loginpage components"
 * keywords to search for signup page items:        "signuppage components"
 * other keywords to emphasize for the UI designer: "design" , "designing" , "Decor" , "arranging"
 * 
 * loginpage components, variable names starting with keyword "lgn."
 * signuppage components, variable names starting with keyword "sgnp."
 * 
 * methods comments are written in continuous tense
*/

public class HomePage implements ActionListener{

    //creating object references for loginpage and signuppage
    LoginFunctions lgn;
    SignupFunctions sgnp;

    //homepage components
    JFrame mainFrame;  //mainFrame refers to homepage
    JButton lgnHButton, sgnpHButton; //already have an account? or create an account?
    
    //go back button
    JButton goBack;

    //connecting database
    PaideiaDB accounts_tb = new PaideiaDB("accounts");

    public HomePage(){
        //creating homepage components objects
        mainFrame = new JFrame("Paideia | Login or Signup");   
        lgnHButton = new JButton("Login");
        sgnpHButton = new JButton("Signup");
        goBack = new JButton("Go Back"); //preconfiguring go back

        //creating objects for loginpage and signuppage
        lgn = new LoginFunctions();
        sgnp = new SignupFunctions();

        //designing homepage components
        lgnHButton.setBounds(150,250,200,50);
        sgnpHButton.setBounds(650,250,200,50);
        goBack.setBounds(10,10,100,25); //preconfiguring go back

        //adding actions to homepage components
        lgnHButton.addActionListener(this);
        sgnpHButton.addActionListener(this);
        goBack.addActionListener(this); //preconfiguring go back

        //adding homepage components in mainFrame
        mainFrame.add(lgnHButton);
        mainFrame.add(sgnpHButton);

        //homepage default configurations
        mainFrame.setSize(1000, 600);  
		mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);  
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //performing manual close operation on mainFrame
        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                accounts_tb.close(); //closing database connection
                System.exit(0); //closing mainFrame
            }
        });
        mainFrame.setVisible(true);  
    }  

    public void actionPerformed(ActionEvent e){
        //adding go back button in both loginpage and signuppage
        mainFrame.add(goBack);

        //IF LOGIN BUTTON IS PRESSED...
        if(e.getSource()==lgnHButton){

            //designing loginpage components
            new LoginPageDecor(mainFrame, lgnHButton, sgnpHButton, goBack, lgn);
        
            //adding actions to loginpage components
            lgn.WithEmailB.addActionListener(this);
            lgn.WithUsernameB.addActionListener(this);
            lgn.ForgotPasswordB.addActionListener(this);
            lgn.Button.addActionListener(this);
        }
        

        //IF SIGNUP BUTTON IS PRESSED...
        else if(e.getSource()==sgnpHButton){

            //designing signuppage components
            new SignupPageDecor(mainFrame, lgnHButton, sgnpHButton, goBack, sgnp);

            //adding actions to signuppage components
            sgnp.Button.addActionListener(this);

        }

        //IF LOGIN WITH EMAIL IS PRESSED...
        if(e.getSource()==lgn.WithEmailB){
            //switch buttons, labels textfields and passwordfields
            //goes to LoginFunctions class
            lgn.loginWithEmail(mainFrame, lgn);
        }

        //IF LOGIN WITH USERNAME IS PRESSED...
        if(e.getSource()==lgn.WithUsernameB){
            //switch buttons, labels textfields and passwordfields
            //goes to LoginFunctions class
            lgn.loginwithUsername(mainFrame, lgn);
        }

        //IF GO BACK IS PRESSED...
        if(e.getSource()==goBack){
            mainFrame.getContentPane().removeAll(); //removing all mainframe components
            mainFrame.add(lgnHButton); //adding homepage component, login
            mainFrame.add(sgnpHButton); //adding homepage component, signup
            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
        }



        //IF CREATING AN ACCOUNT AND SIGNUP BUTTON IS PRESSED...
        if(e.getSource()==sgnp.Button){
            //here all the methods belongs to SignupFunctions class's object sgnp
            //reporting methods might require a complete re-design of UI, designing

            //if user entered a valid name...
            if(sgnp.checkingNameEntry(mainFrame, sgnp)){
                System.out.println("good name"); //for debugging
            
                //if user entered a valid email...
                if(sgnp.checkingEmailEntry(mainFrame, sgnp)){
                    System.out.println("good email"); //for debugging
                
                    //if user entered a username...
                    if(sgnp.checkingUsernameEntry(mainFrame, sgnp)){
                        System.out.println("good username"); //for debugging
                    
                        //if user entered password...
                        if(sgnp.checkingPasswordEntry(mainFrame, sgnp)){
                            
                            //if password strength is strong...
                            if(sgnp.checkingPasswordStrength(mainFrame, sgnp)){

                                //if user retyped the password...
                                if(sgnp.checkingRtpPasswordEntry(mainFrame, sgnp)){

                                    //then check if they match...
                                    if(sgnp.checkingPasswordMatch(mainFrame, sgnp)){

                                        System.out.println("good password"); //for debugging
                                        //adding user in database
                                        String name = new String(sgnp.NameTF.getText());
                                        String email = new String(sgnp.EmailTF.getText());
                                        String username = new String(sgnp.UsernameTF.getText());
                                        String password = new String(sgnp.PasswordPF.getPassword());
                                        int errors = accounts_tb.adduser(name, email, username, password);

                                        //Reporting signup results
                                        if(errors==0){
                                            //successful signup
                                            sgnp.DataVerificationMsg.setText("Signup successful");
                                            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
                                        }
                                        else if(errors==1){
                                            //username already in database
                                            sgnp.DataVerificationMsg.setText("Username already exists");
                                            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
                                        }
                                        else if(errors==2){
                                            //email already in database
                                            sgnp.DataVerificationMsg.setText("Email already exists");
                                            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
                                        }
                                        else{
                                            //unknown error during adding user in database
                                            sgnp.DataVerificationMsg.setText("Unknown error occured during adding user in database");
                                            SwingUtilities.updateComponentTreeUI(mainFrame); //refreshing mainframe
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }//signup data verification ends here
    } //actionPerformed ends here
}  //homepage class ends here
