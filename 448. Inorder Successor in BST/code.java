//Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

//If the given node has no in-order successor in the tree, return null.

//Example
//Example 1:
//
//Input: {1,#,2}, node with value 1
//Output: 2
//Explanation:
//  1
//   \
//    2

//Example 2:
//
//Input: {2,1,3}, node with value 1
//Output: 2
//Explanation: 
//    2
//   / \
//  1   3
//Binary Tree Representation

//Challenge
//O(h), where h is the height of the BST.

//Notice
//It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    // Time: O(height)
    // Space: O(height)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }        

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}



