/*
main method for the application 
creates primaryStage and called the MainScreen object. 
*/
package fortmyergui;

import javafx.application.*;
import javafx.stage.*;

public class FortMyerGUI extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override public void start(Stage primaryStage)
    {
        //primaryStage.setScene(CreateNewPatientScreen.CreateNewPatientScene());
        primaryStage.setScene(MainScreen.CreateMainScene());
        primaryStage.setTitle("Main Screen");
        primaryStage.show();
    }
}
