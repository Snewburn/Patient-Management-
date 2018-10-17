/*
getConnection() returns a connection object to the mysql database 
*/
package fortmyergui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectToDB 
{
    public static Connection getConnection()
    {
        //create con object to return
        Connection con = null;        
        try
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/patients?useSSL=false";
            String user = "Snewburn";
            String pw = "Jarenisr2d2";
            //pass conenction information to getConnection() in DriverManager class
            con = DriverManager.getConnection(url, user, pw);            
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return con;
    }
}
