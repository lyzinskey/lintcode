//Given a binary tree, imagine yourself standing on the right side of it, 
//return the values of the nodes you can see ordered from top to bottom

//Example
//Example 1
//
//Input: {1,2,3,#,5,#,4}
//Output: [1,3,4]
//Explanation:
//     1            
//   /   \
//  2     3         
//   \     \
//    5     4       

//Example 2
//
//Input: {1,2,3}
//Output: [1,3]
//Explanation:
//     1            
//   /   \
//  2     3        




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
     * @param root: the root of the given tree
     * @return: the values of the nodes you can see ordered from top to bottom
     */
    
    // revised order of first-order traversal: root->right->left
    // for every level, the first node encountered is the rightmost node at this level
    //
    // Time: O(n)
    // Space: O(height)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode x, int level, List<Integer> res) {
        if (x == null) {
            return;
        }
        
        if (res.size() == level) {
            res.add(x.val);
        }

        dfs(x.right, level + 1, res);
        dfs(x.left, level + 1, res);        
    }
}



