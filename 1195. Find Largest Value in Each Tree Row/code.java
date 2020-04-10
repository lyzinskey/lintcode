//You need to find the largest value in each row of a binary tree.

//Example
//Example 1:
//
//Input:
//{1,3,2,5,3,#,9}
//Output:
//[1,3,9]
//
//Explanation:
//     1
//   /    \
//  3     2
// /   \     \
//5    3      9

//Example 2:
//
//Input:
//{1,2,3,4,5,6,#,#,7}
//Output:
//[1,3,6,7]
//
//Explanation:
//           1
//        /     \
//     2         3
//   /  \      /
// 4    5   6
//  \
//   7




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
     * @param root: a root of integer
     * @return: return a list of integer
     */
    public List<Integer> largestValues(TreeNode root) {    
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<Integer>();        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(cur.val, max);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(max);            
        }
        return res;
    }    
}



