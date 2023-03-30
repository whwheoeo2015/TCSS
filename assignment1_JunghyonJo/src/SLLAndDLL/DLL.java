package SLLAndDLL;

import SLLAndDLL.SLL.Node;
/**
 * It is a class to link nodes with two ways which can indicate next node and can indicate previous node.
 * It will provide methods to add node at the front, at the end and between nodes with index.
 * It will also provide to find values with the index, which the node contain.
 * It will swap two nodes, so that the order of node can be changed.
 * It will also delete node with the index.
 * It has some helper methods that check node is empty and it will display elements that each node contains.
 * @author Junghyon Jo
 *
 * @param <T>
 */
public class DLL<T> {
    
    /**
     * It is the inner class to create nodes.
     *
     */
    class Node {
	
	// variable to contain value
	private T element;
	// variable to store address of next node
	private Node next = null;
	// variable to store address of previous node
	private Node previous = null;
	 
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
    DLL(){
	front = null;
	rear = null;
	count = 0;
    }
    
    /**
     * Method a node to add at the front of doubled linked list.
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
	    front.previous = temp;
	    front = temp;
	}
	count++;
	
    }
    
    /**
     * Method a node to add at the end of doubled linked list.
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
	    temp.previous= rear;
	    rear = temp;
	}
	count++;
	
    }
    
    /**
     * Method to find the value which the doubled linked list has with the index.
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
	
	if (isEmpty() || index == 0) {
	    addFront(element);
	} else if(index == count) {
	    addRear(element);
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
	    temp.previous = current;
	    current.next = temp;
	    temp.next.previous = temp;
	    count++;
	}
	
    }
    
    /**
     * Method to swap two nodes with two valid index by changing the addresses
     * so that the node can correctly indicate next node and previous node.
     * O(N)
     * @param firstIndex
     * @param secondIndex
     */
    public void swap (int firstIndex, int secondIndex) {
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
	    Node firstNextTemp = firstNode.next;
	    Node firstPreTemp = firstNode.previous;
	    Node secondNextTemp = secondNode.next;
	    Node secondPreTemp = secondNode.previous;
	    Node thirdNextTemp = prevFirstNode.next;
	    Node fourthNextTemp = prevSecondNode.next;
	    if(secondIndex == count-1) {
		rear = firstNode;
	    }
	    
	    if(firstIndex == 0 && secondIndex == count -1) {
		front = secondNode;
		secondNode.next = firstNextTemp;
		secondNode.previous.next = firstNode;
		secondNode.previous = null;
		firstNode.next.previous = secondNode;
		firstNode.next = null;
		firstNode.previous = secondPreTemp;
	    }else if (firstIndex == 0 && secondIndex - firstIndex != 1) {
		firstNode.next.previous = secondNode;
		secondNode.next.previous = firstNode;
		firstNode.next = secondNextTemp;
		firstNode.previous = secondPreTemp;
		secondNode.next = firstNextTemp;
		secondNode.previous = null;
		prevSecondNode.next = firstNode;
		front = secondNode;
	    } else if (firstIndex == 0 && secondIndex - firstIndex == 1) {
		firstNode.next.previous = secondNode;
		secondNode.next.previous = secondPreTemp;
		firstNode.next = secondNextTemp;
		firstNode.previous = secondNode;
		secondNode.next = firstNode;
		secondNode.previous = null;
		front = secondNode;
	    } else if(secondIndex == count - 1 && secondIndex - firstIndex != 1){
		firstNode.previous  = secondPreTemp;
		firstNode.next.previous = secondNode;
		secondNode.previous.next = thirdNextTemp;
		secondNode.previous = firstPreTemp;
		prevFirstNode.next = fourthNextTemp;
		secondNode.next = firstNextTemp;
		firstNode.next = null;
	    } else if(secondIndex == count - 1 && secondIndex - firstIndex == 1){
		firstNode.previous  = firstNextTemp;
		firstNode.next.previous = secondNode;
		secondNode.previous.next = thirdNextTemp;
		secondNode.previous = firstPreTemp;
		prevFirstNode.next = fourthNextTemp;
		firstNode.next = null;
	    }else if(secondIndex - firstIndex == 1) {
		secondNode.next.previous = secondPreTemp;
		prevFirstNode.next = firstNextTemp;
		secondNode.next = thirdNextTemp;
		secondNode.previous = firstPreTemp;
		firstNode.next = secondNextTemp;
		firstNode.previous = secondNode;
	    } else if (firstIndex != secondIndex){
		secondNode.previous.previous = secondNextTemp.previous;
		secondNode.next.previous = firstNode;
		firstNode.previous  = secondPreTemp;
		secondNode.previous = firstPreTemp;
		prevFirstNode.next = fourthNextTemp;
		prevSecondNode.next = thirdNextTemp;
		secondNode.next = firstNextTemp;
		firstNode.next = secondNextTemp;
	    }
	}
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
		front.previous = null;
		count--;
		return element;
	    } else if(index == count -1){
		T element = rear.element;
		rear = rear.previous;
		rear.next = null;
		count--;
		return element;
	    } else {
		Node current = front;
		
		for(int i = 0; i < index; i++) {
		    current = current.next;
		}
		
		Node previous = current.previous;
		Node next = current.next;
		
		previous.next = current.next;
		next.previous = current.previous;
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
     * Method to display the value of double linked list.
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


