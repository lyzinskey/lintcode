//We are given a binary tree (with root node root), a target node, and an integer value K.

//Return a list of the values of all nodes that have a distance K from the target node. 
//The answer can be returned in any order.

//Example
//Example 1:
//
//Input:
//{3,5,1,6,2,0,8,#,#,7,4}
//5
//2
//
//Output: [7,4,1]
//
//Explanation: 
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.

//Example 2
//
//Input:
//{1,2,3,4}
//2
//1
//
//Output: [1,4]
//
//Explanation:
//The binary tree is like this:
//    1
//   / \
//  2   3
// /   
//4   
//The node 1 and 4 is 1 away from 2.

//Notice
//The given tree is non-empty.
//Each node in the tree has unique values 0 <= node.val <= 500.
//The target node is a node in the tree.
//0 <= K <= 1000.





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
     * @param root: the root of the tree
     * @param target: the target
     * @param K: the given K
     * @return: All Nodes Distance K in Binary Tree
     */
    // recursion dfs
    // Time: O(n)
    // Space: O(n)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        distanceToTarget(root, target, K, res);
        return res;
    }

    // Returns the distance from root to target.
    // Returns -1 if target does not in the tree.
    private int distanceToTarget(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) {
            return -1;
        }
        if (root.val == target.val) {
            collect(target, K, res);
            return 0;
        }

        int l = distanceToTarget(root.left, target, K, res);
        int r = distanceToTarget(root.right, target, K, res);

        // Target in the left subtree
        if (l >= 0) {
            if (l == K - 1) {
                res.add(root.val);
            }
            // Collect nodes in right subtree with depth K - l - 2
            collect(root.right, K - l - 2, res);
            return l + 1;
        }
        // Target in the right subtree
        if (r >= 0) {
            if (r == K - 1) {
                res.add(root.val);
            }
            // Collect nodes in left subtree with depth K - r - 2
            collect(root.left, K - r - 2, res);
            return r + 1;
        }
        return -1;
    }

    // Collect nodes that are k steps from node.
    private void collect(TreeNode node, int k, List<Integer> res) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            res.add(node.val);
        }
        collect(node.left, k - 1, res);
        collect(node.right, k - 1, res);
    }     
}




