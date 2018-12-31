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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int layer = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> layerList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    TreeNode node = deque.pollLast();
                    layerList.add(node.val);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                } else {
                    TreeNode node = deque.pollFirst();
                    layerList.add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }                
            }
            layer = 1 - layer;
            result.add(layerList);
        }
        return result;
    }    
}




