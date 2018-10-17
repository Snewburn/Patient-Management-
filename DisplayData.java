/*
This class contains the methods for displaying data from the database
methods return strings
*/

package fortmyergui;

import java.sql.*;


public class DisplayData 
{
    public static String displayAllPatientContactInformation()
    {
        //String to be returned
        String allPatContact = new String("All Pateinets: \n");
        
        //Create a ResultSet object from method getPatients()
        ResultSet patients = getPatients();
        
        try
        {
            //grabe this information from the record and build the allPatContact
            //string. 
            while(patients.next())
            {                
                Person p = getPatient(patients);
                allPatContact += String.valueOf(p.id);
                allPatContact += ":: " + p.lastName;
                allPatContact += ", " + p.firstName + ";";
                allPatContact += " " + p.phoneNumberCell + "; ";
                allPatContact += " " + p.phoneNumberHome + "; ";                                      
                allPatContact += " " + p.phoneNumberWork + "; ";
                allPatContact += " " + p.gender + "; ";
                allPatContact += " " + p.dateOfBirth + "; ";
                allPatContact += " " + p.email + "; ";
                allPatContact += " " + p.addressLineOne + "; ";
                allPatContact += " " + p.city + "; ";
                allPatContact += " " + p.state + "; ";
                allPatContact += " " + p.zip + "; ";
                allPatContact += "\n";
            }            
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return allPatContact;
    }
    
    private static ResultSet getPatients()
    {   
        //Create a Connection object con to connect with database
        Connection con = connectToDB.getConnection();
        
        try
        {   
            //use con object to create a Statement and assign to s
            Statement s = con.createStatement();
            //build SQL commands
            String select = "select id, firstName, lastName, phoneNumberCell, "
                        + "phoneNumberHome, phoneNumberWork, gender, "
                        + "dateOfBirth, email, addressLineOne," 
                        + "addressLineTwo, city, state, zip "
                        + "from contact_info order by id";
            ResultSet rows;            
            rows = s.executeQuery(select);            
            return rows;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }        
        
        return null;
        
    }
    
     private static Person getPatient(ResultSet patients)
    {
        try
        {
            int ID = patients.getInt("id");
            String FN = patients.getString("firstName");
            String LN = patients.getString("lastName");
            String PC = patients.getString("phoneNumberCell");
            String PH = patients.getString("phoneNumberHome");
            String PW = patients.getString("phoneNumberWork");
            String GN = patients.getString("gender");
            String DB = patients.getString("dateOfBirth");
            String EM = patients.getString("email");
            String A1 = patients.getString("addressLineOne");
            String A2 = patients.getString("addressLineTwo");
            String CY = patients.getString("city");
            String ST = patients.getString("state");
            String ZP = patients.getString("zip");
            
            return new Person(ID, FN, LN, PC, PH, PW, GN, DB, EM, A1, A2, CY, 
                              ST, ZP);            
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;                        
    }
    
     
    private static class Person
    {
        public int id;
        public String firstName;
        public String lastName;
        public String phoneNumberCell;
        public String phoneNumberHome; 
        public String phoneNumberWork;
        public String gender;
        public String dateOfBirth;
        public String email;
        public String addressLineOne;
        public String addressLineTwo; 
        public String city;
        public String state;
        public String zip;
        
        public Person (int id, 
                       String firstName, 
                       String lastName, 
                       String phoneNumberCell, 
                       String phoneNumberHome, 
                       String phoneNumberWork,
                       String gender, 
                       String dateOfBirth, 
                       String email, 
                       String addressLineOne, 
                       String addressLineTwo, 
                       String city, 
                       String state, 
                       String zip)
        {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumberCell = phoneNumberCell;
            this.phoneNumberHome = phoneNumberHome;
            this.phoneNumberWork = phoneNumberWork;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.email = email;
            this.addressLineOne = addressLineOne;
            this.addressLineTwo = addressLineTwo;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }
    }
}
