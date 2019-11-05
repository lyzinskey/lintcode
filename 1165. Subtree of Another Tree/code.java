//Given two non-empty binary trees s and t, 
//check whether tree t has exactly the same structure and node values with a subtree of s. 
//A subtree of s is a tree consists of a node in s and all of this node's descendants. 
//The tree s could also be considered as a subtree of itself.

//Example
//Example 1:
//
//Given tree s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//
//Given tree t:
//   4 
//  / \
// 1   2
//Return true, because t has the same structure and node values with a subtree of s.

//Example 2:
//
//Given tree s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//
//Given tree t:
//   4
//  / \
// 1   2
//Return false.




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
     * @param s: the s' root
     * @param t: the t' root
     * @return: whether tree t has exactly the same structure and node values with a subtree of s
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return traverse(s, t);
    }
    
    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equal(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    
    private boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }
}



