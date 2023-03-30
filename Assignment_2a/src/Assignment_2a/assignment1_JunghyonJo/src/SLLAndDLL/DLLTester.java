package SLLAndDLL;
/*
   TCSS 342
   Raghavi Sakpal
   SLL Tester 
*/
import java.util.*;

public class DLLTester  {
   public static void main(String[] args)  {
      DLL<String> list = new DLL<String>();
      
      try   {
         // Add few elements
         list.addFront("Java");
         list.addRear("Python");
         list.addRear("C++");
         list.addFront("C");
         list.add(3,"ML");
         System.out.println(list);
         list.swap(0,4);
         System.out.println("Element at index 0 of SLL is: " + list.get(0));
         System.out.println("Delete element at index 4: " + list.delete(4));
         list.add(3,"JavaScript");
         System.out.println("Element at index 3 of SLL is: " + list.get(3));
         list.swap(1,1);
         System.out.println(list);
      }
      catch ( Exception e )
      {
         System.out.println("Error detected: " + e.getMessage() );
      }
   }  
}





