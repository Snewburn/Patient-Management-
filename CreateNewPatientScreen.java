/*
Spencer Newburn 08-28-2018
CreateNewPatienScreen class contains the controls for the New Patient contact 
information. 
CreateNewPatientScene method returns a scene object for use in stage. 
*/
package fortmyergui;

import java.time.format.DateTimeFormatter;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;


public class CreateNewPatientScreen 
{
    //Create controls    
    static ChoiceBox<String> chbState;

    static RadioButton rdbMale, rdbFemale;
    static String selectedGender;

    static TextField txtFirstName, txtLastName; 
    static TextField txtEmail;
    static TextField txtAddress1, txtAddress2, txtCity, txtZip;
    static TextField txtCellPhone, txtHomePhone, txtWorkPhone;

    static DatePicker dprDOB;

    static Button btnSubmit;
    
    static Label lblFirstNameValidation, lblLastNameValidation,
                 lblCellPhoneValidation, lblHomePhoneValidation, lblWorkPhoneValidation,
                 lblEmailValidation, lblAddressValidation, lblCityStateZipValidation, 
                 lblGenderValidation, lblDOBvalidation;
    
    public static Scene CreateNewPatientScene()
    {
        //CONTROLS
        //First Name 
        Label lblFirstName = new Label("First Name:");
        lblFirstName.setMinWidth(100);
        lblFirstName.setAlignment(Pos.BOTTOM_RIGHT);
        
        lblFirstNameValidation = new Label("required");
        
        txtFirstName = new TextField();
        txtFirstName.setMinWidth(200);
        txtFirstName.setMaxWidth(200);
        txtFirstName.setOnKeyReleased(e -> NameValid(txtFirstName, lblFirstNameValidation));

        //Last Name
        Label lblLastName = new Label("Last Name:");
        lblLastName.setMinWidth(100);
        lblLastName.setAlignment(Pos.BOTTOM_RIGHT);
        
        lblLastNameValidation = new Label("required");
        
        txtLastName = new TextField();
        txtLastName.setMinWidth(200);
        txtLastName.setMaxWidth(200);
        txtLastName.setOnKeyReleased(e -> NameValid(txtLastName, lblLastNameValidation));

        //Phone Numbers
        //NEEDS to skip through 
        //  Cell
        Label lblCellPhone = new Label("Cell:");
        lblCellPhone.setMinWidth(100);
        lblCellPhone.setAlignment(Pos.BOTTOM_RIGHT);

        lblCellPhoneValidation = new Label("xxx-xxx-xxxx format");

        txtCellPhone = new TextField();
        txtCellPhone.setPrefColumnCount(15); 
        txtCellPhone.setOnKeyReleased(e -> PhoneNumValid(txtCellPhone, lblCellPhoneValidation));

        //  Home
        Label lblHomePhone = new Label("Home:");
        lblHomePhone.setMinWidth(100);
        lblHomePhone.setAlignment(Pos.BOTTOM_RIGHT);

        lblHomePhoneValidation = new Label("xxx-xxx-xxxx format");
        
        txtHomePhone = new TextField();
        txtHomePhone.setPrefColumnCount(15);
        txtHomePhone.setOnKeyReleased(e -> PhoneNumValid(txtHomePhone, lblHomePhoneValidation));
        
        //  Work
        Label lblWorkPhone = new Label("Work:");
        lblWorkPhone.setMinWidth(100);
        lblWorkPhone.setAlignment(Pos.BOTTOM_RIGHT);

        lblWorkPhoneValidation = new Label("xxx-xxx-xxxx format");
        
        txtWorkPhone = new TextField();
        txtWorkPhone.setPrefColumnCount(15);
        txtWorkPhone.setOnKeyReleased(e -> PhoneNumValid(txtWorkPhone, lblWorkPhoneValidation));
        
        //  Gender
        Label lblGender = new Label("Select Gender:");
        lblGender.setMinWidth(100);
        lblGender.setAlignment(Pos.BOTTOM_RIGHT);

        rdbMale = new RadioButton("Male");
        rdbFemale = new RadioButton("Female");

        ToggleGroup tgGender = new ToggleGroup();
        rdbMale.setToggleGroup(tgGender);
        rdbFemale.setToggleGroup(tgGender);
        
        rdbMale.setOnAction(e -> GenderValidMale(lblGenderValidation));
        rdbFemale.setOnAction(e -> GenderValidMale(lblGenderValidation));
        
        lblGenderValidation = new Label("required");

        //  Date of Birth
        Label lblDOB = new Label("Date of Birth:");
        lblDOB.setMinWidth(100);
        lblDOB.setAlignment(Pos.BOTTOM_RIGHT);
        
        lblDOBvalidation = new Label("MUST BE mm/dd/yyyy");
        
        dprDOB = new DatePicker();
        
        dprDOB.setOnAction(e -> DOBValid(dprDOB, lblDOBvalidation));
        
        //  Email
        Label lblEmail = new Label("Email:");
        lblEmail.setMinWidth(100);
        lblEmail.setMaxWidth(100);
        lblEmail.setAlignment(Pos.BOTTOM_RIGHT);
        
        lblEmailValidation = new Label("required");

        txtEmail = new TextField();
        txtEmail.setMinWidth(200);
        txtEmail.setMaxWidth(200);
        txtEmail.setOnKeyReleased(e -> EmailValid(txtEmail, lblEmailValidation));
        
        
        //  Address
        Label lblAddress1 = new Label("Address:");
        lblAddress1.setMinWidth(100);
        lblAddress1.setAlignment(Pos.TOP_RIGHT);

        Label lblCity = new Label("City:");
        lblCity.setMinWidth(20);
        lblCity.setAlignment(Pos.BOTTOM_RIGHT); 

        Label lblState = new Label("State:");
        lblState.setMinWidth(20);
        lblState.setAlignment(Pos.BOTTOM_RIGHT);

        Label lblZip = new Label("Zip:");
        lblZip.setMinWidth(20);
        lblZip.setAlignment(Pos.BOTTOM_RIGHT);
        
        lblAddressValidation = new Label("required");
        lblAddressValidation.setPrefWidth(100);

        txtAddress1 = new TextField();
        txtAddress1.setMinWidth(300);
        txtAddress1.setMaxWidth(300); 
        txtAddress1.setOnKeyReleased(e -> AddressValid(txtAddress1, txtAddress2, lblAddressValidation));

        txtAddress2 = new TextField();
        txtAddress2.setMinWidth(300);
        txtAddress2.setMaxWidth(300);
        txtAddress2.setOnKeyReleased(e -> AddressValid(txtAddress1, txtAddress2, lblAddressValidation));
        
        lblCityStateZipValidation = new Label("required");
        
        txtCity = new TextField(); 
        txtCity.setMinWidth(100);
        txtCity.setMaxWidth(100);
        txtCity.setOnKeyReleased(e -> CityStateZipValid(txtCity, txtZip, chbState, lblCityStateZipValidation));

        txtZip = new TextField();
        txtZip.setPrefColumnCount(5); 
        txtZip.setOnKeyReleased(e -> CityStateZipValid(txtCity, txtZip, chbState, lblCityStateZipValidation));
        
        chbState = new ChoiceBox(); 
        chbState.getItems().addAll("AK","AL","AR","AZ","CA","CO","CT","DC","DE",
                                   "FL","GA","GU","HI","IA","ID","IL","IN","KS",
                                   "KY","LA","MA","MD","ME","MH","MI","MN","MO",
                                   "MS","MT","NC","ND","NE","NH","NJ","NM","NV",
                                   "NY","OH","OK","OR","PA","PR","PW","RI","SC",
                                   "SD","TN","TX","UT","VA","VI","VT","WA","WI",
                                   "WV","WY");        
        chbState.setOnAction(e -> CityStateZipValid(txtCity, txtZip, chbState, lblCityStateZipValidation));
        

        //  Submit Button
        btnSubmit = new Button("Create New Patient Profile");
        btnSubmit.setAlignment(Pos.CENTER);
        btnSubmit.setOnAction(e -> onSubmitClick());

        //LAAYOUT PANES
        //  First Name
        HBox FNPane = new HBox(20, lblFirstName, txtFirstName, lblFirstNameValidation);
        FNPane.setPadding(new Insets(10));

        //  Last Name
        HBox LNPane = new HBox(20, lblLastName, txtLastName, lblLastNameValidation);
        LNPane.setPadding(new Insets(10));

        //  Phone Number
        //      Cell
        HBox CPPane = new HBox(20, lblCellPhone, txtCellPhone, lblCellPhoneValidation);
        CPPane.setPadding(new Insets(10));
        //      Home
        HBox HPPane = new HBox(20, lblHomePhone, txtHomePhone, lblHomePhoneValidation);
        HPPane.setPadding(new Insets(10));
        //      Work
        HBox WPPane = new HBox(20, lblWorkPhone, txtWorkPhone, lblWorkPhoneValidation);
        WPPane.setPadding(new Insets(10));

        //  Gender
        HBox GNPane = new HBox(20, lblGender, rdbMale, rdbFemale, lblGenderValidation);
        GNPane.setPadding(new Insets(10));

        //  Date of Birth
        HBox DOBPane = new HBox(20, lblDOB, dprDOB, lblDOBvalidation);
        DOBPane.setPadding(new Insets(10));

        //  Email Address
        HBox EMPane = new HBox(20, lblEmail, txtEmail, lblEmailValidation);
        EMPane.setPadding(new Insets(10));

        //  Address
        //      city and zip
        HBox ZPPane = new HBox(10, lblZip, txtZip);
        HBox CYPane = new HBox(10, lblCity, txtCity);
        HBox STPane = new HBox(10, lblState, chbState);
        HBox CZPane = new HBox(20, CYPane, STPane, ZPPane, lblCityStateZipValidation);
        CZPane.setPadding(new Insets(10));
        CZPane.setAlignment(Pos.BOTTOM_RIGHT);

        //      Address lines
        VBox ADPane = new VBox(10, txtAddress1, txtAddress2);
        HBox A1Pane = new HBox(10, lblAddress1, ADPane, lblAddressValidation);
        A1Pane.setPadding(new Insets(10));
        A1Pane.setAlignment(Pos.TOP_RIGHT);

        //      Full Address
        VBox FAPane = new VBox( A1Pane, CZPane);
        FAPane.setPadding(new Insets(10));
        FAPane.setAlignment(Pos.CENTER);
                

        //  Submit Button
        HBox SBPane = new HBox(10, btnSubmit);
        SBPane.setPadding(new Insets(20));
        SBPane.setAlignment(Pos.CENTER);

        //VBOX for contact information
        VBox contactPane = new VBox(10, FNPane, LNPane, CPPane, HPPane, WPPane, 
                                    GNPane, DOBPane, EMPane, FAPane);
        //HBOX for contact information fields and submit
        HBox entirePane = new HBox(30, contactPane, SBPane);

        //place finished pane in scene
        Scene scene = new Scene(entirePane);
        
        //return the finshed scene
        return scene;
    }
    
