//Given a binary tree, return the postorder traversal of its nodes' values.

//Example
//Given binary tree {1,#,2,3},
//
//   1
//    \
//     2
//    /
//   3 
//
//return [3,2,1].

//Challenge
//Can you do it without recursion?


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


//recursion
//
public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        postorder(root, nodeList);
        return nodeList;
    }
    
    private void postorder(TreeNode root, ArrayList<Integer> nodeList){
        if (root == null){
            return;
        }
        
        postorder(root.left, nodeList);
        postorder(root.right, nodeList);
        nodeList.add(root.val);
    }
}


//non-recursion (iterative)
//    
//    public ArrayList<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode prev = null; // previously traversed node
//        TreeNode curr = root;
//
//        if (root == null) {
//            return result;
//        }
//
//        stack.push(root);
//        while (!stack.empty()) {
//            curr = stack.peek();
//            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
//                if (curr.left != null) {
//                    stack.push(curr.left);
//                } else if (curr.right != null) {
//                    stack.push(curr.right);
//                }
//            } else if (curr.left == prev) { // traverse up the tree from the left
//                if (curr.right != null) {
//                    stack.push(curr.right);
//                }
//            } else { // traverse up the tree from the right
//                result.add(curr.val);
//                stack.pop();
//            }
//            prev = curr;
//        }
//
//        return result;
//    }

