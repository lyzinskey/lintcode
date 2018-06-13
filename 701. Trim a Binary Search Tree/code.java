//Given the root of a binary search tree and 2 numbers min and max, 
//trim the tree such that all the numbers in the new tree are between min and max (inclusive). 
//The resulting tree should still be a valid binary search tree. So, if we get this tree as input:

//http://www.ardendertat.com/wp-content/uploads/2012/01/bst.png

//and we’re given min value as 5 and max value as 13, then the resulting binary search tree should be:

//http://www.ardendertat.com/wp-content/uploads/2012/01/bst_trim.png

//Example
//Given binary search tree:
//{8,3,10,1,6,#,14,#,#,4,7,13} and minVal = 5, maxVal = 13.
//
//One possible answer: {8, 6, 10, #, 7, #, 13}

//Examples from Leetcode:
//Example 1:
//Input: 
//      1
//     / \
//    0   2
//
//    L = 1
//    R = 2
//
//  Output: 
//      1
//        \
//         2

//Example 2:
//Input: 
//      3
//     / \
//    0   4
//     \
//      2
//     /
//    1
//  
//  L = 1
//  R = 3
//
//  Output: 
//        3
//       / 
//     2   
//    /
//   1


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
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        if (root == null){
            return null;
        }
        
        if (root.val > maximum){
            root = trimBST(root.left, minimum, maximum);
        }
        else if (root.val < minimum){
            root = trimBST(root.right, minimum, maximum);
        }
        else {
            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);
        }
        
        return root;
    }
    
}

