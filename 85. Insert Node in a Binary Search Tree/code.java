//Given a binary search tree and a new tree node, insert the node into the tree. 
//You should keep the tree still be a valid binary search tree.

//You can assume there is no duplicate values in this tree + node.

//Example
//Given binary search tree as follow, after Insert node 6, the tree should be:
//
//    2             2
//   / \           / \
//  1   4   -->   1   4
//     /             / \ 
//    3             3   6

//Challenge
//Can you do it without recursion?



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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    
    
    //using recursion
    // 
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}



    //using Iteration
    //
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        
        TreeNode prev = null;
        TreeNode curr = root;
        
        while (curr != null){
            prev = curr;
            if (curr.val < node.val){
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }
        }
        
        if (prev.val < node.val){
            prev.right = node;
        }
        else {
            prev.left = node;
        }
        
        return root;
    }
    
    
