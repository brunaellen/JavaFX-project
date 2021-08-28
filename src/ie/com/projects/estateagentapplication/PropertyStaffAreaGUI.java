package ie.com.projects.estateagentapplication;/*
Bruna Ellen Gurgel Souza - L00157216
Assignment1 (create a GUI)
*/

//import packages containing predefined classes 

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*PropertyStaffAreaGUI class will have two scene:
  1st scene:  staff scene.
  2nd scene: "Update Property" scene. */

//main class
public class PropertyStaffAreaGUI
{  //Declare variables
   TextField txtStreet;
   TextField txtTown;
   TextField txtCounty;
   TextField txtNumBeds;
   TextField txtNumReception;
   TextField txtNumBaths;
   TextField txtType;
   TextField txtPrice;
   TextField txtNumProperty;
   TextField txtPriceUpdate;
   Button btnAddProperty;
   Button btnViewAllPropStaffArea;
   Button btnUpdateAndDeleteArea;
   Button btnDeleteProperty;
   Button btnReturnCustomerPage;
   Button btnReturnStaffPage;
   Button btnNewPropPrice;
   TextArea txtStaffOutput;
   
   //declare and instatiate PropertyAlert object
   PropertyAlert propertyAlert = new PropertyAlert();
   //declare and instatiate an TextFieldValidationUtils object
   TextFieldValidationUtils textFieldValidationUtils = new TextFieldValidationUtils();
   
   /*declare a PropertyDataStore object.
    PropertyDataStore is a class that stores all properties managed by 
    PropertyCustomerAreaGUI and PropertyStaffAreaGUI. 
    The actual instance of the PropertyDataStore is provided by PropertyGUI.*/
   PropertyDataStore propertyDataStore;
   
   //PropertyStaffAreaGUI Constructor receiving PropertyDataStore object as an argument.
   public PropertyStaffAreaGUI(PropertyDataStore applicationPropertyDataStore)
   {
      propertyDataStore = applicationPropertyDataStore;
   }//end of contructor
   
   //method getStaffScene create and return staff Scene.
   public Scene getStaffScene()
   {
      /********** Controls for staff scene: ***********/
      
      //Declare and instantiate Labels objects
      Label lblStreet = new Label("Street");
      Label lblTown = new Label("Town");
      Label lblCounty = new Label("county");
      Label lblNumBeds = new Label("Beds");
      Label lblNumReception = new Label("Receptions");
      Label lblNumBaths = new Label("Baths");
      Label lblType = new Label("Type");
      Label lblPrice = new Label("Price");
      Label lblEnterPropDetails = new Label("***Enter Property Details***");
      Label updateAndDeleteArea = new Label("***Update or Delete Area***");
      
      //instantiate all TextFields objects and set maximum width
      txtStreet = new TextField();
      txtStreet.setMaxWidth(100);
      txtTown = new TextField();
      txtTown.setMaxWidth(100);
      txtCounty = new TextField();
      txtCounty.setMaxWidth(100);
      txtNumBeds = new TextField();
      txtNumBeds.setMaxWidth(50);
      txtNumReception = new TextField();
      txtNumReception.setMaxWidth(50);
      txtNumBaths = new TextField();
      txtNumBaths.setMaxWidth(50);
      txtType = new TextField();
      txtType.setMaxWidth(80);
      txtPrice = new TextField();
      txtPrice.setMaxWidth(50);
      
      //instantiate all Buttons objects
      btnAddProperty = new Button("Add Property");
      btnViewAllPropStaffArea = new Button("View All Properties");
      btnUpdateAndDeleteArea = new Button("Update or Delete Area");
      btnReturnCustomerPage = new Button("Return To Main Page");
      
      //using lambda expression to set buttons action when they are pressed
      btnAddProperty.setOnAction(e -> addPropDetails(e));
      btnViewAllPropStaffArea.setOnAction(e -> viewAllPropStaffArea(e)); 

      //instantiate TextArea object to create the text area
      txtStaffOutput = new TextArea();
      txtStaffOutput.setMaxSize(600,400);//set maximum size of txtStaffOutput
      
      //make the Text area not editable, so you can't write there.
      txtStaffOutput.setEditable(false);
      
      //Create a Layout using HBox and (positions all its components in a horizontal row)
      HBox propAddressLayout = new HBox(8);
      propAddressLayout.getChildren().addAll(lblStreet, txtStreet, 
      lblTown, txtTown, lblCounty, txtCounty);
      propAddressLayout.setAlignment(Pos.CENTER); //align(center)
      
      //Create a Layout using HBox (positions all its components in a horizontal row)
      HBox propDetailsLayout = new HBox(8);
      propDetailsLayout.getChildren().addAll(lblNumBeds, txtNumBeds, lblNumReception, 
      txtNumReception, lblNumBaths, txtNumBaths, lblType, txtType, lblPrice, txtPrice);
      propDetailsLayout.setAlignment(Pos.CENTER); //align(center)
      
      //Create a Layout using HBox (positions all its components in a horizontal row)
      HBox buttonsLayout2 = new HBox(8);
      buttonsLayout2.getChildren().addAll(btnAddProperty, btnViewAllPropStaffArea);
      buttonsLayout2.setAlignment(Pos.CENTER);//align(center)

      //Create a Layout using VBox and (positions all its components in a vertical column)  
      VBox root2 = new VBox(15);
      root2.getChildren().addAll(lblEnterPropDetails, propAddressLayout, propDetailsLayout,
      buttonsLayout2, updateAndDeleteArea, btnUpdateAndDeleteArea, txtStaffOutput, btnReturnCustomerPage);
      root2.setAlignment(Pos.CENTER);//align(center)
      
      //Create and instatiate Scene object
      Scene staffScene = new Scene(root2, 700, 500);
      //return staffScene object
      return staffScene;
   }//end of getStaffScene method
   
