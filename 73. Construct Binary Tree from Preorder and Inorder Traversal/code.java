//Given preorder and inorder traversal of a tree, construct the binary tree.

//You may assume that duplicates do not exist in the tree.

//Example
//Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
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
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (inOrder.length != preOrder.length || inOrder.length == 0){
            return null;
        }

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }

        return reconstruct(inOrder, 0, inOrder.length - 1,
                preOrder, 0, preOrder.length - 1,
                idxMap);
    }

    private TreeNode reconstruct(int[] inOrder, int inLeft, int inRight,
                                 int[] preOrder, int preLeft, int preRight,
                                 Map<Integer, Integer> idxMap) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preLeft]);
        int leftSize = idxMap.get(root.val) - inLeft;

        root.left = reconstruct(inOrder, inLeft, inLeft + leftSize - 1,
                preOrder, preLeft + 1, preLeft + leftSize,
                idxMap);
        root.right = reconstruct(inOrder, inLeft + leftSize + 1, inRight,
                preOrder, preLeft + leftSize + 1, preRight,
                idxMap);
        return root;
    }    
}



