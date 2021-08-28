package project.estateagentapplication;/*
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

//PropertyCustomerAreaGUI class will have customer GUI scene

//main class
public class PropertyCustomerAreaGUI
{
   //Declare variables
   TextField txtSearchByType;
   TextField txtSearchByNumBed;
   TextField txtSearchByPriceRange;
   TextField txtpropNumForTax;
   Button btnViewAllProperties;
   Button btnSearchByType;
   Button btnSearchByNumBeds;
   Button btnSearchByPriceRange;
   Button btnStaffArea;
   Button btnCalculateTax;
   TextArea txtCustomerOutput;
   
   //declare and instatiate an PropertyAlert object
   PropertyAlert propertyAlert = new PropertyAlert();
   //declare and instatiate an TextFieldValidationUtils object
   TextFieldValidationUtils textFieldValidationUtils = new TextFieldValidationUtils();
   
   /*declare a PropertyDataStore object.
    PropertyDataStore is a class that stores all properties managed by 
    PropertyCustomerAreaGUI and PropertyStaffAreaGUI. 
    The actual instance of the PropertyDataStore is provided by PropertyGUI.*/
   PropertyDataStore propertyDataStore;
   
   //PropertyCustomerAreaGUI Constructor receiving PropertyDataStore object as an argument.
   public PropertyCustomerAreaGUI(PropertyDataStore applicationPropertyDataStore)
   {
      propertyDataStore = applicationPropertyDataStore;
   }//end of PropertyCustomerAreaGUI constructor
   
   //method getScene create and return customer Scene.
   public Scene getScene()
   {
      /*******Controls for customer scene:*********/
      
      //Declare and instantiate Label objects
      Label lblPropSearch = new Label("****Property Search****");
      Label lblSearchByType = new Label("Insert Property Type");
      Label lblSearchByNumBed = new Label("Insert No Bedrooms");
      Label lblSearchByPriceRange = new Label("Insert Price Range");
      Label lblpropNumForTax = new Label("Insert property number\n to calculate tax");

      //instantiate Button objects
      btnStaffArea = new Button("Estate Agents Area");
      btnViewAllProperties = new Button("View All Properties");
      btnSearchByType = new Button("Search by Type");
      btnSearchByNumBeds = new Button("Search by Bedrooms");
      btnSearchByPriceRange = new Button("Search by Price Range");
      btnCalculateTax = new Button("Calculate tax");
       
      /*using lambda expression to set buttons action when they are pressed 
      and set minimum Width (buttons) */     
      btnViewAllProperties.setOnAction(e -> viewAllPropMainPage(e));
      btnViewAllProperties.setMinWidth(130);
      btnSearchByType.setOnAction(e -> searchPropByType(e));
      btnSearchByType.setMinWidth(130);
      btnSearchByNumBeds.setOnAction(e -> searchPropByNumBeds(e));
      btnSearchByNumBeds.setMinWidth(130);   
      btnSearchByPriceRange.setOnAction(e -> searchPropByPriceRange(e));   
      btnSearchByPriceRange.setMinWidth(130); 
      btnCalculateTax.setOnAction(e -> calculateTax(e));
      btnCalculateTax.setMinWidth(130);
      
      //instantiate and setting maximum size of TextArea object
      txtCustomerOutput = new TextArea();
      txtCustomerOutput.setMaxSize(600,400);
      
      //instantiate and setting maximum width of TextField objects
      txtSearchByNumBed = new TextField();
      txtSearchByNumBed.setMaxWidth(100);
      txtSearchByType = new TextField();
      txtSearchByType.setMaxWidth(100);
      txtSearchByPriceRange = new TextField();
      txtSearchByPriceRange.setMaxWidth(100);
      txtpropNumForTax = new TextField();
      txtpropNumForTax.setMaxWidth(100);
      
      //make the customer text area not editable, so you can't write there.
      txtCustomerOutput.setEditable(false);

      //Create a Layout using HBox and (positions all its components in a horizontal row)
      HBox propSearchLayout1 = new HBox(8);
      propSearchLayout1.getChildren().addAll(lblSearchByNumBed, txtSearchByNumBed,
      btnSearchByNumBeds);
      propSearchLayout1.setAlignment(Pos.CENTER); //aligning(center).
      
      //Create a Layout using HBox (positions all its components in a horizontal row)
      HBox propSearchLayout2 = new HBox(8);
      propSearchLayout2.getChildren().addAll(lblSearchByType, txtSearchByType, btnSearchByType);
      propSearchLayout2.setAlignment(Pos.CENTER); //aligning(center).
      
      //Create a Layout using HBox (positions all its components in a horizontal row)
      HBox propSearchLayout3 = new HBox(8);
      propSearchLayout3.getChildren().addAll(lblSearchByPriceRange, txtSearchByPriceRange, btnSearchByPriceRange);
      propSearchLayout3.setAlignment(Pos.CENTER); //aligning(center).
      
      //Create a Layout using HBox (positions all its components in a horizontal row)
      HBox propLayout4 = new HBox(8);
      propLayout4.getChildren().addAll(lblpropNumForTax, txtpropNumForTax, btnCalculateTax);
      propLayout4.setAlignment(Pos.CENTER); //aligning(center).

      //Create a Layout using VBox and (positions all its components in a vertical column)   
      VBox root = new VBox(15);
      root.getChildren().addAll(propSearchLayout1, propSearchLayout2,
      propSearchLayout3, propLayout4, btnViewAllProperties, lblPropSearch, txtCustomerOutput, btnStaffArea);
      root.setAlignment(Pos.CENTER); //aligning(center).
      
      //Create and instatiate Scene object
      Scene customerScene = new Scene(root, 700, 500); 
      //return Scene object
      return customerScene;
      
   }//end of getScene method
   
   //method to return btnStaffArea Button
   public Button getBtnStaffArea()
   {
      return btnStaffArea;
   }//end of getBtnStaffArea method
   
   //method to clear Customer's Text Area
   public void clearTxtCustomerOutput()
   {
      txtCustomerOutput.clear();
   }//end of clearTxtCustomerOutput method
   
   //method to view all Properties in customer's text area(txtCustomerOutput)
   public void viewAllPropMainPage(ActionEvent e)
   {  //clear Text Area
      txtCustomerOutput.clear();
     
      //display all Property objects in customer's text area(txtCustomerOutput)
      txtCustomerOutput.setText(propertyDataStore.getPropertiesForOutput());
   }// end of viewAllPropMainPage method

   //method to search properties by type(detached, semi-detached, bungalow, flat etc)
   public void searchPropByType(ActionEvent e)
   {
      //clear textFields
      txtSearchByNumBed.clear();
      txtSearchByPriceRange.clear();
      txtpropNumForTax.clear();
      txtCustomerOutput.clear();
      
      //variable to store txtSearchByType input
      String customerInput = txtSearchByType.getText();
      
      //if condition to check if customerInput is empty
      if(customerInput.isEmpty())
      {  //alert message to display if customerInput is empty
         propertyAlert.createAlert("You must enter a property type!");
         
         /*REFERENCE:
         https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/

         //The return keyword finished the execution of the method if customerInput is empty
         return;
      }//end of if
      
      /*The propertiesFound variable stores propertyDataStore.findPropertyByType() method.
        propertyDataStore.findPropertyByType() method will retrieve from 
        PropertyDataStore object only the properties 
        in which matches the customer's input.*/
      String propertiesFound = propertyDataStore.findPropertyByType(customerInput);
      
      //if condition to check if there are properties in which matches the customer's input
      if(propertiesFound.isEmpty())
      {  /*if there is no matches (propertiesFound variable is empty)
           display an alert message*/
         String s = "Enter a valid option, for example:\n Detached\n Semi-Deached \n Flat \nBungalow";
         propertyAlert.createAlert(s);
      }//end of if
      /*else condition:
         if there are properties in which matches the customer's input,
         display the matched property objects*/
      else
      {  /*display all matched property objects 
          in customer text area(txtCustomerOutput)*/
         txtCustomerOutput.setText(propertiesFound);
      }//end of else
      
   }//end of searchPropByType method
   
   //method to search properties by number of Bedrooms       
   public void searchPropByNumBeds(ActionEvent e) throws NumberFormatException
   {
      //clear textFields
      txtSearchByType.clear();
      txtSearchByPriceRange.clear();
      txtpropNumForTax.clear();
      txtCustomerOutput.clear();
      
      //variable to store txtSearchByNumBed input
      String txtNumBed = txtSearchByNumBed.getText();
      
      /*if condition to check Exception.*/
      /*textFieldValidationUtils.validateStringIsNumericAndPositive() method checks
        if customer inputted a numeric and positive number.*/
      /*if textFieldValidationUtils.validateStringIsNumericAndPositive() method is false,
        the "if statement" will be executed"
        (display an alert message and finish the execution of the method)*/
      if(textFieldValidationUtils.validateStringIsNumericAndPositive(txtNumBed, "number of bedrooms") == false)
      {
         /*REFERENCE:
         https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
         //The return keyword finished the execution of the method if customerInput is empty
         return;
      }//end of if
      /*else condition:
       if customer inputted a numeric and positive number,
       then execute statement.*/
      else
      {  //variable to store txtNumBed input
         int numBeds = Integer.parseInt(txtNumBed);
         
         /*The propertiesFound variable stores propertyDataStore.findPropertyByType() method.
         propertyDataStore.findPropertyByType() method will retrieve from 
         PropertyDataStore object only the properties 
         in which matches the customer's input.*/
         String propertiesFound = propertyDataStore.findAllPropertiesByNumberOfBeds(numBeds);
         
         //if condition to check if propertiesFound variable is empty
         if(propertiesFound.isEmpty())
         {  /*if propertiesFound variable is empty
             show info message */
            txtCustomerOutput.setText("No property matching found");
         }//end of if
         /*else condition:
         if there are properties in which matches the customer's input
         (propertiesFound variable is not empty),
         then display the matched property objects*/
         else
         {  /*display all matched property objects
            in customer text area(txtCustomerOutput)*/
            txtCustomerOutput.setText(propertiesFound);
         }//end of else
      }//end of else
   }//end of searchPropByNumBeds method
   
   //searchPropByPriceRange method
   /*Allow a customer to enter their maximum price range and display all 
   properties within that price range*/
   public void searchPropByPriceRange(ActionEvent e)
   {
      //clear textFields
      txtSearchByNumBed.clear();
      txtSearchByType.clear();
      txtpropNumForTax.clear();
      txtCustomerOutput.clear();
      
      //variable to store txtSearchByPriceRange input
      String txtPriceRange = txtSearchByPriceRange.getText();
      
      /*if condition to check Exception.*/
      /*textFieldValidationUtils.validateStringIsNumericAndPositive() method checks
        if customer inputted a numeric and positive number.*/
      /*if textFieldValidationUtils.validateStringIsNumericAndPositive() method is false,
        the "if statement" will be executed"
        (display an alert message and finish the execution of the method)*/
      if(textFieldValidationUtils.validateStringIsNumericAndPositive(txtPriceRange, "price range") == false)
      {
         /*REFERENCE:
         https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
         //The return keyword finished the execution of the method if customerInput is empty
         return;
      }//end of if
      /*else condition:
       if customer inputted a numeric and positive number,
       then execute statement.*/
      else
      {  //variable to store txtPriceRange
         double priceRange = Double.parseDouble(txtPriceRange);
         
         /*The propertiesFound variable stores propertyDataStore.findPropertyByType() method.
         propertyDataStore.findPropertyByType() method will retrieve from 
         PropertyDataStore object only the properties 
         in which matches the customer's input.*/
         String propertiesFound = propertyDataStore.findAllPropertiesByPriceRange(priceRange);
         
         //if propertiesFound variable is empty, execute statement.
         if(propertiesFound.isEmpty())
         {  
            /*if there is no properties that matches the customer's input, 
            show info message */
            txtCustomerOutput.setText("No properties within that price range found");
         }//end of if
         /*else condition:
         if there is properties that matches the customer's input,
         display those matched property objects*/
         else
         {  /*display all matched property objects 
            in customer text area(txtCustomerOutput)*/
            txtCustomerOutput.setText(propertiesFound);
         }//end of else
      }//end of else
   }//end of searchPropByPriceRange method
   
   //method to calculate tax according with the property price
   public void calculateTax(ActionEvent e) throws NumberFormatException
   {
      //clear textFields
      txtSearchByNumBed.clear();
      txtSearchByType.clear();
      txtSearchByPriceRange.clear();
      txtCustomerOutput.clear();
      
      //variable to store txtpropNumForTax input (number of property)
      String propertyNumInput = txtpropNumForTax.getText();
      
      /*if condition to check Exception.*/
      /*textFieldValidationUtils.validateStringIsNumericAndPositive() method checks
        if customer inputted a numeric and positive number.*/
      /*if textFieldValidationUtils.validateStringIsNumericAndPositive() method is false,
        the "if statement" will be executed"
        (display an alert message and finish the execution of the method)*/
      if(textFieldValidationUtils.validateStringIsNumericAndPositive(propertyNumInput, "property number") == false)
      {  /*REFERENCE:
         https://www.w3schools.com/java/ref_keyword_return.asp#:~:text=Definition%20and%20Usage,a%20value%20from%20a%20method.*/
         //The return keyword finished the execution of the method if customerInput is empty
         return;
      }//end of if
      /*else condition:
       if customer inputted a numeric and positive number,
       then execute statement.*/
      else
      {  //variable to store propertyNumInput input (number of property) 
         int propertyNumber = Integer.parseInt(propertyNumInput);
         
         /*variable to store the retrieved property from the PropertyDataStore object.
         The property will be retrieved according to 
         the property number inputted by the customer.*/
         Property property = propertyDataStore.findPropertyByNumber(propertyNumber);
         
         /*if condition to check if there is property wich matches the customer's input*/
         if(property == null)
         {  /*if there is no property wich matches the customer's input, 
            show alert message */
            propertyAlert.createAlert("Insert a valid property number");
         }//end of if
         /*else condition:
         if there is a property which matches the customer's input,
         display that matched property object*/
         else
         {  /*REFERENCE:
            https://www.javatpoint.com/java-string-valueof*/
            
            /*variable to store property.calculatePropertyTax() method.
             property.calculatePropertyTax() method 
             will calculate the tax of the property in which the 
             customer inputted*/
            String taxOutput = String.valueOf(property.calculatePropertyTax());
            
            /*display property tax according with matched property object 
             in customer text area(txtCustomerOutput)*/
            txtCustomerOutput.setText("The property tax for property number "+ propertyNumber + " is: "+ taxOutput);
         }//end of else
      }//end of else
   }//end of calculateTax method 
}//end of main class