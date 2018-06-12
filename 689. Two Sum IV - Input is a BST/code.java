//Given a binary search tree and a number n, find two numbers in the tree that sums up to n.

//Example
//Given a binary search tree:
//
//      4
//     / \
//    2   5
//   / \
//  1   3
//and a number n = 3
//return [1, 2] or [2, 1]



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
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n){
        if (root == null) {
            return null;
        }
        
        int[] result = new int[2];
        ArrayList<Integer> inorder = new ArrayList<>();
        
        inorder = inorderTraversal(root, inorder);
        
        int left = 0;
        int right = inorder.size() - 1;
        
        while (left < right){
            if (inorder.get(left) + inorder.get(right) == n){
                result[0] = inorder.get(left);
                result[1] = inorder.get(right);
                return result;
            }
            else if (inorder.get(left) + inorder.get(right) < n){
                left++;
            }
            else {
                right--;
            }
        }
        
        return null;
    }
    
    private ArrayList<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> result){
        inorder(root, result);
        return result;
    }
    
    private void inorder(TreeNode root, ArrayList<Integer> inorder){
        if (root == null){
            return;
        }
        
        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }
}

