/*
Bruna Ellen Gurgel Souza - L00157216
Assignment2

*/


import java.util.*;
import java.io.*;


public class CovidApplications 
{
   CovidService service = new CovidService();
   public static void main(String[] args) throws IOException, ClassNotFoundException
   {
      
      List<Covid> top5Counties = service.getUserData();
      
      //create and write covid objects to a file through CovidFileDataWriter object
      CovidFileDataWriter fileDataWriter = new CovidFileDataWriter();
      fileDataWriter.writeCovidObjectsToAFile("covidData.txt", top5Counties);
      
      //read all coxvid objects from a file through CovidFileDataReader object and assign them to top5Counties variable
      CovidFileDataReader fileDataReader = new CovidFileDataReader();
      top5Counties = fileDataReader.getAllCovidCases("covidData.txt");
      
      processUserInput(service, top5Counties);
   }
   
   private static void processUserInput(CovidService service, List<Covid> top5Counties) throws IOException, ClassNotFoundException
   {
      //variables
      Scanner keyboardIn = new Scanner(System.in);
      //displayMenu
      //Declare variables
      String displayMenu;
      
      //values of displayMenu variable (concatenation +=)
      displayMenu =  "\n Menu: "; 
      displayMenu += "\n 1. View all data";
      displayMenu += "\n 2. View data by county";
      displayMenu += "\n 3. Find county with highest number of cases";
      displayMenu += "\n 4. Calculate average age";
      displayMenu += "\n 5. Find percentage number of males and percentage number of females by county";
      displayMenu += "\n 6. Write all details of the county with the lowest number of cases to new file";
      displayMenu += "\n 0. Exit System\n";
      displayMenu += "\n Enter a number: ";
      
      int choice = 0;
      //menu action:
      do 
      {
         //display menu
         System.out.println(displayMenu);
         //assign a value to choice variable
         choice = keyboardIn.nextInt();
         
         try 
         {
         //"Switch" condition to display output according to input(number chose) from the menu
            switch(choice)
               {
               case 1:
                  service.showAllCovidData(top5Counties);
                  break;
               
               case 2:
                  keyboardIn.nextLine();
                  System.out.println("Insert the county name:");
                  String countyName = keyboardIn.nextLine();
                  Covid countyDetails = service.findCovidDataByCounty(top5Counties, countyName);
                  System.out.println(countyDetails);
                  break;
               
               case 3:
                  Covid highestIncidence = service.findHighestNumCases(top5Counties);
                  System.out.println("County with highest number of cases is: " + highestIncidence.getCountyName() + 
                  ". The total Covid cases is: " +highestIncidence.getNoCases());
                  
                  break;
               
               case 4:
                  System.out.println("The average age based on the median age of each county is: " + service.calculateAverageAge(top5Counties));
                  break;
               
               case 5:
                  keyboardIn.nextLine();
                  System.out.println("Insert the county name:");
                  String nameOfCounty = keyboardIn.nextLine();
                  System.out.println(service.findMaleAndFemalePercentByCounty(top5Counties, nameOfCounty));
                  break;
                  
               case 6:
                  System.out.println(service.findLowestNumCases(top5Counties));
                  break;
            
                  
               case 0:
                  System.out.println("Exited menu!");
                  break;
                           
               default:
               System.out.println("Invalid option chosen - please re-enter");
            }//end of switch condition
         }
         catch(InputMismatchException e)
         {
            //Returns the errorMessage string of CovidValidationException object (e)
            System.out.println("\nInvalid datatype, please use the correct data type! ");
         } 

      } while (choice != 0);//close loop
   }
}