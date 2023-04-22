//importing sql package for java
import java.sql.*;  

public class PaideiaDB implements IPaideiaDB{  
    //creating object reference
    Connection con; //for connecting to database
    Statement stmt; //for executing commands(all commands will be executed using stmt object)
    ResultSet rs; //for storing selected data from database to local memory
    String tableName; //for making the class usable for all tables inside database(dynamic use)
    
    public PaideiaDB(String tableName){ //parameter added for dynamic use
        this.tableName = tableName; //for dynamic use
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //connecting to DriverManager for managing the establishment of connections
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/paideiadb","root","python98423727"); //connecting to the database from local server
            stmt=con.createStatement(); //creating object for executing commands
        }
        catch(Exception e){
            System.out.println(e); //reporting if any exception is thrown
        }  
    }
    
    //connection closing method for outside termination
    public void close(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println(e); //reporting if any exception is thrown
        }
    }
    
    //user adding method using sql command
    public int adduser(String name, String email, String username, String password){ //requires user's name, email, username and password
        String command = String.format("INSERT INTO accounts(name, email, username, password) VALUES('%s', '%s', '%s', '%s')", name, email, username, password);
        try{
            stmt.executeUpdate(command); //executing commmand
            return 0;
        }

        //if command execution throws an error
        catch(Exception e){ 
            System.out.println(e);

            //analyzing the exception
            //storing the exception message in a string object
            String exceptionMessage = e.getMessage();
            
            //if username already exists
            //checking the exception message for username duplication error
            if(exceptionMessage.contains("username")){
                return 1;
            }
            
            //if email already exists
            //checking the exception message for email duplication error
            else if(exceptionMessage.contains("email")){
                return 2;
            }
            
            //if some unknown exception occurs
            else{
                return 3;
            }

        }
    }

    //user removing method using sql command
    public void removeuser(String username){
        String command = String.format("DELETE FROM accounts WHERE username='%s'", username);
        try{
            stmt.executeUpdate(command); //executing commmand
        }
        catch(Exception e){
            System.out.println(e); //reporting if any exception is thrown
        }
    }

    //password updating method using sql command
    public void udpatepassword(String username, String newPassword){
        String command = String.format("UPDATE accounts SET password='%s' WHERE username='%s'", newPassword, username);
        try{
            stmt.executeUpdate(command); //executing commmand
        }
        catch(Exception e){
            System.out.println(e); //reporting if any exception is thrown
        }
    }

    //method for showing all data in accounts table
    public void showtable(){
        String command = "SELECT * FROM accounts";
        try{
            rs=stmt.executeQuery(command); //executing commmand 
            while(rs.next()){
                //calling methods with arguments to show table's data in a matrix format
                //currently the accounts table contains (5) columns
                //number of rows are variable and may change very frequently
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
            }
        }
        catch(Exception e){
            System.out.println(e); //reporting if any exception is thrown
        }
    }

}  