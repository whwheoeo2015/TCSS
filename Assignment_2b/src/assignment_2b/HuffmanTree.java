package assignment_2b;

/**
 *  It is a class to create HuffmanTree by using priority, and assigning left TreeNode and right TreeNode.
 * @author Junghyon Jo
 *
 */
public class HuffmanTree {
    
    private TreeNode root;
    
    /**
     * It is a constructor of HuffmanTree.
     * It will create new HuffmanTree by assigning priority, left TreeNode and right TreeNode.
     * @param priority
     * @param left
     * @param right
     */
    HuffmanTree(int priority, TreeNode left, TreeNode right){
	root = new TreeNode(priority);
	root.left = left;
	root.right = right;
    }
    
    /**
     * It is a method to access to root, which is a TreeNode.
     * @return root
     */
    TreeNode getRoot() {
	return root;
    }

}
