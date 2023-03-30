package assignment1_b;
/*
   TCSS 342
   Raghavi Sakpal
   Queue Tester 
*/


public class QueueTester   {
   public static void main(String[] args) {
      Queue<Character> q = new Queue<Character>();
      
      try   {
         q.enqueue('a');
         System.out.println(q.dequeue());
         System.out.println(q);
         
         q.enqueue('b');
         q.enqueue('c');
         System.out.println(q);
         
         System.out.println(q.dequeue());
         q.enqueue('p');
         q.enqueue('a');
         System.out.println(q.peek());
         System.out.println(q.dequeue());
         System.out.println(q);
      }
      catch ( Exception e )
      {
         System.out.println("Error detected: " + e.getMessage() );
      }
   }
}