//Given a binary tree, you need to compute the length of the diameter of the tree. 
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
//This path may or may not pass through the root.

//Example
//Example 1:
//
//Given a binary tree 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

//Example 2:
//
//Input:[2,3,#,1]
//Output:2
//
//Explanation:
//      2
//    /
//   3
// /
//1

//Notice
//The length of path between two nodes is represented by the number of edges between them.




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
     * @param root: a root of binary tree
     * @return: return a integer
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = {0};
        maxDepth(root, result);
        return result[0];
    }
    
    private int maxDepth(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left, result);
        int right = maxDepth(root.right, result);
        
        result[0] = Math.max(result[0], left + right);
        
        return Math.max(left, right) + 1;
    }
}



