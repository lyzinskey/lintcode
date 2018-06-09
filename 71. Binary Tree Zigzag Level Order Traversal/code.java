//Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//(ie, from left to right, then right to left for the next level and alternate between).

//Example
//Given binary tree {3,9,20,#,#,15,7},
//
//      3
//     / \
//    9  20
//      /  \
//     15   7
//
//return its zigzag level order traversal as:
//
//  [
//    [3],
//    [20,9],
//    [15,7]
//  ]


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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List result = new ArrayList<TreeNode>();
        
        if (root == null){
            return result;
        }
        
        int level = 0;
        
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
            if(level % 2 == 1){
                Collections.reverse(child);            
            }
            level++;
            result.add(child);
        }
        return result;        
    }
}


