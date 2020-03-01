//Given a non-empty special binary tree consisting of nodes with the non-negative value, 
//where each node in this tree has exactly two or zero sub-node. 
//If the node has two sub-nodes, then this node's value is not bigger than its two sub-nodes.

//Given such a binary tree, 
//you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//If no such second minimum value exists, output -1 instead.

//Example
//Example 1:
//
//Input: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.

//Example 2:
//
//Input: 
//    2
//   / \
//  2   2
//
//Output: -1
//Explanation: The smallest value is 2, but there isn't any second smallest value.




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
     * @param root: the root
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
    // Time: O(n)
    // Space: O(height)
    public int findSecondMinimumValue(TreeNode root) {
        int[] array = {root.val, root.val};
        preOrder(root, array);        
        return array[0] == root.val ? -1 : array[0];
    }
    
    private void preOrder(TreeNode root, int[] array) {
        if (root == null) {
            return;
        }
        if (array[0] == array[1] || root.val != array[1] && root.val < array[0]) {
            array[0] = root.val;
        }
        preOrder(root.left, array);
        preOrder(root.right, array);
    }   
}



