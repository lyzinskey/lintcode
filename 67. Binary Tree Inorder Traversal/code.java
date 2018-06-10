//Given a binary tree, return the inorder traversal of its nodes' values.

//Example
//Given binary tree {1,#,2,3},
//
//   1
//    \
//     2
//    /
//   3 
//
//return [1,3,2].

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
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        inorder(root, nodeList);
        return nodeList;
    }
    
    private void inorder(TreeNode root, ArrayList<Integer> nodeList){
        if (root == null){
            return;
        }
        
        inorder(root.left, nodeList);
        nodeList.add(root.val);
        inorder(root.right, nodeList);
    }
}



    //non-recursion (iterative)
    //
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> nodeList = new ArrayList<>();
    //     Stack<TreeNode> tree = new Stack<>();
        
    //     if (root == null){
    //         return nodeList;
    //     }
        
    //     while (root != null){
    //         tree.push(root);
    //         root = root.left;
    //     }
        
    //     while (!tree.empty()){
    //         TreeNode curr = tree.peek();
    //         nodeList.add(curr.val);
            
    //         if (curr.right != null){
    //             curr = curr.right;
    //             while (curr != null){
    //                 tree.push(curr);
    //                 curr = curr.left;
    //             }
    //         }
    //         else {
    //             curr = tree.pop();
    //             while (!tree.empty() && tree.peek().right == curr){
    //                 curr = tree.pop();
    //             }
    //         }
    //     }
        
    //     return nodeList;
    // }
    
    
    
