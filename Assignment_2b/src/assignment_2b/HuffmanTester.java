package assignment_2b;
/*
   TCSS 342
   Author: Raghavi Sakpal
   Tester File for HuffmanTree 
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HuffmanTester {
    
   public static void main(String[] args) {
      // String to be encoded
      String test1 = "eeyjjjj";
      String test2 = "Eerie eyes seen near lake";
      String test3 = "BACADAEAFABBAAAGAH";
      String test4 = "May the Force be with you !";
      String test5 = "Veni, vidi, vici.";
      
      try   {
         // Let's test for all test Strings 
         testingRoutine(test1);
         testingRoutine(test2);
         testingRoutine(test3);
         testingRoutine(test4);
         testingRoutine(test5);
       }
       catch ( Exception e ){
         System.out.println("Error detected: " + e.getMessage() );
       }  
   }  
   
   /*
      Method: To perform all operations from building frequency table to encoding string
      Parameter: String
      Return: void
   */
   public static void testingRoutine(String test) throws Exception  {
      // HashTables sto store frequence and encoded bits
      HashMap<Character, Integer> freqTbl = new HashMap<Character, Integer>();            // HashMap to store frequencies 
      HashMap<Character, String> encodedBitsQTbl = new HashMap<Character, String>();      // HashMap to store encoded bits using Queue
      HashMap<Character, String> encodedBitsPQTbl = new HashMap<Character, String>();     // HashMap to store encoded bits using PriorityQueue
      
      // Step1: Build Frequency Table
      frequencyTable(test, freqTbl);
      System.out.println(freqTbl);
      // These are your data structures from Assignment 1b & 2a
      Queue<TreeNode> q = new Queue<TreeNode>();                                 // Queue to build the HuffmanTree
      PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(freqTbl.size()+1);  // PriorityQueue to build the HuffmanTree
      // Step 2: Build HuffmanTree and encode bits using Queue & PriorityQueue
      encodeHuffmanTree(q,freqTbl,encodedBitsQTbl);
      encodeHuffmanTree(pq,freqTbl,encodedBitsPQTbl);
      System.out.println(encodedBitsQTbl);
      System.out.println(encodedBitsPQTbl);
      System.out.println();
      // Step 3: Encode the test string using Queue & PriorityQueue based HuffmanTree
      String encodedStrQ = encode(test,encodedBitsQTbl);
      String encodedStrPQ = encode(test,encodedBitsPQTbl);
      // Step 4: Print the output to the output.txt file
      printOutput(test,encodedStrQ,encodedStrPQ);
   } 
     
   /*
      Method: Build Frequency Table 
      Parameter: String 
      Return: void 
   */
   public static void frequencyTable(String test, HashMap<Character, Integer> freqTbl)  {
      // Loop through the String and count the frquencies of each character
      for(int i = 0; i < test.length(); i++) {
         // Check if character key exists then update the frequency count
         if(freqTbl.containsKey(test.charAt(i))) {
            freqTbl.put(test.charAt(i), freqTbl.get(test.charAt(i)) + 1);
         }
         else { // Create a new entry and assign the count to be 1
            freqTbl.put(test.charAt(i), 1);
         }
      }
   }
   
   /*
      Method: To Build the Huffman Tree using Queue and perform traversal to encode bits
      Parameter: Queue<TreeNode>, HashMap<Character,Integer>, HashMap<Character,String>
      Return: void
   */
   public static void encodeHuffmanTree(Queue<TreeNode> q, HashMap<Character,Integer> freqTbl, HashMap<Character,String> encodTbl) throws Exception {
      TreeNode rootQtree = BuildHuffmanTree.buildTreeQueue(freqTbl, q);
      BuildHuffmanTree.encodeTraversal(rootQtree,"",encodTbl);
   }
   
   /*
      Method: To Build the Huffman Tree using PriorityQueue and perform traversal to encode bits
      Parameter: PriorityQueue<TreeNode>, HashMap<Character,Integer>, HashMap<Character,String>
      Return: void
   */
   public static void encodeHuffmanTree(PriorityQueue<TreeNode> pq, HashMap<Character,Integer> freqTbl, HashMap<Character,String> encodTbl) throws Exception {
      TreeNode rootPQTree = BuildHuffmanTree.buildTreePQ(freqTbl, pq);
      BuildHuffmanTree.encodeTraversal(rootPQTree,"",encodTbl);
   }
   
   /**
    * It is a method to create encoded test String based on HuffmanTree which is created by Queue or Priority Queue. 
    * @param test
    * @param encodTbl
    * @return encode for test string
    */
   public static String encode(String test, HashMap<Character, String> encodTbl) {
      StringBuilder result = new StringBuilder();
      
      for(int i = 0; i < test.length(); i++) {
	  result.append(encodTbl.get(test.charAt(i)));
      }
      
      return result.toString();
   }
   
   /**
    * It is a method to create a text file which includes encode for each characters and 
    * calculation of how much space the encoded test string can save.
    * @param test
    * @param encodedStrQ
    * @param encodedStrPQ
    * @throws IOException
    */
   public static void printOutput(String test, String encodedStrQ, String encodedStrPQ) throws IOException   {
      BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));
      StringBuilder sbQ = new StringBuilder();
      StringBuilder sbPQ = new StringBuilder();
      
      int testLength = test.length()*8;
      String strTestLength = "" + testLength;
      int qLength = encodedStrQ.length();
      String strQLength = "" + qLength;
      double savingSpaceQ = (((test.length()*8 - encodedStrQ.length())* 100.0)/(test.length()*8));
      String result = String.format("%.2f", savingSpaceQ);
      String strSavingQ = "" + result;
      
      int pqLength = encodedStrPQ.length();
      String strPQLength = "" + pqLength;
      double savingSpacePQ = (((test.length()*8 - encodedStrPQ.length())* 100.0)/(test.length()*8));
      String result2 = String.format("%.2f", savingSpacePQ);
      String strSavingPQ = "" + result2;
      
      sbQ.append("[");
      sbQ.append(test);
      sbQ.append("] [");
      sbQ.append(strTestLength);
      sbQ.append("] \n");
      sbQ.append("[Encoded  Bitstream  using  HuffmanTree_Q:  ");
      sbQ.append(encodedStrQ);
      sbQ.append("] [");
      sbQ.append(strQLength);
      sbQ.append("] [Space Saving(%):");
      sbQ.append(strSavingQ);
      sbQ.append("] \n");
      bw.write(sbQ.toString());
      
      sbPQ.append("[");
      sbPQ.append(test);
      sbPQ.append("] [");
      sbPQ.append(strTestLength);
      sbPQ.append("] \n");
      sbPQ.append("[Encoded  Bitstream  using  HuffmanTree_PQ:  ");
      sbPQ.append(encodedStrPQ);
      sbPQ.append("] [");
      sbPQ.append(strPQLength);
      sbPQ.append("] [Space Saving(%):");
      sbPQ.append(strSavingPQ);
      sbPQ.append("] \n");
      bw.write(sbPQ.toString());
      
      bw.close();
      
   }
   
}