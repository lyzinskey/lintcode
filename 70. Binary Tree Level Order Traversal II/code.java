//Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
//(ie, from left to right, level by level from leaf to root).

//Example
//Given binary tree {3,9,20,#,#,15,7},
//
//      3
//     / \
//    9  20
//      /  \
//     15   7 
//
//return its bottom-up level order traversal as:
//
//  [
//    [15,7],
//    [9,20],
//    [3]
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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(result);
        return result;
    }
}


