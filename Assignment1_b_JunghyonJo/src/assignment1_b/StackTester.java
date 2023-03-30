package assignment1_b;
/*
   TCSS 342
   Raghavi Sakpal
   Stack Tester 
*/

public class StackTester   {
   public static void main(String[] args) {
      DropOutStack<Integer> s = new DropOutStack<Integer>(5);
      
      try   {
         s.push(10);
         s.push(5);
         s.push(11);
         System.out.println(s);
         System.out.println(s.pop());
         s.push(23);
         s.push(15);
         System.out.println(s.peek());
         System.out.println(s); 
         s.push(-20);
         s.push(15);
         System.out.println(s.peek());
         s.push(-5); 
         System.out.println(s.pop());
         System.out.println(s.pop());
         System.out.println(s.pop());
         System.out.println(s.pop());
         System.out.println(s.peek());
         s.push(-5);
         System.out.println(s);
      }
      catch ( Exception e )
      {
         System.out.println("Error detected: " + e.getMessage() );
      }
   }
}