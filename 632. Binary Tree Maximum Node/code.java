//Find the maximum node in a binary tree, return the node.

//Example
//Given a binary tree:
//
//       1
//     /   \
//   -5     2
//   / \   /  \
//  0   3 -4  -5 
//return the node with value 3.


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
    /*
     * @param root: the root of tree
     * @return: the max node
     */
    
    private TreeNode maxNode = new TreeNode(Integer.MIN_VALUE);
     
    public TreeNode maxNode(TreeNode root) {
        TreeNode node = getMax(root);
        return node;
    }
    
    private TreeNode getMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = getMax(root.left);
        TreeNode right = getMax(root.right);
        if (root.val >= maxNode.val) {
            maxNode = root;
        }
        
        return maxNode;
    }
}

