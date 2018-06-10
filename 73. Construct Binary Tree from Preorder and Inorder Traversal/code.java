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
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length){
            return null;
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if (instart > inend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        int position = findRootPosition(inorder, instart, inend, root.val);

        //找到root的position之后，左子树点的个数等于position - instart
        root.left = build(preorder, prestart + 1, prestart + position - instart, inorder, instart, position - 1);
        root.right = build(preorder, prestart + 1 + position - instart, preend, inorder, position + 1, inend);

        return root;
    }

    private int findRootPosition(int[] tree, int start, int end, int key){
        for (int i = start; i <= end; i++) {
            if (tree[i] == key){
                return i;
            }
        }
        return -1;
    }
    
}

