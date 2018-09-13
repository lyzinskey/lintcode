//Given inorder and postorder traversal of a tree, construct the binary tree.

//You may assume that duplicates do not exist in the tree.

//Example
//Given inorder [1,2,3] and postorder [1,3,2], return a tree:
//
//    2
//   / \
//  1   3


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
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length != postOrder.length || inOrder.length == 0){
            return null;
        }

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }

        return reconstruct(inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1,
                idxMap);
    }

    private TreeNode reconstruct(int[] inOrder, int inLeft, int inRight,
                                 int[] postOrder, int postLeft, int postRight,
                                 Map<Integer, Integer> idxMap) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postRight]);
        int leftSize = idxMap.get(root.val) - inLeft;

        root.left = reconstruct(inOrder, inLeft, inLeft + leftSize - 1,
                postOrder, postLeft, postLeft + leftSize - 1,
                idxMap);
        root.right = reconstruct(inOrder, inLeft + leftSize + 1, inRight,
                postOrder, postLeft + leftSize, postRight - 1,
                idxMap);
        return root;
    }
}



