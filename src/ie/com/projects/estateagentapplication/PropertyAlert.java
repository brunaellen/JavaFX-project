package ie.com.projects.estateagentapplication;/*
Bruna Ellen Gurgel Souza - L00157216
Assignment1 (create a GUI)
*/

//PropertyAlert class was created to display alert messages

//import packages containing predefined classes 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//main class
public class PropertyAlert
{
   //main method to display alert messages
   public void createAlert(String message) 
   {  //declare, instantiate, set message and show an Alert object
      Alert alert = new Alert(AlertType.NONE);
      alert.setAlertType(AlertType.INFORMATION);
      alert.setContentText(message);
      alert.show();
   }//end method
}//end of main class