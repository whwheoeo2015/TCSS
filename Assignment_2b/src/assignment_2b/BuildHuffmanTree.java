package assignment_2b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * It is a class to create HuffmanTree by using Queue or Priority Queue
 * It will accept HashMap class to check character and frequency of each characters.
 * It will also offers to travel HuffmanTree to encode each characters.
 *  
 * @author Junghyon Jo
 *
 */
public class BuildHuffmanTree {
    /**
     * It is a method to create HuffmanTree by using Queue.
     * @param freqTb1
     * @param q
     * @return
     * @throws Exception
     * @return TreeNode which is root of HuffmanTree
     */
    static TreeNode buildTreeQueue (HashMap<Character, Integer> freqTb1, Queue<TreeNode> q) throws Exception {
	TreeNode firstT;
	TreeNode secondT;
	TreeNode tableNode;
	TreeNode root = null;
	HuffmanTree hfRoot = null;
	
	int totalPriority;
	
	Iterator entries = freqTb1.entrySet().iterator();
	
	while(entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Character key = (Character)entry.getKey();
	    Integer value = (Integer)entry.getValue();
	    tableNode = new TreeNode(key, value);
	    tableNode = new TreeNode(key, value);
	    q.enqueue(tableNode);
	}
	
	boolean operater = true;
	
	while(operater) {
	    
	    if(q.getSize() > 2) {
		firstT = q.dequeue();
		secondT = q.dequeue();
		totalPriority = firstT.priority + secondT.priority;
		root = new TreeNode(totalPriority);
		
	    	root.left = firstT;
	    	root.right = secondT;
		
		q.enqueue(root);
	    } else if(q.getSize() == 2){
		firstT = q.dequeue();
		secondT = q.dequeue();
		totalPriority = firstT.priority + secondT.priority;
		root = new TreeNode(totalPriority);
		
	    	root.left = firstT;
	    	root.right = secondT;
		
		
		q.enqueue(root);
		
	    } else if(q.getSize() == 1) {
		root = q.dequeue();
		hfRoot = new HuffmanTree(root.priority, root.left, root.right);
		hfRoot.getRoot().priority = root.priority;
		operater = false;
	    }
	}
	
	return hfRoot.getRoot();
    }
    
    /**
     * It is a method to create HuffmanTree by using Priority Queue.
     * @param freqTb1
     * @param pq
     * @return
     * @throws Exception
     * @return TreeNode which is root of HuffmanTree
     */
    static TreeNode buildTreePQ (HashMap<Character, Integer> freqTb1, PriorityQueue<TreeNode> pq) throws Exception {
	TreeNode firstT;
	TreeNode secondT;
	TreeNode tableNode;
	TreeNode root = null;
	HuffmanTree hfRoot = null;
	
	int totalPriority;
	
	Iterator entries = freqTb1.entrySet().iterator();
	
	while(entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Character key = (Character)entry.getKey();
	    Integer value = (Integer)entry.getValue();
	    tableNode = new TreeNode(key, value);
	    tableNode = new TreeNode(key, value);
	    pq.insert(tableNode);
	}
	
	while(pq.getSize() != 1) {
	    firstT = pq.remove();
	    secondT = pq.remove();
	    totalPriority = firstT.priority + secondT.priority;
	    hfRoot = new HuffmanTree(totalPriority, firstT, secondT);
	    	
	    pq.insert(hfRoot.getRoot());
	}
	
	return pq.remove();
    }
    
    /**
     * It is method to encode each character based on HuffmanTree which is created by Queue or Priority Queue.
     * @param root
     * @param code
     * @param encodTbl
     */
    static void encodeTraversal(TreeNode  root,  String  code, 
	    HashMap<Character,String>  encodTbl) {
	
	    if (root.element != null)
		encodTbl.put(root.element, code);
	    else {
		encodeTraversal(root.left, code + "0", encodTbl);
		encodeTraversal(root.right, code + "1", encodTbl);
	    }
    }
    
}
