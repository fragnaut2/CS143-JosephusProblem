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
         System.out.println("==Elimination Count is: " + eliminationCount + "==");

      } catch (FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
   }
   
   public void eliminate() {
      // System.out.println("COUNT: " + eliminationCount);
      PersonNode prior = front;
      
      // Ensures prior points to node before front to avoid elimination count 1 error
      while (prior.next != front) {
         prior = prior.next;
      }
      
      // count to the elimination count
      for(int i = 1; i < eliminationCount; i++){      
            prior = front;
            front = front.next;       
      }

      // print who will be eliminated
      System.out.println(front.name + " eliminated!\n");
      
      // eliminate the person and update "front" of the circle and size
      front = front.next;
      prior.next = prior.next.next;
      size--;
   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle

      return size == 1;
   }
   
   public String toString() {
      String output = "";
      int counter = 1;
      // if there's only one person left, print them as the last survivor
      if (size == 1) {
         System.out.println();
         return "*** " + front.name + " is the last survivor! ***";
      }
      
      // if many, print survivors (watch out for infinite loop since list is circular)
      for(int i = 0 ; i < size; i++){
         output += counter + "-" + front.name + ", ";
         front = front.next;
         counter++;
      }
      output = output.substring(0, output.length() - 2);
      return output;
   }

}