   //method getUpdatePropScene to create and return "Update Property" Scene.
   public Scene getUpdatePropScene()
   {
      /******** "Update Property" scene *********/
      
      //Declare and instantiate Label objects
      Label lblNumProperty = new Label("Property Number");
      Label lblUpdatePropPrice = new Label("Insert new price");
      
      //instantiate and setting maximum width of TextField objects
      txtPriceUpdate = new TextField();
      txtPriceUpdate.setMaxWidth(100);
      txtNumProperty = new TextField();
      txtNumProperty.setMaxWidth(70);
      
      //instantiate Button objects
      btnNewPropPrice = new Button("Update price");
      btnReturnStaffPage = new Button("Return to staff area");
      btnDeleteProperty = new Button("Delete Property Details");
      
      //using lambda expression to set buttons action when they are pressed
      btnNewPropPrice.setOnAction(e -> updatePropPrice(e));
      btnDeleteProperty.setOnAction(e -> deleteProperty(e));
      
      //Create a Layout using HBox and (positions all its components in a horizontal row)
      HBox layout = new HBox(8);
      layout.getChildren().addAll(lblNumProperty, txtNumProperty, lblUpdatePropPrice, txtPriceUpdate);
      layout.setAlignment(Pos.CENTER);//aligning(center).
      
      //Create a Layout using HBox and (positions all its components in a horizontal row)
      HBox layout2 = new HBox(8);
      layout2.getChildren().addAll(btnDeleteProperty, btnNewPropPrice);
      layout2.setAlignment(Pos.CENTER);//aligning(center).
      
      //Create a Layout using VBox and (positions all its components in a vertical column)  
      VBox root3 = new VBox(8);
      root3.getChildren().addAll(layout, layout2, btnReturnStaffPage);
      root3.setAlignment(Pos.CENTER);//aligning(center).
      
      //Create and instatiate Scene object
      Scene updatePropScene = new Scene(root3, 700, 500);
      //return Scene object
      return updatePropScene;
   }//end of getUpdatePropScene method
   
   //method to return btnReturnCustomerPage Button
   public Button getBtnReturnCustomerPage()
   {
      return btnReturnCustomerPage;
   }//end of getBtnReturnCustomerPage method
   