    private static void onSubmitClick()
    {
        boolean fieldsAreReady = true;
        
        //run through all validation labels to check for 'VALID'
        String[] validationLabels = {lblFirstNameValidation.getText(), 
            lblLastNameValidation.getText(), 
            lblEmailValidation.getText(), lblAddressValidation.getText(), 
            lblCityStateZipValidation.getText(), lblGenderValidation.getText(), 
            lblDOBvalidation.getText()};
        
        for (String theLabel : validationLabels)
        {
            if (!theLabel.matches("VALID"))
            {
                fieldsAreReady = false;                
                break;
            }
        }
        
        //Ensure there is at least one working phone number. NEEDS VALIDATION
        if (lblCellPhoneValidation.getText().matches("") | 
            lblHomePhoneValidation.getText().matches("") | 
            lblWorkPhoneValidation.getText().matches(""))
        {
            fieldsAreReady = false;
        }
            
                
            
        
        //if all labels are valid, add the patiend to the database, else throw warning alert.
        if (fieldsAreReady)
        {
            DatabaseAdd.addPatientContact(txtFirstName.getText(), 
                    txtLastName.getText(),txtCellPhone.getText(), 
                    txtHomePhone.getText(), txtWorkPhone.getText(), 
                    selectedGender, 
                    dprDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
                    txtEmail.getText(), txtAddress1.getText(), txtAddress2.getText(), 
                    txtCity.getText(), chbState.getValue(), txtZip.getText());
        }
        else
        {
            Alert altPatInfoWrong = new Alert(AlertType.WARNING);
            altPatInfoWrong.setTitle("WARNING");
            altPatInfoWrong.setHeaderText("Patient Input Error");
            altPatInfoWrong.setContentText("one or more of the fields are entered incorrectly");
            altPatInfoWrong.showAndWait();
        }
            
    }      

