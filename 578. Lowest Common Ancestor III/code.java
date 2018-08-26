//Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
//The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
//Return null if LCA does not exist.

//node A or node B may not exist in tree.

//Example
//For the following binary tree:
//  
//    4
//   / \
//  3   7
//     / \
//    5   6
//LCA(3, 5) = 4
//LCA(5, 6) = 7
//LCA(6, 7) = 7



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
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    private Boolean existA = false;
    private Boolean existB = false;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        exist(root, A, B);
        
        if (existA == false || existB == false || root == null) {
            return null;
        }
        
        return lowestCommonAncestor(root, A, B);
    }
    
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null) {
            return root;        
        }
        else {
            if (left != null) {
                return left;
            }
            return right;                       
        }         
    }  
    
    private void exist(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return;
        }
        
        if (root.val == A.val) {
            existA = true;
        }
        
        if (root.val == B.val) {
            existB = true;
        }        
        
        exist(root.left, A, B);
        exist(root.right, A, B);
        
    }
}





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
class ResultType {
    public boolean existA, existB;
    public TreeNode node;

    ResultType(boolean a, boolean b, TreeNode n) {
        existA = a;
        existB = b;
        node = n;
    }
}

public class Solution {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType rt = helper(root, A, B);
        if (rt.existA && rt.existB)
            return rt.node;
        else
            return null;
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return new ResultType(false, false, null);

        ResultType left_rt = helper(root.left, A, B);
        ResultType right_rt = helper(root.right, A, B);

        boolean a_exist = left_rt.existA || right_rt.existA || root == A;
        boolean b_exist = left_rt.existB || right_rt.existB || root == B;

        if (root == A || root == B)
            return new ResultType(a_exist, b_exist, root);

        if (left_rt.node != null && right_rt.node != null)
            return new ResultType(a_exist, b_exist, root);
        if (left_rt.node != null)
            return new ResultType(a_exist, b_exist, left_rt.node);
        if (right_rt.node != null)
            return new ResultType(a_exist, b_exist, right_rt.node);

        return new ResultType(a_exist, b_exist, null);
    }
}





// solution 2
//
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        TreeNode result = LCA(root, A, B);
    
        if (result == A) {
            if (LCA(A, B, B) == null) {
                return null;
            }
        }
        if (result == B) {
            if (LCA(B, A, A) == null) {
                return null;
            }
        }       
        return result;
    }
    
    public TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = LCA(root.left, A, B);
        TreeNode right = LCA(root.right, A, B);
        
        if (left != null && right != null) {
            return root;        
        }
        return left == null ? right : left;         
    }



