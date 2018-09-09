//Given a binary tree, find the maximum path sum.

//The path may start and end at any node in the tree.

//Example
//Given the below binary tree:
//
//    1
//   / \
//  2   3
//return 6.



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
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        getPath(root, max);
        return max[0];
    }
    
    private int getPath(TreeNode root, int[] max) {            
        if (root == null) {
            return 0;
        }
        // step 1：以当前节点为LCA的左右子树沿着一条path延伸的最大sum 
        // (即每次要么向左要么向右)
        int left = Math.max(getPath(root.left, max), 0);
        int right = Math.max(getPath(root.right, max), 0);
        // step 2：更新max
        max[0] = Math.max(max[0], left + right + root.val);
        // step 3：same as step 1
        return Math.max(left, right) + root.val;
    }
}



