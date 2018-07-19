//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

//Bonus points if you could solve it both recursively and iteratively.

//Example
//For example, this binary tree {1,2,2,3,4,4,3} is symmetric:
//
//      1
//     / \
//    2   2
//   / \ / \
//  3  4 4  3
//
//But the following {1,2,2,#,3,#,3} is not:
//
//      1
//     / \
//    2   2
//     \   \
//     3    3



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
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
    
      return symmetric(root.left, root.right);
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
    
      return symmetric(left.left, right.right) && symmetric(left.right, right.left);    
    }
}


