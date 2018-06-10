//Given a binary tree, return the preorder traversal of its nodes' values.

//Example
//Given:
//
//      1
//     / \
//    2   3
//   / \
//  4   5
//return [1,2,4,5,3].

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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        preorder(root, nodeList);
        return nodeList;
    }
    
    private void preorder(TreeNode root, ArrayList<Integer> nodeList){
        if (root == null){
            return;
        }
        
        nodeList.add(root.val);
        preorder(root.left, nodeList);
        preorder(root.right, nodeList);
    }
}



//non-recursion (iterative)
//
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> nodeList = new ArrayList<>();
//        Stack<TreeNode> treeStack = new Stack<>();
//
//        if (root == null){
//            return nodeList;
//        }
//
//        treeStack.push(root);
//
//        while (!treeStack.empty()){
//            TreeNode node = treeStack.pop();
//            nodeList.add(node.val);
//
//            if (node.right != null){
//                treeStack.push(node.right);
//            }
//            if (node.left != null){
//                treeStack.push(node.left);
//            }
//        }
//
//        return nodeList;
//    }
