//Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.

//There may exist multiple valid solutions, return any of them.

//Example
//Given [1,2,3,4,5,6,7], return
//
//       4
//     /   \
//    2     6
//   / \    / \
//  1   3  5   7



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
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
                    
        TreeNode root = convertToBST(nums, 0, nums.length);
        
        return root;         
    }
    
    private TreeNode convertToBST(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertToBST(nums, start, mid);
        root.right = convertToBST(nums, mid + 1, end);
        
        return root;
    }
}

