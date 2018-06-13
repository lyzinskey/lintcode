//In a binary search tree, (Only) two nodes are swapped. 
//Find out these nodes and swap them. If there no node swapped, return original root of tree.

//Example
//Given a binary search tree:
//
//      4
//     / \
//    5   2
//   / \
//  1   3
//
//return
//
//      4
//     / \
//    2   5
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
     * @param root: the given tree
     * @return: the tree after swapping
     */
    
    
    //对整个树中序遍历一次，并存储结果
    //对结果从前往后，从后往前遍历两次
    public TreeNode bstSwappedNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<TreeNode> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        if (inorder.size() < 2) {
            return root;
        }

        ArrayList<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                swap(inorder.get(i), inorder.get(i + 1));
            }
        }

        for (int i = inorder.size() - 1; i > 0; i--) {
            if (inorder.get(i).val < inorder.get(i - 1).val) {
                swap(inorder.get(i), inorder.get(i - 1));
            }
        }

        return root;
    }

    private void inorderTraversal(TreeNode root, ArrayList<TreeNode> swap) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, swap);
        swap.add(root);
        inorderTraversal(root.right, swap);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}

