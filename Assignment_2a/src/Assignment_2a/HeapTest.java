package Assignment_2a;

public class HeapTest {

    public static void main(String[] args) throws Exception {
	ArrayHeap<Integer> h1 = new ArrayHeap<Integer>();
	
	h1.addElement(30);
	h1.addElement(40);
	h1.addElement(50);
	h1.addElement(70);
	h1.addElement(60);
	
	System.out.println(h1);
	
	System.out.println(h1.removeMin());
	System.out.println(h1);
	System.out.println(h1.removeMin());
	System.out.println(h1);
	System.out.println(h1.removeMin());
	System.out.println(h1);
	System.out.println(h1.removeMin());
	System.out.println(h1);
	

    }

}