   //method to return btnUpdateAndDeleteArea Button
   public Button getBtnUpdateAndDeleteArea()
   {
      return btnUpdateAndDeleteArea;
   }//end of getBtnUpdateAndDeleteArea method
   
   //method to return btnReturnStaffPage Button
   public Button getBtnReturnStaffPage()
   {
      return btnReturnStaffPage;
   }//end of getBtnReturnStaffPage method
   
   //method to clear Textfield objects
   public void clearTextField()
   {
      //clear textField
      txtStreet.clear();
      txtTown.clear();
      txtCounty.clear();
      txtNumBeds.clear();
      txtNumReception.clear();
      txtNumBaths.clear();
      txtType.clear();
      txtPrice.clear();
   }//end of clearTextField method
   
   //method addPropDetails to add a Property object
   public void addPropDetails(ActionEvent e) throws NumberFormatException
   {  //clear Text area
      txtStaffOutput.clear();
      //boolean variable used to check if any Field Is Empty
      boolean anyFieldIsEmpty = true;
      
      //if any Field Is Empty, then display an alert message
      if(txtStreet.getText().isEmpty() || 
         txtTown.getText().isEmpty() ||
         txtCounty.getText().isEmpty() || 
         txtNumBeds.getText().isEmpty() ||
         txtNumReception.getText().isEmpty() || 
         txtNumBaths.getText().isEmpty() ||
         txtType.getText().isEmpty() || 
         txtPrice.getText().isEmpty())
      {  //display alert message
         propertyAlert.createAlert("You must enter values for all fields");
      }
      /*else condition:
       if all fields are filled, then set variable anyFieldIsEmpty to true*/
      else{anyFieldIsEmpty = false;}
      
      //try block to add a Property object
      try
      {  //if variable anyFieldIsEmpty is false, then execute the statement
         if(anyFieldIsEmpty == false)
         {  //declare variables and assign its values
            int zero = 0;
            int numBeds = Integer.parseInt(txtNumBeds.getText());
            int numBath = Integer.parseInt(txtNumBaths.getText());
            int numRecep = Integer.parseInt(txtNumReception.getText());
            double price = Double.parseDouble(txtPrice.getText());
            
            /*if numBeds or numBath or numRecep or price are negative numbers, 
            then display an alert message*/
            if(numBeds < zero ||
               numRecep < zero  ||
               numBath < zero ||
               price < zero)
            {  //display an alert message
               propertyAlert.createAlert("You cannot enter a negative value");
            }//end of if
            /*if numBeds, numBath, numRecep and price are positive numbers, 
            then execute statement*/
            else
            {  //declare variables and assign its values
               String street = txtStreet.getText();
               String town = txtTown.getText();
               String county = txtCounty.getText();
               String propType = txtType.getText();
               
               //create a new Property object and add it into (propertyDataStore.getPropertyList())
               propertyDataStore.getPropertyList().add(new Property(street, town, county, numBeds, numBath, numRecep, price, propType));
               //display alert message
               propertyAlert.createAlert("Property successfully added");
            }//end of else
         }//end of if 
      }//end of try block
      
      //catch NumberFormatException exception
      catch(NumberFormatException ex)
      {  //display alert
         propertyAlert.createAlert("Beds, reception, baths and price \nmust contain numbers only!");
      }//end of catch   
   }//end of addPropDetails method
      
   //method to view all Properties added in staff area
   public void viewAllPropStaffArea(ActionEvent e)
   {  //clear TextArea object
      txtStaffOutput.clear();
      //clear TextField objects
      clearTextField();
      //display all Property objects in txtStaffOutput
      txtStaffOutput.setText(propertyDataStore.getPropertiesForOutput());
   }// end of viewAllPropStaffArea mehod

