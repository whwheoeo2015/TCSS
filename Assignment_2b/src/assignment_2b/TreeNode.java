package assignment_2b;

/**
 * It is a class to create TreeNode.
 * It will contain an element, and each TreeNode will have its own priority.
 * It will have address of left TreeNode and Right TreeNode.
 * @author Owner
 *
 */
public class TreeNode implements Comparable<TreeNode> {
    
    protected Character element;
    protected int priority;
    protected TreeNode left;
    protected TreeNode right;
    
    /**
     * It is a constructor by accepting priority as a parameter.
     * @param priorityValue
     */
    
    TreeNode(int priorityValue){
	priority = priorityValue;
	element = null;
	left = null;
	right = null;
    }
    
    /**
     * It is a constructor by accepting priority and value as parameters.
     * @param priorityValue
     */
    TreeNode(Character elementValue, int priorityValue){
	priority = priorityValue;
	element = elementValue;
	left = null;
	right = null;
    }
    
    
    /**
     * It is a method to compare priority.
     * It will return 1 if current TreeNode has higher priority than Other.priority.
     * It will return -1 if current TreeNode has the same priority as Other.priority.
     * It will return -1 if current TreeNode has less priority than Other.priority.
     * @return 1, 0, -1
     */
    public int compareTo (TreeNode other) {
	if(priority > other.priority) {
	    return 1;
	}  else {
	    return -1;
	}
    }
}