    public static void NameValid(TextField name, Label relatedLabel)
    
    {
        /*Conditions:   
        * Two Characters at least, 45 Characters max
        * Letters, spaces, only
        * At least two non-space characters. 
        */
        String regex = "^\\S[a-zA-Z\\s]{1,45}+";
        
        if (name.getText().matches(regex)) //Input matches regex
        {
            relatedLabel.setStyle("-fx-text-fill: green");
            relatedLabel.setText("VALID");
        }
        else if (name.getText().isEmpty()) //Input field is empty
        {
            relatedLabel.setStyle("-fx-text-fill: black");
            relatedLabel.setText("required");           
        }
        else //input field does not match regex
        {
            relatedLabel.setStyle("-fx-text-fill: red");
            relatedLabel.setText("ERROR");
        }                                                           
    } 
    
    public static void PhoneNumValid(TextField number, Label relatedLabel)
    {
        /* Condition
        *   must be a three digits,  a '-', three digits, a '-', and four digits
        */
        String regex = "\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";
        
        if (number.getText().matches(regex))
        {
            relatedLabel.setStyle("-fx-text-fill: green");
            relatedLabel.setText("VALID");
        }
        else if (number.getText().isEmpty()) //Input field is empty
        {
            relatedLabel.setStyle("-fx-text-fill: black");
            relatedLabel.setText("xxx-xxx-xxxx format");           
        }
        else
        {
            relatedLabel.setStyle("-fx-text-fill: red");
            relatedLabel.setText("ERROR");
        }
    }
    public static void EmailValid(TextField email, Label relatedLabel)
    {
        /*valid email regex copied from: 
        http://regexlib.com/Search.aspx?k=email&AspxAutoDetectCookieSupport=1 
        used with permiession from site*/
        
        String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\."
                + "[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]"
                + "{1,3})(\\]?)$";               
        
        if(email.getText().matches(regex))
        {
            relatedLabel.setStyle("-fx-text-fill: green");
            relatedLabel.setText("VALID");
        }
        else if (email.getText().isEmpty())
        {
            relatedLabel.setStyle("-fx-text-fill: black");
            relatedLabel.setText("required");
        }
        else
        {
            relatedLabel.setStyle("-fx-text-fill: red");
            relatedLabel.setText("ERROR");
        }
    }
    
