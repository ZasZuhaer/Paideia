import java.util.*;

//importing sql package for java
import java.sql.*;  

public class PaideiaDB implements IPaideiaDB{  
    //creating object reference...
    Connection con; //for connecting to database
    Statement stmt; //for executing commands(all commands will be executed using stmt object)
    ResultSet rs; //for storing selected data from database to local memory
    String tableName; //for making the class usable for all tables inside database(dynamic use)
    
    public PaideiaDB(String tableName){ //parameter added for dynamic use
        this.tableName = tableName; //for dynamic use
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //connecting to DriverManager for managing the establishment of connections
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/paideiadb","root","javaproject2023"); //connecting to the database from local server
            stmt=con.createStatement(); //creating object for executing commands
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // connection closing method for outside termination
    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
    }

    // user adding method using sql command
    public int adduser(String name, String email, String username, String password, String usertype) { // requires
                                                                                                       // user's name,
                                                                                                       // email,
                                                                                                       // username and
                                                                                                       // password
        String command = String.format(
                "INSERT INTO %s(name, email, username, password, usertype) VALUES('%s', '%s', '%s', '%s', '%s')",
                tableName, name, email, username, password, usertype);
        try {
            stmt.executeUpdate(command); // executing commmand
            return 0;
        }

        // if command execution throws an error
        catch (Exception e) {
            System.out.println(e);

            // analyzing the exception
            // storing the exception message in a string object
            String exceptionMessage = e.getMessage();

            // if username already exists
            // checking the exception message for username duplication error
            if (exceptionMessage.contains("username")) {
                return 1;
            }

            // if email already exists
            // checking the exception message for email duplication error
            else if (exceptionMessage.contains("email")) {
                return 2;
            }

            // if some unknown exception occurs
            else {
                return 3;
            }

        }
    }

    // user removing method using sql command
    public void removeuser(String username) {
        String command = String.format("DELETE FROM %s WHERE username='%s'", tableName, username);
        try {
            stmt.executeUpdate(command); // executing commmand
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
    }

    // password updating method using sql command
    public void udpatepassword(String username, String newPassword) {
        String command = String.format("UPDATE %s SET password='%s' WHERE username='%s'", tableName, newPassword,
                username);
        try {
            stmt.executeUpdate(command); // executing commmand
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
    }

    // method for showing all data in accounts table
    public void showAccountsTable() {
        String command = "SELECT * FROM accounts";
        try {
            rs = stmt.executeQuery(command); // executing commmand
            while (rs.next()) {
                // calling methods with arguments to show table's data in a matrix format
                // currently the accounts table contains (5) columns
                // number of rows are variable and may change very frequently
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
                        + rs.getString(4) + "  " + rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
    }

    public String getPasswordFromDatabase(String username) {
        String command = String.format("SELECT password FROM accounts WHERE username='%s'", username);
        String password = "";
        try {
            rs = stmt.executeQuery(command); // executing commmand
            while (rs.next()) {
                password = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
        return password;
    }

    public void addCourse(String title, String category, String description, int price, String instructor) {
        String command = String.format(
                "INSERT INTO teacher_courses(title, category, description, price, instructor_name) VALUES('%s', '%s', '%s', '%s', '%s')",
                title, category, description, price, instructor);
        try {
            stmt.executeUpdate(command); // executing commmand
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
    }

    // method for showing all data in accounts table
    public void getAvailableCoursesTo(Vector<Course> available_courses){
        String command = "SELECT * FROM teacher_courses";
        try {
            rs = stmt.executeQuery(command); // executing commmand
            while (rs.next()) {
                Course course = new Course(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                available_courses.add(course);
            }
        } catch (Exception e) {
            System.out.println(e); // reporting if any exception is thrown
        }
    }

}