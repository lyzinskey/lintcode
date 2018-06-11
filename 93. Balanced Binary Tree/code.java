//Given a binary tree, determine if it is height-balanced.

//For this problem, a height-balanced binary tree is defined as a binary tree 
//in which the depth of the two subtrees of every node never differ by more than 1.

//Example
//Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
//
//  A)  3            B)    3 
//     / \                  \
//    9  20                 20
//      /  \                / \
//     15   7              15  7
//The binary tree A is a height-balanced binary tree, but B is not.



//Divide & Conquer
//
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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    
    private int NOT_BALANCED = -1;
    
    public boolean isBalanced(TreeNode root) {
        
        return getDepth(root) != NOT_BALANCED;
    }
    
    //如果二叉树平衡就返回其高度
    //否则返回 NOT_BALANCED
    private int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        if (Math.abs(left - right) > 1){
            return NOT_BALANCED;
        }
        
        if (left == NOT_BALANCED || right == NOT_BALANCED){
            return NOT_BALANCED;
        }
        
        return Math.max(left, right) + 1;
    }
}



//more general version:
//use ResultType to store the return result
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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    
    class ResultType {
        private boolean balanced;
        private int depth;
        
        public ResultType(boolean balanced, int depth){
            this.balanced = balanced;
            this.depth = depth;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        
        return getDepth(root).balanced;
    }
    
    private ResultType getDepth(TreeNode root){
        if (root == null){
            return new ResultType(true, 0);
        }
        
        ResultType left = getDepth(root.left);
        ResultType right = getDepth(root.right);
        
        if (Math.abs(left.depth - right.depth) > 1){
            return new ResultType(false, -1);
        }
        
        if (!left.balanced || !right.balanced){
            return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }
}

