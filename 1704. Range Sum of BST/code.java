//Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

//The binary search tree is guaranteed to have unique values.

//Example
//Example 1:
//
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32

//Example 2:
//
//Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//Output: 23

//Notice
//The number of nodes in the tree is at most 10000.
//The final answer is guaranteed to be less than 2^31.




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
     * @param root: the root node
     * @param L: an integer
     * @param R: an integer
     * @return: the sum
     */
    // Time: O(n)
    // Space: O(height)
    public int rangeSumBST(TreeNode root, int L, int R) {
        return inorder(root, L, R);
    }
    
    private int inorder(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        if (root.val >= L && root.val <= R) {
            res += root.val;
        }
        if (root.val > L) {
            res += inorder(root.left, L, R);
        }
        if (root.val < R) {
            res += inorder(root.right, L, R);
        }
        return res;
    }    
}



