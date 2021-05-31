/*
Bruna Ellen Gurgel Souza - L00157216
Assignment1 (create a GUI)
*/

/*TextFieldValidationUtils is a class to check 
if what was entered in the text field is numeric and a positive number.*/

//main class
public class TextFieldValidationUtils
{  //declare and instantiate a PropertyAlert object
   private PropertyAlert propertyAlert = new PropertyAlert();
   
   /*method to check if 
   what was entered in the text field is numeric and a positive number*/
   public boolean validateStringIsNumericAndPositive(String numberAsString, String fieldName)
   {  //if text field is empty, then execute statement
      if(numberAsString.isEmpty())
      {  //display alert message
         propertyAlert.createAlert("you must enter a " + fieldName + "!");
         //return false
         return false;
      }//end of if
      
      //declare variable
      double number;
      
      //try block to check if the text field input is a number  
      try
      {  /*REFERENCE:
         https://www.w3schools.com/java/java_type_casting.asp
         */
         //assign a value to variable
         /*I am passing numberAsString as a double type so I can use:
         Widening Casting (automatically) - converting a smaller type to a larger type size
         if a numberAsString is a int type */
         number = Double.parseDouble(numberAsString);
      }//end of try block
      //catch NumberFormatException exception 
      catch(NumberFormatException ex)
      {  //display alert
         propertyAlert.createAlert(fieldName + " must contain numbers only!");
         //return false
         return false;
      }//end of catch  
      
      //if number is a negative number, then execute statement
      if(number < 0d)
      {  //display alert
         propertyAlert.createAlert("You cannot enter a negative number");
         //return false
         return false;
      }//end of if
      //return true
      return true;
   }// end of validateStringIsNumericAndPositive method
}//end of main class