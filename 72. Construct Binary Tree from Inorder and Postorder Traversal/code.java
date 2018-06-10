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
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length){
            return null;
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if (instart > inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        
        int position = findRootPosition(inorder, instart, inend, root.val);
        
        //找到root的position之后，左子树点的个数等于position - instart
        root.left = build(inorder, instart, position - 1, postorder, poststart, (poststart + position - instart) - 1);
        root.right = build(inorder, position + 1, inend, postorder, poststart + position - instart, postend - 1);

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

