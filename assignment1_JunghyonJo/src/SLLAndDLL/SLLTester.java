package SLLAndDLL;

/*   TCSS 342
   Raghavi Sakpal
   SLL Tester 
*/
import java.util.*;

public class SLLTester  {
   public static void main(String[] args)  {
      SLL<Integer> list = new SLL<Integer>();
      
      try   {
         // Add few elements
         list.addFront(100);
         list.addRear(15);
         list.addRear(-30);
         list.addFront(30);
         list.add(2,-20);
         System.out.println("Element at index 1 of SLL is: " + list.get(1));
         System.out.println("Delete element at index 3: " + list.delete(3));
         System.out.println("Element at index 3 of SLL is: " + list.get(3));
         list.swap(0,2);
         list.addFront(50);
         list.swap(2,3);
         System.out.println(list);
      }
      catch ( Exception e )
      {
         System.out.println("Error detected: " + e.getMessage() );
      }
   }  
}





