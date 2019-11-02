//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

//Given target value is a floating point.
//You are guaranteed to have only one unique value in the BST that is closest to the target.

//Example
//Given root = {1}, target = 4.428571, return 1.



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
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        
        while (root != null) {      
            if (Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }
}



//算法思路；求出 lowerBound 和 upperBound。即 小于等于 target 的最大值和 大于 target 的最小值。
//然后在两者之中去比较谁更接近，然后返回即可。

//时间复杂度为O(h)，注意使用 in-order traversal 的话，时间复杂度会是o(n)，并不是最优的。
//另外复杂度也不是 O(logn)， 因为BST 并不保证树高是 logn 的。

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null){
            return 0;
        }
        
        TreeNode lowerBound = lowerBound(root, target);
        TreeNode upperBound = upperBound(root, target);
        
        if (lowerBound == null){
            return upperBound.val;
        }
        if (upperBound == null){
            return lowerBound.val;
        }
        
        if (Math.abs(lowerBound.val - target) < Math.abs(upperBound.val - target)){
            return lowerBound.val;
        }
        else{
            return upperBound.val;
        }
        
    }
    
    
    // find the node with the largest value that smaller than target    
    private TreeNode lowerBound(TreeNode root, double target){
        if (root == null){
            return null;
        }
        
        if (root.val >= target){
            return lowerBound(root.left, target);
        }
        
        TreeNode node = lowerBound(root.right, target);
        
        if (node != null){
            return node;
        }
        
        return root;
    }
    
    
    // find the node with the smallest value that larger than or equal to target    
    private TreeNode upperBound(TreeNode root, double target){
        if (root == null){
            return null;
        }
        
        if (root.val < target){
            return upperBound(root.right, target);
        }
        
        TreeNode node = upperBound(root.left, target);
        
        if (node != null){
            return node;
        }
        
        return root;
    }    
}



