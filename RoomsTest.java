/**
   Program to test the basic functionality of the MyBnb class.
*/

import java.util.Scanner;
import java.io.*;

public class RoomsTest
{
   public static void main(String [] args)
   {
      boolean exit = false;
      int choiceSecond, choice;
      Scanner in = new Scanner(System.in);
      
      System.out.print("Enter your file path: ");
      String filePath = in.nextLine();
         
      MyBnb bnb = new MyBnb(filePath);
      
      if(bnb.getFileStat() == true){
      
         while(exit != true){
            System.out.println("\n+=============================+");
            System.out.println("|          USER MENU          |");
            System.out.println("+=============================+");
            System.out.println("|                             |");
            System.out.println("| 1. Book a room              |");
            System.out.println("| 2. Number of staff needed   |");
            System.out.println("|    to clean the BnB         |");       
            System.out.println("| 3. Number of rooms matching |");
            System.out.println("|    rooms                    |");
            System.out.println("| 4. Exit                     |");      
            System.out.println("|                             |");
            System.out.println("+=============================+");
               
            System.out.print("Enter your choice in number: ");
            choice = in.nextInt();
                  
            switch (choice) {
               case 1:
                  System.out.print("Minimum number of beds: ");
                  choiceSecond = in.nextInt();
                  System.out.println("The booked room: " + bnb.chooseRoom(choiceSecond));
                     
                  System.out.println("\nPress Enter to Continue");
                  in.nextLine();
                  in.nextLine();
                  break;
               case 2:
                  System.out.println("Number of staffs needed: " + bnb.numberOfStaffNeeded());
                  System.out.println("\nPress Enter to Continue");
                  in.nextLine();
                  in.nextLine();
                  break;
               case 3:
                  System.out.println("Number of staffs needed: " + bnb.numberOfStaffNeeded());
                  System.out.println("\nPress Enter to Continue");
                  in.nextLine();
                  in.nextLine();
                  break;
               case 4:
                  System.out.println("\nAre you sure? Press Enter to Exit");
                  in.nextLine();
                  in.nextLine();
                  exit = true;
                  break;
            } 
         }
         in.close();
      }
      System.out.println("Thank you for using the application.");
   }
}
