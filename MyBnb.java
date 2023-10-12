/**
   Description: A class whic uses and manages an ArrayList of RentalRoom objects.
               This class has a constructor, int method numberOfRooms(int beds),
               String method chooseRoom(int minBeds), int method numberOfStaffNeeded().
*/

import java.io.*;
import java.util.*;

public class MyBnb{

    private List<RentalRoom> roomsList = new ArrayList<>();
    private boolean fileStat = true;

   /**
      Constructor to initialize the file name from which data is loaded.
      @param filename the filename from which the data is loaded.
   */
   public MyBnb(String filename) {
      try{
         File fileIn = new File(filename);
         Scanner sc = new Scanner(fileIn);
      
         while (sc.hasNextLine()){
            String line = sc.nextLine().trim();
            String id = line.substring(0, line.indexOf(" "));
            int beds = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            
            RentalRoom room = new RentalRoom(id, beds);    
            roomsList.add(room);
         }
         
         sc.close();
      } catch(FileNotFoundException e){
         System.out.println(e);
         fileStat = false;
      }
   }
   
   /**
      A method which returns the number of rooms with the number of beds matching the 
      value given as argument.
      @param the numbers of beds in a room.
      @return the number of rooms with the number of beds matching the arguement's value.
   */
    public int numberOfRooms(int beds){
      int total = 0;
      for(RentalRoom room:roomsList){
         if(room.getNumBeds() == beds){
            total += 1;
         }
      }
      return total;
    }
    
    /**
       A method which chooses the first available room with at least the number of beds 
       specified as argument. The room ID is returned and the room should be no longer 
       available for renting. If no suitable room is available, the method returns “NONE”.
       @param minBeds the first available room with at least the number of beds specified as argument
       @return the room id of the available room if none found then "NONE" is returned.
    */
    public String chooseRoom(int minBeds){
      for(RentalRoom room:roomsList){
         if(room.isAvailable()){
            if(room.getNumBeds() >= minBeds){
               room.setAvailable(false);
               return room.getID();
            }
         }

      }
      return "NONE";
    }
    
    /**
      A which returns the number of staff members needed to clean the rooms that are 
      currently occupied (not available).
      @return the number of staff needed to clean the rooms that are occupied.
    */
    public int numberOfStaffNeeded(){
      int numberOfStaffs = 0;
      int numOfOccupiedOne = 0;
      for(RentalRoom room:roomsList){
         if(!room.isAvailable()){
            if(room.getNumBeds() >= 3){
               numberOfStaffs += 2;
            }
            else{
               numOfOccupiedOne += 1;
            }
         }
      }
      numberOfStaffs += numOfOccupiedOne/3;
      
      if((numOfOccupiedOne/3.0) > 0){
         numberOfStaffs += 1;
      }
      
      return numberOfStaffs;
    }

/**
   A method to get if the file has encountered FileNotFoundException or not.
   @return true if exception does not exist false if it does
*/
   public boolean getFileStat(){
      return fileStat;
    }

}
