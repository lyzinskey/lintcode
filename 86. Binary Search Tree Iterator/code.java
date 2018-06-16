//Design an iterator over a binary search tree with the following rules:

//Elements are visited in ascending order (i.e. an in-order traversal)
//next() and hasNext() queries run in O(1) time in average.

//Example
//For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
//  
//     10
//   /    \
//  1      11
//   \       \
//    6       12

//Challenge
//Extra memory usage O(h), h is the height of the tree.

//Super Star: Extra memory usage O(1)



//这是一个非常通用的利用 stack 进行 Binary Tree Iterator 的写法。

//stack 中保存一路走到当前节点的所有节点，stack.peek() 一直指向 iterator 指向的当前节点。
//因此判断有没有下一个，只需要判断 stack 是否为空
//获得下一个值，只需要返回 stack.peek() 的值，并将 stack 进行相应的变化，挪到下一个点。

//挪到下一个点的算法如下：
//
//如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点
//如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点


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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curr;
    
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        curr = stack.peek();
        TreeNode node = stack.peek();
        
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }
        else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
        return curr;
    }
}

