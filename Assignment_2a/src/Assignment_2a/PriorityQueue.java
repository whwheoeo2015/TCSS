package Assignment_2a;

/**
 * It is a class that create priorityQueue by extending ArrayHeap.
 * It will add an element by using addElement() method in ArrayHeap.
 * If parent has bigger value than the new element, swapping the two values happens.
 * After the swapping, the new element will be parent, and old parents will be child.
 * It will remove element by using removMin() method in ArrayHeap.
 * It will remove the smallest value sequentially, because the smallest value has the greatest priority. 
 * @author Junghyon Jo
 *
 * @param <T>
 */
public class PriorityQueue <T extends Comparable<T>> extends ArrayHeap<T> {
    
    // Default constructor by using default constructor of ArrayHeap class.
    PriorityQueue(){
	super();
    }
    
    /**
     * It is a constructor to create PriorityQueue with user input size.
     * It uses the constructor of ArrayHeap class.
     * @param capacity
     */
    PriorityQueue(int capacity){
	super(capacity);
    }
    
    /**
     * It will add new element to PriorityQueue by using properties of ArrayHeap class.
     * @param element
     */
    void insert (T element) {
	super.addElement(element);
    }
    
    /**
     * It will remove the smallest value of PriorityQueue by using properties of ArrayHeap class,
     * because the smallest value has the greatest priority.
     * @return temp
     * @throws Exception
     */
    T remove() throws Exception {
	T temp = super.removeMin();
	return temp;
    }
    
    /**
     *  The highest priority will be displayed first.
     *  Since the smallest value has the greatest priority, it displays the smallest value sequentially.
     */
    public String toString() {
	if(super.isEmpty()) {
	    String s1 = "PriorityQueue is empty";
	    return s1;
	} else {
	    return super.toString();
	}
    }
    
    public static void main(String[] args) throws Exception {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	pq.insert(4);
	pq.insert(2);
	pq.insert(2);
	pq.insert(1);
	pq.insert(8);
	pq.insert(1);
	pq.insert(1);
	pq.insert(1);
	pq.insert(1);
	pq.insert(2);
	
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());
	System.out.println(pq.remove());
	System.out.println(pq.toString());

    }
}
