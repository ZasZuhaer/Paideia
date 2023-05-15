//import java.sql.*;  

public interface IPaideiaDB {
    public void showAccountsTable();
    public int adduser(String name, String email, String username, String password, String usertype);
    public void removeuser(String username);
    public void udpatepassword(String username, String newPassword);
}
