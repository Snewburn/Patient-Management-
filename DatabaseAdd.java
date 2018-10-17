
package fortmyergui;

import java.sql.*;

public class DatabaseAdd 
{
    public static void addPatientContact(String FN, String LN, String CP,String HP,
            String WP,String GN,String DOB,String EM,String A1,String A2,String CY,String ST,String ZP)
    {
        Connection con = connectToDB.getConnection();
        try
        {
            Statement stmt = con.createStatement();
            String insert = "INSERT INTO contact_info "
                          + "(firstName, lastName, phoneNumberCell, "
                          + "phoneNumberHome, phoneNumberWork, gender, "
                          + "dateOfBirth, email, addressLineOne," 
                          + "addressLineTwo, city, state, zip) "
                          + "VALUES ("
                          + "\"" + FN + "\", "
                          + "\"" + LN + "\", "
                          + "\"" + CP + "\", "
                          + "\"" + HP + "\", "
                          + "\"" + WP + "\", "
                          + "\"" + GN + "\", "
                          + "\"" + DOB + "\", "
                          + "\"" + EM + "\", "
                          + "\"" + A1 + "\", "
                          + "\"" + A2 + "\", "
                          + "\"" + CY + "\", "
                          + "\"" + ST + "\", "
                          + "\"" + ZP + "\")";
            System.out.println(insert);
            int i = stmt.executeUpdate(insert);
            if (i == 1)
            {
                System.out.println("Record Added");               
            }
            else
            {
                System.out.println("Record not added");
            }                          
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
    
}
