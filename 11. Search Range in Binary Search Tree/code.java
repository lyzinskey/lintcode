//Given a binary search tree and a range [k1, k2], return all elements in the given range.

//Example
//If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
//
//      20
//     /  \
//    8   22
//   / \
//  4   12



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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> allElements = new ArrayList<>();
        
        if (root == null || k1 > k2){
            return allElements;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                
                if (node.val >= k1 && node.val <= k2){
                    allElements.add(node.val);
                }
            }
        }
        
        Collections.sort(allElements);
        return allElements;
    }
}

