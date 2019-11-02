//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

//According to the definition of LCA on Wikipedia: 
//“The lowest common ancestor is defined between two nodes p and q 
//as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

//All of the nodes' values will be unique.
//p and q are different and both values will exist in the BST.
//Have you met this question in a real interview?  

//Example
//Example 1:
//
//Input: 
//{6,2,8,0,4,7,9,#,#,3,5}
//2
//8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.

//Example 2:
//
//Input: 
//{6,2,8,0,4,7,9,#,#,3,5}
//2
//4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition




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
     * @param root: root of the tree
     * @param p: the node p
     * @param q: the node q
     * @return: find the LCA of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}



