import javax.swing.*; 

public interface ISignupFunctions {
    public boolean checkingPasswordEntry(JFrame mainFrame, SignupFunctions sgnp);
    public boolean checkingRtpPasswordEntry(JFrame mainFrame, SignupFunctions sgnp);
    public boolean checkingPasswordMatch(JFrame mainFrame, SignupFunctions sgnp);
    public boolean checkingPasswordStrength(JFrame mainFrame, SignupFunctions sgnp);
    public boolean checkingNameEntry(JFrame mainFrame, SignupFunctions sgnp);
    public boolean checkingEmailEntry(JFrame mainFrame, SignupFunctions sgnp);
    public boolean checkingUsernameEntry(JFrame mainFrame, SignupFunctions sgnp);

}
