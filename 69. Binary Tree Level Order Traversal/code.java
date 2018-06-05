//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

//Example
//Given binary tree {3,9,20,#,#,15,7},
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//return its level order traversal as:
//  [
//    [3],
//    [9,20],
//    [15,7]
//  ]

//Challenge
//Challenge 1: Using only 1 queue to implement it.
//
//Challenge 2: Use DFS algorithm to do it.


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
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList<TreeNode>();
        
        if (root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            ArrayList<Integer> child = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                child.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(child);
        }
        return result;
    }
}

