//import java.sql.*;  

public interface IPaideiaDB {
    public void showtable();
    public int adduser(String name, String email, String username, String password);
    public void removeuser(String username);
    public void udpatepassword(String username, String newPassword);
}
