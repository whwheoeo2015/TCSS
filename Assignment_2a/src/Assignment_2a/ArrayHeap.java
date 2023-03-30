package Assignment_2a;

import java.util.Arrays;
/**
 * It is a class that create MinHeap by using array data structure.
 * It will add an element by comparing parents of the new element.
 * If parent has bigger value than the new element, swapping the two values happens.
 * After the swapping, the new element will be parent, and old parents will be child.
 * It will remove the smallest value sequentially. 
 * @author Junghyon Jo
 *
 * @param <T>
 */
public class ArrayHeap <T extends Comparable<T>> {
    // Initial size for heap
    public static final int INITIAL_SIZE = 10;
    
    // Instance field
    private T[] heap;
    private int count = 0;
    
    // Default constructor. It will create heap with size 10.
    ArrayHeap(){
	heap = (T[])(new Comparable[INITIAL_SIZE]);
    }
    
    // Constructor to create heap with user input.
    ArrayHeap(int capacity) {
	heap = (T[])(new Comparable[capacity]);
    }
    
    /**
     * It will add element to the heap.
     * If overFlow happens, it will resize the heap to have more values.
     * If the heap is empty, it will add the value at first index of heap.
     * It stores the value in the last index of the heap and compares the new value with the parent value.
     * If the parent value is small, the swap does not occur, and 
     * if the new value is less than the parent value, replace the two values with each other.
     * @param object
     */
    void addElement(T object) {
	if(isFull()) {
	    reSize();
	}
	
	heap[count + 1] = object;
	int current = count+1;
	
	while(current > 1 && heap[current].compareTo(heap[(current)/2]) < 0) {
	    swap(heap[current],heap[(current)/2], current, (current)/2);
	    current = (current)/2;
	}
	
	count++;
	
    }
    
    /**
     * It swaps the first and last index values of the heap, 
     * and then compares the last index value with the parent's value to distinguish which is smaller.
     * It swaps until the parent's value is larger to move the value of the last index to the index where it should be stored.
     * If no parent's value is less than that last value, the last value is the smallest value in the heap and is located at index 0.
     * It returns the value at index 0, because it is the smallest value of the heap.
     * @return result
     * @throws Exception
     */
    T removeMin() throws Exception {
	if(isEmpty()) {
	    throw(new Exception("The heap is empty!"));
	}
	T result = heap[1];
	swap(heap[1], heap[count], 1, count);
	int current = 1;
	int left = current*2;
	int right = current*2 + 1;
	
	while(	left < count  &&
		right < count  &&
		( heap[current].compareTo(heap[left]) > 0 ||
		heap[current].compareTo(heap[right]) > 0 )
		) {
	    
	    if(heap[left].compareTo(heap[right]) < 0) {
		swap(heap[current],heap[left], current, left);
		current = current * 2;
		left = current*2;
		right = current*2 + 1;
	    } else if(heap[right].compareTo(heap[left]) < 0) {
		swap(heap[current],heap[right], current, right);
		current = current* 2 + 1;
		left = current*2;
		right = current*2 + 1;
	    } else if(heap[right].compareTo(heap[left]) == 0) {
		swap(heap[current],heap[left], current, left);
		current = current * 2;
		left = current*2;
		right = current*2 + 1;
	    }
	}
	if(current == (count-1)/2) {
	    if(heap[current].compareTo(heap[left]) > 0) {
		swap(heap[current],heap[left], current, left);
		current = current * 2;
		left = current*2;
		right = current*2 + 1;
	    }
	}
	count--;
	return result;
    }
    
    /**
     *  It is a method to swap two values of the heap.
     * @param firstValue
     * @param secondValue
     * @param firstLocation
     * @param secondLocation
     */
    private void swap(T firstValue, T secondValue, int firstLocation, int secondLocation) {
	heap[firstLocation] = secondValue;
	heap[secondLocation] = firstValue;
    }
    
    /**
     *  It is a method to display all the elements of the heap.
     *  It displays the lowest value of the heap sequentially. 
     */
    public String toString() {
	StringBuilder sb = new StringBuilder();
	if (isEmpty()) {
	    sb.append("[]");
	} else {
	    sb.append("[");
	    for(int i = 1; i < count; i++) {
		sb.append(heap[i]);
		sb.append(", ");
	    }
	    sb.append(heap[count]);
	    sb.append("]");
	}
	return sb.toString();
    }
    
    /**
     *  It is a method to resize the heap.
     */
    private void reSize() {
	heap = Arrays.copyOf(heap, heap.length * 2);
    }
    
    /**
     * It is a method to check that the heap has empty index to store value.
     * @return boolean value
     */
    boolean isFull() {
	if(count + 1 == heap.length) {
	    return true;
	}
	return false;
    }
    
    /**
     * It is a method to check that the heap has any stored value.
     * @return boolean value
     */
    boolean isEmpty() {
	if(count == 0) {
	    return true;
	}
	return false;
    }
}
