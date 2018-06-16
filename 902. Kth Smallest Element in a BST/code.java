//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

//Example
//Given root = {1,#,2}, k = 2, return 2.

//Challenge
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
//How would you optimize the kthSmallest routine?



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
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    
     
    //使用 Binary Search Tree Iterator 的方式（可以参考 binary search tree iterator 那个题）
    //用 stack，从第一个点开始，走 k-1 步，就是第 k 个点了。
    //时间复杂度是 O(h + k)O(h+k) h 是树的高度。     
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        TreeNode curr = null;
        
        for (int i = 0; i < k; i++) {
            curr = stack.peek();
            TreeNode node = stack.peek();
            
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            }
            else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return curr.val;
    }
}



    //时间复杂度 O(n) 最好最坏都是。
    //算法思想类似于 Quick Select。
    //这个算法的好处是，如果多次查询的话，给每个节点统计儿子个数这个过程只需要做一次。查询可以很快。
    
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> numOfChildren = new HashMap<>();
        countNodes(root, numOfChildren);
        return quickSelectOnTree(root, k, numOfChildren);
    }
    
    private int countNodes(TreeNode root, Map<TreeNode, Integer> numOfChildren) {
        if (root == null) {
            return 0;
        }
        
        int left = countNodes(root.left, numOfChildren);
        int right = countNodes(root.right, numOfChildren);
        numOfChildren.put(root, left + right + 1);
        return left + right + 1;
    }
    
    private int quickSelectOnTree(TreeNode root, int k, Map<TreeNode, Integer> numOfChildren) {
        if (root == null) {
            return -1;
        }
        
        int left = root.left == null ? 0 : numOfChildren.get(root.left);
        if (left >= k) {
            return quickSelectOnTree(root.left, k, numOfChildren);
        }
        if (left + 1 == k) {
            return root.val;
        }
        
        return quickSelectOnTree(root.right, k - left - 1, numOfChildren);
    }
    
    
