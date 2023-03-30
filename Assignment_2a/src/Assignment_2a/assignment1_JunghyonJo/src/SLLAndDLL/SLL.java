package SLLAndDLL;

/**
 * It is a class to link nodes with one way which can indicate next node.
 * It will provide methods to add node at the front, at the end and between nodes with index.
 * It will also provide to find values with the index, which the node contain.
 * It will swap two nodes, so that the order of node can be changed.
 * It will also delete node with the index.
 * It has some helper methods that check node is empty or is not empty.
 * it displays elements that each node contains.  
 * @author Junghyon Jo
 *
 * @param <T>
 */
public class SLL<T> {
    
    class Node {
	
	// variable to contain value
	private T element;
	// variable to store address of next node
	Node next = null;
	
	Node(T value){
	    element = value;
	}

    }
    
    private Node front;
    private Node rear;
    private int count;
    
    /**
     * Constructor to initialize private variables
     */
    SLL(){
	front = null;
	rear = null;
	count = 0;
    }
    
    /**
     * Method a node to add at the front of single linked list.
     * O(1)
     * @param element
     */
    public void addFront(T element) {
	
	Node temp = new Node(element);
	
	if(isEmpty()) {
	    front = temp;
	    rear = temp;
	} else {
	    temp.next = front;
	    front = temp;
	}
	count++;
	
    }
    
    /**
     * Method a node to add at the end of single linked list.
     * O(1)
     * @param element
     */
    public void addRear(T element) {
	
	Node temp = new Node(element);
	
	
	if (isEmpty()) {
	    front = temp;
	    rear = temp;
	} else {
	    rear.next = temp;
	    rear = temp;
	}
	count++;
	
    }
    
    /**
     * Method to swap two nodes with two valid index by changing the addresses
     * so that the node can correctly indicate next node.
     * O(N)
     * @param firstIndex
     * @param secondIndex
     */
    public void swap(int firstIndex, int secondIndex) {
	if(firstIndex > secondIndex) {
	    throw new IllegalArgumentException("The second node should be greater than or equal to the first node");
	} else if(firstIndex < 0 || firstIndex >= count) {
	    throw new IllegalArgumentException("Invalid first Index number");
	} else if(secondIndex < 0 || secondIndex >= count) {
	    throw new IllegalArgumentException("Invalid second Index number");
	} else {
	    
	    Node firstNode = front;
	    Node secondNode = front;
	    Node prevSecondNode = front;
	    Node prevFirstNode = front;
	    for(int i = 0; i < firstIndex; i++) {
		firstNode = firstNode.next;
	    }
	    for(int i = 0; i < firstIndex-1; i++) {
		prevFirstNode = prevFirstNode.next;
	    }
	    for(int i = 0; i < secondIndex; i++) {
		secondNode = secondNode.next;
	    }
	    for(int i = 0; i < secondIndex-1; i++) {
		prevSecondNode = prevSecondNode.next;
	    }
	    Node firstTemp = firstNode.next;
	    Node secondTemp = secondNode.next;
	    Node thirdTemp = prevFirstNode.next;
	    Node fourthTemp = prevSecondNode.next;
	    
	    if(secondIndex == count-1) {
		rear = firstNode;
	    }
	    
	    if (firstIndex == 0 && secondIndex == count -1) {
		secondNode.next = firstTemp;
		prevSecondNode.next = firstNode;
		firstNode.next = null;
		front = secondNode;
	    } else if (firstIndex == 0 && secondIndex - firstIndex != 1) {
	    
		firstNode.next = secondTemp;
		secondNode.next = firstTemp;
		prevSecondNode.next = firstNode;
		front = secondNode;
	    } else if (firstIndex == 0 && secondIndex - firstIndex == 1) {
		firstNode.next = secondTemp;
		secondNode.next = firstNode;
		front = secondNode;
	    } else if(secondIndex - firstIndex == 1) {
		prevFirstNode.next = firstTemp;
		secondNode.next = thirdTemp;
		firstNode.next = secondTemp;
	    } else if(secondIndex != firstIndex) {
		prevFirstNode.next = fourthTemp;
		prevSecondNode.next = thirdTemp;
		secondNode.next = firstTemp;
		firstNode.next = secondTemp;
	    }
	}
    }
    
    /**
     * Method to find the value which the single linked list has with the index.
     * O(N)
     * @param index
     * @return current.element
     */
    public T get(int index){
	
	if(index < 0 || index >= count) {
	    throw new IllegalArgumentException("Invalid Index number to find a value");
	}else {
	
	    Node current = front;
	
	    for(int i = 0; i < index; i++) {
		current = current.next;
	    }
	
	    return current.element;
	}
    }
    
    /**
     * method to add a node at the index between two nodes.
     * O(N)
     * @param index
     * @param element
     */
    public void add(int index, T element) {
	
	if (isEmpty()) {
	    addFront(element);
	} 
	
	if(index < 0 || index > count) {
	    throw new IllegalArgumentException("Invalid Index number to add value to list");
	} else {
	    Node temp = new Node(element);
	    Node current = front;
	
	    for(int i = 0; i < index-1; i++) {
		current = current.next;
	    }
	
	    temp.next = current.next;
	    current.next = temp;
	}
	count++;
	
    }
    
    /**
     * method to delete a node with the index.
     * @param index
     * @return value which the deleted node contains.
     */
    public T delete (int index) {
	
	if(index >= 0 && index < count) {
	    if(index == 0) {
		T element = front.element;
		front = front.next;
		count--;
		return element;
	    }
	    else {
		Node current = front;
		Node previous = null;
		for(int i = 0; i < index; i++) {
		    previous = current;
		    current = current.next;
		}
		previous.next = current.next;
		count--;
		return current.element;
	    }
	}else {
	    throw new IllegalArgumentException("Invalid Index to delete");
	}
	
    }
    
    /**
     * method to check that the doubled linked list is empty or is not empty.
     * @return boolean value
     */
    public boolean isEmpty() {
	
	if(front == null) {
	    return true;
	} else {
	    return false;
	}
	
    }
    
    /**
     * Method to display the value of single linked list.
     * @return It will return each value that each node contains.
     */
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	if (count == 0) {
	    sb.append("]");
	    sb.toString();
	} else {
	    for(int i = 0; i < count-1; i++) {
		sb.append(get(i));
		sb.append(",");
	    }
	    sb.append(get(count-1));
	    sb.append("]");
	}
	return sb.toString();
    }

}
