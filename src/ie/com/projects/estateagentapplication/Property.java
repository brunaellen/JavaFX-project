package ie.com.projects.estateagentapplication;/*
Bruna Ellen Gurgel Souza - L00157216
Assignment1 (create a GUI)

Using the Property class, 
you developed for Assignment 2 in the Software Development module,
and create a GUI for the class.
*/

//main Property Class
public class Property
{  //instance variables
   private int propertyNum;
   private String street;
   private String town;
   private String county;
   private int numBeds;
   private int numBaths;
   private int numReception;
   private double price;
   private String type;
   private static int nextPropertyNum = 1;
   
   /**********Constructors:**********/
   
   //1st constructor
   public Property()
   {
      propertyNum = nextPropertyNum++;
      street = "";
      town = "";
      county = "";
      numBeds = 0;
      numBaths = 0;
      numReception = 0;
      price = 0.00;
      type = "";
   }//end of constructor

   //2nd Constructor
   public Property(String streetName, String townName, 
                  String countyName, int bedNum, int bathNum, 
                  int receptionNum, double priceValue, String propType)
   {
      propertyNum = nextPropertyNum++;
      street = streetName;
      town = townName;
      county = countyName;
      numBeds = bedNum;
      numBaths = bathNum;
      numReception = receptionNum;
      price = priceValue;
      type = propType;
   }//end of 2nd constructor
   
   /***********Methods*************/
   
   //method to return the values of an object of the Property class
   public String toString()
   {
      return "Property Number:"+propertyNum+ " \tStreet: "+street+ " \tTown: "+town+ " \tCounty: "+county+
      " \tBedrooms Number: "+numBeds+ " \tReception Rooms: "+ numReception+ " \tBathrooms Number: "+numBaths+
      " \tProperty Type: "+type +" \tPrice: "+price;
   }//end of toString method
   
   //method to get property's number
   public int getPropertyNum()
   {
    return propertyNum;
   }//end of getPropertyNum method
   
   //method to get the name of property's street
   public String getStreet()
   {
      return street;
   }//end of getStreet method
   
   //method to get the name of property's town
   public String getTown()
   {
      return town;
   }//end of getTown method
   
   //method to get the name of property's county
   public String getCounty()
   {
      return county;
   }//end of getCounty method
   
   //method to get the number of property's Bedrooms
   public int getNumBeds()
   {
      return numBeds;
   }//end of getNumBeds method
   
   //method to get the number of property's Bathrooms
   public int getNumbaths()
   {  
      return numBaths;
   }//end of getNumbaths method
   
   //method to get the number of property's Reception rooms
   public int getNumReception()
   {
      return numReception;
   }//end of getNumReception method
   
   //method to get property's price
   public double getPrice()
   {
      return price;
   }//end of getPrice method
   
   //method to get property's type
   public String getType()
   {
      return type;
   }//end of getType method
   
   //method to update a property's price
   public double updatePrice(double newPrice)
   {
      price = newPrice;
      return price;
   }//end of updatePrice method
   
   //method to calculate property's tax
   public double calculatePropertyTax()
   {
      double tax =0.00;
      boolean taxRate1 = price >=0.00 && price <=100000.00;
      boolean taxRate2 = price > 100000.00 && price <= 200000.00;
      boolean taxRate3 = price > 200000.00 && price <=500000.00;
      boolean taxRate4 = price > 500000.00 && price <=1000000.00;
      boolean taxRate5 = price > 1000000.00;
      
      if (taxRate1)
      {
         tax = 90.00;
      }
      else if (taxRate2)
      {
         tax = 225.00;
      }
      else if (taxRate3)
      {
         tax = 405.00;
      }
      else if (taxRate4)
      {
         tax = 1500.00;
      }
      else if(taxRate5)
      {
         tax = 3000.00;
      }
      return tax;
   }//end of calculatePropertyTax method
}//end of main class