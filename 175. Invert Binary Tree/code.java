//Invert a binary tree.Left and right subtrees exchange.

//Example
//Example 1:
//
//Input: {1,3,#}
//Output: {1,#,3}
//Explanation:
//	  1    1
//	 /  =>  \
//	3        3

//Example 2:
//
//Input: {1,2,3,#,#,4}
//Output: {1,3,2,#,4}
//Explanation: 
//	
//      1         1
//     / \       / \
//    2   3  => 3   2
//       /       \
//      4         4

//Challenge
//Do it in recursion is acceptable, can you do it without recursion?




/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        invert(root);
    }
    
    private TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }    
}



