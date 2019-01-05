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
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode[] curr = new TreeNode[1];
        int[] prevSum = new int[1];
        prevSum[0] = Integer.MAX_VALUE;
        
        int sum = minSum(root, curr, prevSum);
        return curr[0];
    }
    
    private int minSum(TreeNode root, TreeNode[] curr, int[] prevSum) {
        if (root == null) {
            return 0;
        }
        
        int sum = minSum(root.left, curr, prevSum) + minSum(root.right, curr, prevSum) + root.val;
        if (sum <= prevSum[0]) {
            prevSum[0] = sum;
            curr[0] = root;
        }
        
        return sum;
    }
}



