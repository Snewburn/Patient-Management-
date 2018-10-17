/*
The MainScreen class contains the javaFX gui controls and for the main screen scene
*/
package fortmyergui;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;


public class MainScreen 
{
    //controls for the scene
    static Button btnAddNewPatient;
    static Button btnDisplayAllPatients;
    static Button btnDeletePatient;
    
    static TextArea txaDisplay;
    
    public static Scene CreateMainScene()
    {
        //CONTROLS
        //  Text Area
        txaDisplay = new TextArea("Patients displayed here");
        txaDisplay.setPrefColumnCount(50);
        txaDisplay.setPrefRowCount(25);
        
        //  Buttons
        btnAddNewPatient = new Button("Add New Patient");
        btnDisplayAllPatients = new Button("Display Patients");
        btnDeletePatient = new Button("Delete a Patient");
        
        //PANES
        //  Buttons
        HBox HBButtons = new HBox(10, btnAddNewPatient, btnDisplayAllPatients, btnDeletePatient);
        HBButtons.setPadding(new Insets(10));
        HBButtons.setAlignment(Pos.CENTER);
        
        //  Buttons and TextArea
        VBox VBAll = new VBox(10, txaDisplay, HBButtons);
        
        Scene scene = new Scene(VBAll);
        
        //set action for buttons
        btnAddNewPatient.setOnAction(e -> onNewPatientClick());
        btnDisplayAllPatients.setOnAction(e -> onDisplayPatientsClick());
      
        //scene object is returned to the invoking method. 
        return scene;
    }
    
    //Event Handler for Add New Patient Button
    private static void onNewPatientClick()
    {
        Stage STGCreatePatient = new Stage();
        STGCreatePatient.setTitle("New Patient Contact Information");
        STGCreatePatient.setScene(CreateNewPatientScreen.CreateNewPatientScene());
        STGCreatePatient.show();      
    }
    
    private static void onDisplayPatientsClick()
    {
        //Pull data from Database, format, and display in textArea        
        txaDisplay.setText(DisplayData.displayAllPatientContactInformation());
    }                        
}