    public static void AddressValid(TextField firstLine, TextField secondLine, 
            Label relatedLabel)
    {
        int maxLength = 10;
        if((firstLine.getText().length() < maxLength) && 
           (secondLine.getText().length() < maxLength) && 
            !firstLine.getText().isEmpty())
        {
           relatedLabel.setStyle("-fx-text-fill: green");
            relatedLabel.setText("VALID"); 
        }
        else if (firstLine.getText().isEmpty())
        {
            relatedLabel.setStyle("-fx-text-fill: black");
            relatedLabel.setText("required");
        }
        else
        {
            relatedLabel.setStyle("-fx-text-fill: red");
            relatedLabel.setText("ERROR");
        }
        
    }
    
    public static void CityStateZipValid(TextField city, TextField zip, 
            ChoiceBox state, Label relatedLabel)
    {
        String regexCity = "^\\S[a-zA-Z\\s]{1,10}+";
        String regexZip = "^\\d{5}(?:[-\\s]\\d{4})?$";       
        
        if ((city.getText().matches(regexCity)) 
                && (zip.getText().matches(regexZip))
                && (state.getValue() !=  null))
        {
            relatedLabel.setStyle("-fx-text-fill: green");
            relatedLabel.setText("VALID");
        }
        else if ((city.getText().isEmpty()) | (zip.getText().isEmpty()))
        {
            relatedLabel.setStyle("-fx-text-fill: black");
            relatedLabel.setText("required"); 
        }
        else
        {
            relatedLabel.setStyle("-fx-text-fill: red");
            relatedLabel.setText("ERROR");
        }
    }
    
    public static void GenderValidMale(Label relatedLabel)
    {
        relatedLabel.setText("VALID");
        relatedLabel.setStyle("-fx-text-fill: green");
        
        selectedGender = "Male";
    }
    
    public static void GenderValidFemale(Label relatedLabel)
    {
        relatedLabel.setText("VALID");
        relatedLabel.setStyle("-fx-text-fill: green");
        
        selectedGender = "Female";
    }
    
    public static void DOBValid(DatePicker dob, Label relatedLabel)
    {
        if(dob.getValue() != null)
        {
            relatedLabel.setText("VALID");
            relatedLabel.setStyle("-fx-text-fill: green");
        }
        else
        {
            relatedLabel.setText("MUST BE mm/dd/yyyy");
            relatedLabel.setStyle("-fx-text-fill: black");
        }
    }
}

