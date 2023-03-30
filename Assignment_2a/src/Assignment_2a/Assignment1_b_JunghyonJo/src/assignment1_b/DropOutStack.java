package assignment1_b;

/**
 * It is a class to create DropOutStack object.
 * The object will add a value at the first.
 * It will also delete a value which it stores at the end.
 * If user try to add more value than size of the stack, 
 * it will delete the value of the front, and store the additional value at the front.
 * It can also display its last value without deletion. 
 * @author Junghyon Jo
 *
 * @param <T>
 */
public class DropOutStack <T>{
    
    //Instance field
    private T[] dropOutStack;
    private int top;
    
    /**
     * It is a constructor to initialize instance field.
     * It will throw the exception when the parameter is less than 0.
     * @param size
     */
    DropOutStack(int size){
	if(size <= 0)
	    throw new IllegalArgumentException("Capacity cannot be 0");
	
	dropOutStack = (T[])(new Object[size]);
	
	top = -1;
    }
    
    /**
     * It is a method to add value at the stack by using array.
     * If the stack is empty, it will simply stores at index 0 of the array.
     * If the stack has some values, it will simply add at the next available spot of the array.
     * If the stack is full, it will store the value at the index 0.
     * O(1)
     * @param element
     */
    void push(T element) {
	if(isFull()) {
	    dropOutStack[0] = element;
	} else {
	    top++;
	    dropOutStack[top] = element;
	}
    }
    
    /**
     * It is a method to delete value which is stored at the end of the stack.
     * It will throw exception for situation in which the stack is empty.
     * O(1)
     * @return temp
     * @throws Exception
     */
    T pop() throws Exception {
	if(isEmpty()) {
	    throw(new Exception("No element to delete from the stack"));
	}
	
	T temp = dropOutStack[top];
	dropOutStack[top] = null;
	top--;
	
	return temp;
    }
    
    /**
     * It will display the last value of the stack on user screen.
     * It will throw exception for situation in which the stack is empty.
     * O(1)
     * @return dropOutStack[top]
     * @throws Exception
     */
    T peek() throws Exception {
	if(isEmpty()) {
	    throw(new Exception("No element in the stack"));
	}
	
	return dropOutStack[top];
    }
    
    /**
     *  It will display all the values of the stack on user screen.
     *  @return sb.toString()
     */
    public String toString() {
	StringBuilder sb = new StringBuilder();
	if (isEmpty()) {
	    sb.append("Stack is empty");
	} else {
	    sb.append(0);
	    sb.append(": ");
	    sb.append(dropOutStack[0]);
	    sb.append("\n");
	    for(int i = top; i > 0; i--) {
		sb.append(i);
		sb.append(": ");
		sb.append(dropOutStack[i]);
		sb.append("\n");
	    }
	}
	return sb.toString();
    }
    
    // Check that the stack is full or has some space to store value.
    boolean isFull() {
	if (top == dropOutStack.length - 1) {
	    return true;
	}
	return false;
    }
    
    // check that the stack already stores value or doesn't have any value.
    boolean isEmpty() {
	if (top == -1) {
	    return true;
	}
	return false;
    }
}
