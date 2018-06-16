//Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

//LintCode will print the subtree which root is your return node.
//It's guaranteed that there is only one subtree with maximum average.

//Example
//Given a binary tree:
//  
//       1
//     /   \
//   -5     11
//   / \   /  \
//  1   2 4    -2 
//return the node 11.



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
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    
    private ResultType maxSub = null;
    private TreeNode node = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        maxAverage(root);
        return node;
    }
    
    private ResultType maxAverage(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = maxAverage(root.left);
        ResultType right = maxAverage(root.right);
        
        ResultType result = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);
        
        //注意这里判断大小不要用 sum / size，整数除法会使得结果错误，此处要交叉相乘判断大小
        if (maxSub == null || maxSub.sum * result.size < result.sum * maxSub.size) {
            maxSub = result;
            node = root;
        }
        
        return result;
    }
}

class ResultType {
    public int sum;
    public int size;
    
    public ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}

