//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

//If two nodes are in the same row and column, the order should be from left to right.

//Example
//Example1
//
//Inpurt:  {3,9,20,#,#,15,7}
//Output: [[9],[3,15],[20],[7]]
//Explanation:
//     3
//    /\
//   /  \
//   9  20
//      /\
//     /  \
//    15   7

//Example2
//
//Input: {3,9,8,4,0,1,7}
//Output: [[4],[9],[3,0,1],[8],[7]]
//Explanation:
//       3
//      /\
//     /  \
//     9   8
//    /\  /\
//   /  \/  \
//   4  01   7





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
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    // Time: O(n)
    // Space: O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;
                if (!hashmap.containsKey(index)) {
                    hashmap.put(index, new ArrayList<>());
                }
                hashmap.get(index).add(node.val);
                min = Math.min(min, index);
                max = Math.max(max, index);
                
                if (node.left != null) {
                    queue.offer(new Pair(node.left, index - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, index + 1));
                }
            }
        }

        for (int i = min; i <= max; i++) {
            if (hashmap.containsKey(i)) {
                res.add(hashmap.get(i));
            }
        }
        return res;
    }  
    
    class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}



