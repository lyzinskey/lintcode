//Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. 
//If there is no such a node with given value in the binary search tree, do nothing. 
//You should keep the tree still a binary search tree after removal.

//Example
//Given binary search tree:
//
//      5
//     / \
//    3   6
//   / \
//  2   4
//
//Remove 3, you can either return:
//
//      5
//     / \
//    2   6
//     \
//      4
//
//or
//
//      5
//     / \
//    4   6
//   /
//  2


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
    public TreeNode removeNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = removeNode(root.right, key);
        }
        else if (root.val > key) {
            root.left = removeNode(root.left, key);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            else {
                TreeNode smallest = findSmallest(root.right);
                root.val = smallest.val;
                root.right = removeNode(root.right, smallest.val);
            }
        }
        return root;
    }

    private TreeNode findSmallest(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}



