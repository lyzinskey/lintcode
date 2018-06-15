//Flatten a binary tree to a fake "linked list" in pre-order traversal.

//Here we use the right pointer in TreeNode as the next pointer in ListNode.

//Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

//Example
//                1
//                 \
//       1          2
//      / \          \
//     2   5    =>    3
//    / \   \          \
//   3   4   6          4
//                       \
//                        5
//                         \
//                          6

//Challenge
//Do it in-place without any extra memory.



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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    
    //traverse
    //
    private TreeNode lastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}


    //non-recursion
    //
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            
            node.left = null;
            if (stack.isEmpty()) {
                node.right = null;
            }
            else {
                node.right = stack.peek();
            }
            
        }
    }
    
    
