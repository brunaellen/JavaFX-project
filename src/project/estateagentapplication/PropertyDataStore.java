package project.estateagentapplication;/*
Bruna Ellen Gurgel Souza - L00157216
Assignment1 (create a GUI)
*/

//import packages containing predefined classes 

import java.util.ArrayList;
import java.util.List;

//PropertyDataStore class will store all properties data

//main class
public class PropertyDataStore
{  //instance variable
   //(type: List and will store Property object)
   private List<Property> propertyList;
   
   //constructor
   public PropertyDataStore()
   {  /*instatiate an ArrayList object.
       propertyList will store all property objects*/
      propertyList = new ArrayList<Property>();
      
      //method to populate application with dummy data.
      populateData();
   }//end of constructor
   
   //method to populate application with dummy data just for test purposes.
   //the method will create 20 property objects
   private void populateData()
   {
      //populate application with dummy data.
      //create 20 property objects
      for(int i = 0; i < 20; i++) 
      {
         //declare variables and assign its values
         String street = "Street " + i;
         String town = "Town " + i;
         String[] counties = {"Sligo", "Dublin", "Donnegal", "Westmeath", "Meath", "Cork"};
         String county = counties[i%6];
         Integer numBeds = i;
         Integer numBath = i * i;
         Integer numRecep = i * i + 1;
         Double price = 1000d * i;
         String[] types = {"Detached", "Semi-Detached", "Bungalow", "Flat"};
         String propType = types[i%4];
         //declare and instantiate a Property object
         Property newProperty = new Property(street, town, county,
            numBeds, numBath, numRecep, price, propType);
            
         //add a Property object into propertyList(ArrayList)
         propertyList.add(newProperty);
      }//end of for
   }//end of populateData method
   
   //method to return all Property objects stored in propertyList
   public List<Property> getPropertyList()
   {  //return propertyList
      return propertyList;
   }//end of getPropertyList method
   
   /*method to return all properties according 
     within the property type inputted by customer*/
   public String findPropertyByType(String propertyType)
   {  //declare and assign a value to allPropertiesFound variable
      String allPropertiesFound = "";
      
      /*for loop to go through propertyList data 
      and retrieving each element of propertyList, 
      assigning them to property variable*/
      for (Property property : propertyList)
      {  /*if the property type inputted by customer 
          matches a property type stored in property variable
          then, store that matched property in allPropertiesFound variable*/
         if(propertyType.equalsIgnoreCase(property.getType()))
         {  /*store that property found into allPropertiesFound variable
            (by concatenating it).*/
            allPropertiesFound += property + "\n";
         }//end of if
      }//end of for
      //return allPropertiesFound
      return allPropertiesFound;
   }//end of findPropertyByType method
   
   //findAllPropertiesByNumberOfBeds method
   /*method to return all properties according 
     within the number of bedrooms inputted by customer*/
   public String findAllPropertiesByNumberOfBeds(int numberOfBeds)
   {  //declare a variable and assign its value
      String allPropertiesFound = "";
      
      /*for loop to go through propertyList data 
      and retrieving each element of propertyList, 
      assigning them to property variable*/
      for(Property property: propertyList)
      {  /*if the property bedrooms number inputted by customer 
          matches a property bedrooms number stored in property variable
          then, store that property into allPropertiesFound variable*/
         if(numberOfBeds == property.getNumBeds())
         {  /*store that property found in allPropertiesFound variable
            (by concatenating it).*/
            allPropertiesFound += property + "\n";  
         }//end of if
      }//end of for
      //return allPropertiesFound
      return allPropertiesFound;
   }// end of findAllPropertiesByNumberOfBeds method
   
   //findAllPropertiesByPriceRange method
   /*method to return all properties according 
   within the price range inputted by customer*/
   public String findAllPropertiesByPriceRange(double priceRange)
   {  //declare variable and assign its value
      String allPropertiesFound = "";
      
      /*for loop to go through propertyList data 
      and retrieving each element of propertyList 
      assigning them to property variable*/
      for(Property property: propertyList)
      {  /*if condition:
         if property variable contains a property 
         with price less or equal to the property price inputted by customer
         then, store that property into allPropertiesFound variable*/
         if(property.getPrice() <= priceRange)
         {  /*store that property found into allPropertiesFound variable
            (by concatenating it).*/
            allPropertiesFound += property + "\n"; 
         }//end of if
      }//end of for
      //return allPropertiesFound
      return allPropertiesFound;
   }//end of findAllPropertiesByPriceRange method
   
   
   /*method to return properties according
     with the property number inputted by a customer*/
   public Property findPropertyByNumber(int propertyNumber)
   {  /*for loop to go through propertyList data 
      and retrieving each element of propertyList 
      assigning them to property variable*/
      for(Property property: propertyList)
      {  /*if property variable contains 
          property that match customer's input
          then, return that property.*/
         if(property.getPropertyNum() == propertyNumber)
         {  //return property
            return property; 
         }//end of if
      }//end of for
      /*if the property variable doesn't contain 
       properties that match the customer's input then, 
       return null.*/
      return null;
   }//end of findPropertyByNumber method
   
   //getPropertiesForOutputmethod method
   /*method to return all property objects stored in propertyList for output*/
   public String getPropertiesForOutput()
   {  //declare variable and assign its value
      String allPropertiesAppended = "";
      
      /*for loop to go through propertyList data 
      and retrieving each element of propertyList 
      assigning them to property variable*/
      for(Property property : propertyList)
      {  /*store all properties into allPropertiesAppended variable
          (by concatenating it).*/
         allPropertiesAppended += property +"\n";
      }//end of for
      //return allPropertiesAppended
      return allPropertiesAppended;
   }//end of getPropertiesForOutputmethod method
}//end of main class