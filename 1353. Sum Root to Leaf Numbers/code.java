//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

//An example is the root-to-leaf path 1->2->3 which represents the number 123.

//Find the total sum of all root-to-leaf numbers.

//Example
//Example:
//
//Input: {1,2,3}
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.

//Example 2:
//
//Input: {4,9,0,5,1}
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026

//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026.

//Notice
//A leaf is a node with no children.




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
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    // Time: O(n)
    // Space: O(height)
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int path) {
        if (root == null) {
            return;
        }

        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += path;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }
}