   //method to update a property price   
   public void updatePropPrice(ActionEvent e) throws NumberFormatException
   {  //clear TextArea object
      txtStaffOutput.clear();
      
      //declare variables and assign its values
      String txtNewPrice = txtPriceUpdate.getText();
      String txtPropertyNum = txtNumProperty.getText();
      
      //try block to update a property price
      try
      {  //if txtPropertyNum or txtNewPrice is empty, then execute the statement
         if(txtPropertyNum.isEmpty() || txtNewPrice.isEmpty())
         {  //display an alert message
            propertyAlert.createAlert("You must enter values for all fields");
            /*REFERENCE:
            https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
            //The return keyword finished the execution of the method if customerInput is empty
            return;
         }//end of if
         
         //declare variable and assign its value
         double newPrice = Double.parseDouble(txtPriceUpdate.getText()); 
         /*if new price inputted by staff is a negative number, then execute statement*/
         if(newPrice < 0)
         {  //display alert message
            propertyAlert.createAlert("You cannot enter a negative number");
         }//end of if
         /*else condition:
          if the new price inputted by staff is a positive number, then execute statement*/
         else
         {  //declare variable and assign its value
            int propertyNumber = Integer.parseInt(txtNumProperty.getText());
            
            //declare and instantiate variable
            /*property variable receives a Property object that matches property
            number inputted by staff*/
            Property property = propertyDataStore.findPropertyByNumber(propertyNumber);
            
            //if property wasn't found, then execute statement
            if(property == null)
            {  //display the alert message
               propertyAlert.createAlert("Insert a valid property number");
               /*REFERENCE:
               https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
               //The return keyword finished the execution of the method if customerInput is empty
               return;
            }//end of if
            //if property number was found, then execute statement
            else
            {  //declare variables and assign its values
               int propertyNum = property.getPropertyNum();
               int staffPropertyNumInput = Integer.parseInt(txtNumProperty.getText());
               
               /*if property number inputted by staff matches 
               property number in propertyNum, 
               then execute statement
               */
               if(staffPropertyNumInput == propertyNum)
               {  //call method to update price
                  property.updatePrice(newPrice);
                  //declare variable and assign its value(concatenating)
                  String output = "Property price successfully updated \n";
                  output += "The price of property number "+ property.getPropertyNum(); 
                  output += " is now " + property.getPrice();
                  
                  //display an alert message(output)
                  propertyAlert.createAlert(output);
               }//end of if
            }//end of else
         }//end of else
      }//end of try block
      
      //catch NumberFormatException exception
      catch(NumberFormatException ex)
      {  //display alert message
         propertyAlert.createAlert("Property price must contain numbers only!");
      }//end of catch
   }//end of updatePropPrice method
   
   //method to delete a Property object
   public void deleteProperty(ActionEvent e) throws NumberFormatException
   {  //clear TextArea object
      txtStaffOutput.clear();
      //declare variable and assign its value
      String txtPropertyNum = txtNumProperty.getText();
      
      /*if condition to check Exception.*/
      /*textFieldValidationUtils.validateStringIsNumericAndPositive() method checks
        if staff inputted a numeric and positive number.*/
      /*if textFieldValidationUtils.validateStringIsNumericAndPositive() method is false,
        the "if statement" will be executed"
        (display an alert message and finish the execution of the method)*/
      if(textFieldValidationUtils.validateStringIsNumericAndPositive(txtPropertyNum, "property number") == false)
      {  /*REFERENCE:
         https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
         //The return keyword finished the execution of the method if customerInput is empty
         return;
      }//end of if
      /*else condition:
       if staff inputted a numeric and positive number,
       then execute statement.*/
      else
      {  //variable to store txtNumProperty input     
         int propertyNumber = Integer.parseInt(txtNumProperty.getText());
         
         //declare and instantiate variable
         /*property variable receives a Property object that matches property
         number inputted by staff*/
         Property property = propertyDataStore.findPropertyByNumber(propertyNumber);
         
         //if property wasn't found, then execute statement
         if(property == null)
         {  //display the alert message
            propertyAlert.createAlert("Insert a valid property number");
            /*REFERENCE:
            https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
            //The return keyword finished the execution of the method if customerInput is empty
            return;
         }//end of if
         //if property number was found, then execute statement
         else
         {  //remove property
            propertyDataStore.getPropertyList().remove(property);
            //display an alert messsage
            propertyAlert.createAlert("Property deleted");
         }//end of else
      }//end of else  
   }// end of deleteProperty method
}//end of main class