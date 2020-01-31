//Given a binary tree, collect a tree's nodes as if you were doing this: 
//Collect and remove all leaves, repeat until the tree is empty.

//Example
//Example1
//Input: {1,2,3,4,5}
//Output: [[4, 5, 3], [2], [1]].
//Explanation:
//
//    1
//   / \
//  2   3
// / \     
//4   5    

//Example2
//Input: {1,2,3,4}
//Output: [[4, 3], [2], [1]].
//Explanation:
//
//    1
//   / \
//  2   3
// /
//4 




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
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    // Time: O(n)
    // Space: O(n)     
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        int height = 1 + Math.max(dfs(root.left, res), dfs(root.right, res));
        if (res.size() < height + 1) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }    
}



