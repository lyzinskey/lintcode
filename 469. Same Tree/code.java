//Check if two binary trees are identical. 
//Identical means the two binary trees have the same structure and every identical position has the same value.

//Example
//      1             1
//     / \           / \
//    2   2   and   2   2
//   /             /
//  4             4
//  are identical.
//
//      1             1
//     / \           / \
//    2   3   and   2   3
//   /               \
//  4                 4
//  are not identical.



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
    public boolean isIdentical(TreeNode a, TreeNode b) {
        return symmetric(a, b);
    }
  
    private boolean symmetric(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
        return true;
      }
    
      if (left == null || right == null) {
        return false;
      }
    
      if (left.val != right.val) {
        return false;
      }    
    
      return symmetric(left.left, right.left) && symmetric(left.right, right.right);    
    }    
}


