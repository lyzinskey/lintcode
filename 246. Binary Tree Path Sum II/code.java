//You are given a binary tree in which each node contains a value. 
//Design an algorithm to get all paths which sum to a given value. 
//The path does not need to start or end at the root or a leaf, but it must go in a straight line down.

//Example
//Given a binary tree:
//  
//      1
//     / \
//    2   3
//   /   /
//  4   2
//for target = 6, return
//
//  [
//    [2, 4],
//    [1, 3, 2]
//  ]



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
     * @param target: An integer
     * @return: all valid paths
     */
    
    private List<List<Integer>> result = new ArrayList<>();
     
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        getPath(root, target, path);
        
        return result;
    }
    
    private void getPath(TreeNode root, int target, List<Integer> path) {
        int sum = 0;
        
        for(int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int j = i; j < path.size(); j++) {
                    list.add(path.get(j));
                }
                result.add(list);
            }
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            getPath(root.left, target, path);
            path.remove(path.size() - 1);
        }
        
        if (root.right != null) {
            path.add(root.right.val);
            getPath(root.right, target, path);
            path.remove(path.size() - 1);
        }
    
    }
}

