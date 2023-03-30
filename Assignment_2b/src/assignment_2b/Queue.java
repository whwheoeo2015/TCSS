package assignment_2b;

/**
 * It is a class to create Queue object.
 * The queue will add a value at the end.
 * It will also delete a value which it stores at the first.
 * It can also display its first value without deletion. 
 * @author Junghyon Jo
 *
 * @param <T>
 */
public class Queue <T>{
    
    //Instance field
    private SLL<T> queue;
    private int size;
    
    //Constructor to initialize instance field.
    Queue() {
	queue = new SLL();
    }
    
    /**
     * It is a method to add value at the queue by using methods from SLL class.
     * If the queue is empty, it will simply add at the front.
     * If the queue has some values, it will simply add at the end of the queue.
     * O(1)
     * @param element
     */
    void enqueue(T element) {
	if(queue.isEmpty()) {
	    queue.addFront(element);
	    size++;
	} else {
	    queue.addRear(element);
	    size++;
	}
	
    }
    
    /**
     * It is a method to delete value which is stored at the first of the queue.
     * It will throw exception for situation in which the queue is empty.
     * O(1)
     * @return tempElement
     * @throws Exception
     */
    T dequeue() throws Exception {
	if(queue.isEmpty()) {
	    throw(new Exception("No element to delete from the queue"));
	    
	} else {
	    SLL<T>.Node temp = queue.getFront();
	    T tempElement = queue.getFrontElement();
	    queue.setCount(queue.getCount()-1);
	    queue.setFront(temp.next);
	    size--;
	    return tempElement;
	}
    }
    
    /**
     * It will display the first value of the queue on user screen.
     * It will throw exception for situation in which the queue is empty.
     * O(1)
     * @return queue.getFrontElement()
     * @throws Exception
     */
    T peek() throws Exception {
	if(queue.isEmpty()) {
	    throw(new Exception("No element in the queue"));
	}
	
	return queue.getFrontElement();
    }
    
    public int getSize() {
	return size;
    }
    
    /**
     *  It will display all the values of the queue on user screen.
     *  @return sb.toString()
     */
    public String toString() {
	StringBuilder sb = new StringBuilder();
	if (queue.isEmpty()) {
	    sb.append("Queue is empty");
	} else {
	    
	    sb.append("[");
	    if (queue.getCount() - 1 == 0) {
		sb.append(queue.getFrontElement());
	    } else {
		for(int i = 0; i < queue.getCount()-1; i++) {
		    sb.append(queue.get(i));
		    sb.append(",");
		    sb.append(" ");
		}
		sb.append(queue.get(queue.getCount()-1));
	    }
	    sb.append("]");
	}
	return sb.toString();
    }
}
