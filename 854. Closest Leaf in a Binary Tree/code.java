//Given a binary tree where every node has a unique value, and a target key k.

//Find the value of the nearest leaf node to target k in the tree. 
//If there are multiple cases, you should follow these priorities:

//The leaf node is in the left subtree of the node with k;
//The leaf node is in the right subtree of the node with k;
//The leaf node is not in the subtree of the node with k.

//Example
//Example 1:
//
//Input: {1, 3, 2}, k = 1
//Output: 3
//Explanation:
//    1
//   / \
//  3   2

//Example 2:
//
//Input: {1}, k = 1
//Output: 1

//Clarification
//A node is called a leaf if it has no children.

//Notice
//root represents a binary tree with at least 1 node and at most 1000 nodes.
//Every node has a unique node.val in range [1, 1000][1,1000].
//There exists a node in the given binary tree for which node.val == k.




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
     * @param root: the root
     * @param k: an integer
     * @return: the value of the nearest leaf node to target k in the tree
     */
    // First, preform DFS on root in order to find the node whose val = k, 
    // at the meantime use HashMap to keep record of all back edges from child to parent;
    // Then perform BFS on this node to find the closest leaf node.
    //
    // Time: O(n)
    // Space: O(n)
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();   // store all edges that trace node back to its parent
        Queue<TreeNode> queue = new LinkedList<>();          // the queue used in BFS
        Set<TreeNode> visited = new HashSet<>();             // store all visited nodes
        
        // DFS: search for node whoes val == k
        TreeNode kNode = DFS(root, k, backMap);
        queue.add(kNode);
        visited.add(kNode);
        
        // BFS: find the shortest path
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left == null && curr.right == null) {
                return curr.val;
            }
            if(curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if(curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if(backMap.containsKey(curr) && visited.add(backMap.get(curr))) {  // go alone the back edge
                queue.add(backMap.get(curr));
            }
        }
        return -1; // never hit
    }
    
    private TreeNode DFS(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if(root.val == k) {
            return root;
        }
        if(root.left != null) {
            backMap.put(root.left, root);        // add back edge
            TreeNode left = DFS(root.left, k, backMap);
            if(left != null) {
                return left;
            }
        }
        if(root.right != null) {
            backMap.put(root.right, root);       // add back edge
            TreeNode right = DFS(root.right, k, backMap);
            if(right != null) {
                return right;
            }
        }
        return null;
    }    
}



