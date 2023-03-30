package Assignment_2a;
/*
   TCSS 342
   Author: Raghavi Sakpal
   Tester File for PriorityQueue 
*/

import java.util.*;

public class PQTester {
   public static void main(String[] args) {
       Integer[] list_int = {40, 20, 60, 80, 10, 30, 90, 70, 50};
       PriorityQueue<Integer> pq_int = new PriorityQueue<Integer>(5);
       String[] list_klingon = {"ghoptu", "Yej rhin", "Suvwl'", "CHEGH-chew jaj-VAM jaj-KAK", "toduj", "SuH", "yan", "Bekk"};
       PriorityQueue<String> pq_klingon = new PriorityQueue<String>();
       
       try   {
         // Let's test for Integer 
         test1(list_int,pq_int);
         test2(list_klingon,pq_klingon);
       }
       catch ( Exception e ){
         System.out.println("Error detected: " + e.getMessage() );
       }

   }
   
   public static void test1(Integer[] list,PriorityQueue<Integer> pq) throws Exception   {
      for (int i = 0; i < list.length; i++) {
	        pq.insert(list[i]);
	   }
      System.out.println(pq);
      System.out.println(pq.remove());
      System.out.println(pq.remove());
      System.out.println(pq);
      
   }
   
   public static void test2(String[] list,PriorityQueue<String> pq) throws Exception   {
      for (int i = 0; i < list.length; i++) {
	        pq.insert(list[i]);
	   }
      System.out.println(pq);
      for (int i = 1; i <= list.length; i*=2) {
	        System.out.println(pq.remove());
	   }
      System.out.println(pq); 
   }
   
}