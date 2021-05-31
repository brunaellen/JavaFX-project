/*
Bruna Ellen Gurgel Souza - L00157216
Assignment1 (create a GUI)
*/
//import packages containing predefined classes
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.*;
import java.util.stream.Collectors;

//PropertyGUI is the main Property GUI class

//main class
public class PropertyGUI extends Application
{
   //declare and instantiate PropertyDataStore object
   PropertyDataStore propertyDataStore = new PropertyDataStore();
   //declare and instantiate TextFieldValidationUtils object
   TextFieldValidationUtils textFieldValidationUtils = new TextFieldValidationUtils();
   //declare and instantiate PropertyCustomerAreaGUI object
   PropertyCustomerAreaGUI customerArea = new PropertyCustomerAreaGUI(propertyDataStore);
   //declare and instantiate PropertyStaffAreaGUI object
   PropertyStaffAreaGUI staffArea = new PropertyStaffAreaGUI(propertyDataStore);
   
   //start method
   public void start(Stage stage)
   {  /*Scene object(customerScene) will receive customer scene.
      customerArea.getScene() method will get customer scene 
      from PropertyCustomerAreaGUI object*/
      Scene customerScene = customerArea.getScene();
      //Add customer scene to the stage
      stage.setScene(customerScene);
      //set title of stage
      stage.setTitle("LYIT Estate Agents");
      //Show the stage
      stage.show();
      
      /*Scene object(staffScene) will receive staff scene.
      staffArea.getStaffScene() method will get staff scene 
      from PropertyStaffAreaGUI object*/
      Scene staffScene = staffArea.getStaffScene();
      /*Scene object(updatePropScene) will receive "Update Property" scene.
      staffArea.getUpdatePropScene() method will get "Update Property" scene 
      from PropertyStaffAreaGUI object*/   
      Scene updatePropScene = staffArea.getUpdatePropScene();
      
      /*using lambda expression to change from one scene to another scene
       when a specific button is pressed*/
       //when button getBtnStaffArea is pressed, display staff scene.
      customerArea.getBtnStaffArea().setOnAction(e -> {
         stage.setScene(staffScene);//display staffScene
         customerArea.clearTxtCustomerOutput();//clear customer text area
      });
      //when button btnReturnCustomerPage is pressed, display customer scene.
      staffArea.getBtnReturnCustomerPage().setOnAction(e -> stage.setScene(customerScene));
      //when button btnUpdateAndDeleteArea is pressed, display "Update Property" scene.
      staffArea.getBtnUpdateAndDeleteArea().setOnAction(e -> stage.setScene(updatePropScene));
      //when button btnReturnStaffPage is pressed, display staff scene.
      staffArea.getBtnReturnStaffPage().setOnAction(e -> stage.setScene(staffScene));
      
   }//end start method
   
   //main method
   public static void main(String[]args)
   {
      launch(args);
   }//end of main method
}//end of class