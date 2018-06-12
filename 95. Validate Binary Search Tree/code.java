//Given a binary tree, determine if it is a valid binary search tree (BST).

//Assume a BST is defined as follows:

//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//A single node tree is a BST

//Example
//An example:
//
//    2
//   / \
//  1   4
//     / \
//    3   5
//The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).



//use inorder traversal
//
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private boolean isValid;
    private TreeNode lastNode;
    
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        lastNode = null;
        inorderTraversal(root);
        return isValid;
    }
    
    private void inorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        
        inorderTraversal(root.left);
        
        if (lastNode != null && lastNode.val >= root.val){
            isValid = false;
            return;
        }
        lastNode = root;
        inorderTraversal(root.right);
    }
}


//Divide & Conquer
//

class ResultType {
    public boolean isValid;
    public TreeNode maxNode;
    public TreeNode minNode;
    
    public ResultType(boolean isValid){
        this.isValid = isValid;
        maxNode = null;
        minNode = null;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isValid;
    }
    
    private ResultType divideConquer(TreeNode root){
        if (root == null){
            return new ResultType(true);
        }
        
        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);
        
        if (!left.isValid || !right.isValid){
            return new ResultType(false);
        }
        
        if (left.maxNode != null && left.maxNode.val >= root.val){
            return new ResultType(false);
        }
        
        if (right.minNode != null && right.minNode.val <= root.val){
            return new ResultType(false);
        }
        
        ResultType result = new ResultType(true);
        
        if (right.maxNode != null){
            result.maxNode = right.maxNode;
        }
        else {
            result.maxNode = root;
        }
        
        if (left.minNode != null){
            result.minNode = left.minNode;
        }
        else {
            result.minNode = root;
        }
        
        return result;
    }
    
}

