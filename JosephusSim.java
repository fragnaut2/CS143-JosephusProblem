import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode front;      // a PersonNode pointer that tracks first node in the list
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       

   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         Random rand = new Random();
         
         // make the ring circular by attaching last node's next to front
         // PersonNode first = null;
         PersonNode previous = null;

         size = 0;

         while(file.hasNextLine()){
            String line = file.nextLine();

            PersonNode current = new PersonNode(line);
            if(previous == null){
               front = current;
            }
            else {
               previous.next = current;
            }

            previous = current;
            size++;

         }

         previous.next = front;
         
         // generate, print, and save the random elimination count
         eliminationCount = rand.nextInt(1, size / 2);

      } catch (FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
   }
   
   public void eliminate() {
      // count to the elimination count
      
      // print who will be eliminated
      
      // eliminate the person and update "front" of the circle and size

   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return false;
   }
   
   public String toString() {
      String output = "";
      int counter = 1;
      // if there's only one person left, print them as the last survivor
      
      // if many, print survivors (watch out for infinite loop since list is circular)
      for(int i = 0 ; i < size; i++){
         output += counter + "-" + front.name + ", ";
         front = front.next;
         counter++;
      }
      return output;
   }

}