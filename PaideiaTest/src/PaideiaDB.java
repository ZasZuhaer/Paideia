//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!comments and instruction to be added!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!comments and instruction to be added!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!comments and instruction to be added!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!comments and instruction to be added!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!comments and instruction to be added!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

import java.sql.*;  
public class PaideiaDB implements IPaideiaDB{  
    Connection con;
    Statement stmt;
    ResultSet rs;
    String tableName;
    public PaideiaDB(String tableName){ //parameter added for dynamic use
        this.tableName = tableName; //for dynamic use
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/paideiadb","root","python98423727");              
            stmt=con.createStatement();  
        }
        catch(Exception e){
            System.out.println(e);
        }  
    }
    
    public void close(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public int adduser(String name, String email, String username, String password){
        String command = String.format("INSERT INTO accounts(name, email, username, password) VALUES('%s', '%s', '%s', '%s')", name, email, username, password);
        try{
            stmt.executeUpdate(command);
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            String exceptionMessage = e.getMessage();
            if(exceptionMessage.contains("username")){
                return 1;
            }
            else if(exceptionMessage.contains("email")){
                return 2;
            }
            else{
                return 3;
            }

        }
    }

    public void removeuser(String username){
        String command = String.format("DELETE FROM accounts WHERE username='%s'", username);
        try{
            stmt.executeUpdate(command);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void udpatepassword(String username, String newPassword){
        String command = String.format("UPDATE accounts SET password='%s' WHERE username='%s'", newPassword, username);
        try{
            stmt.executeUpdate(command);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void showtable(){
        String command = "SELECT * FROM accounts";
        try{
            rs=stmt.executeQuery(command);  
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));  
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}  