//Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

//LintCode will print the subtree which root is your return node.
//It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

//Example
//Given a binary tree:
//  
//       1
//     /   \
//   -5     2
//   / \   /  \
//  0   2 -4  -5 
//return the node 1.


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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    
    private TreeNode curr = null;
    private int prevSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        int sum = minSum(root);
        return curr;
    }
    
    private int minSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = minSum(root.left) + minSum(root.right) + root.val;
        if (sum <= prevSum) {
            prevSum = sum;
            curr = root;
        }
        
        return sum;
    }
}

