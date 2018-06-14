//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

//Example
//               2
//1->2->3  =>   / \
//             1   3



/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    
    
    //完整算法描述如下：
    //首先求得整个list的长度 O(n)
    //利用 helper 函数进行递归，helper(head, len) 表示把从 head 开始的，
    //长度为len的链表，转换为一个bst并且return。
    //与此同时，把global variable的指针挪到head开始的第 len + 1个listnode上。
    //那么 convert(head, len) 就可以分为，三个步骤：

    //把head开头的长度为 len/2的先变成bst，也就是我们的左子树，convert(head, len / 2)。
    //这个时候他顺便会把global variable 挪到第len / 2 + 1的那个node，这个就是我们的root。
    //然后得到了root之后，把global variable 往下挪一个挪到 第 len/2 + 2个点，
    //也就是右子树开头的那个点，然后调用 convert(global variable, len - len/2 -1)，构造出右子树。
    //然后把root，左子树，右子树，拼接在一起，return     
    
    
    //这里我们在全局放了一个 current 指针，
    //这个指针会指向当前还没有被变成 Tree 的下一个 List 上的节点。
    //因此如果我们把左子树变成 Tree 以后，
    //current 就要让他指向 List 上的下一个点，也就是中间的这个点了。
    private ListNode current; 
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head;
        TreeNode root = convertToBST(size);
        
        return root;
    }
    
    private int getSize(ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }
    
    private TreeNode convertToBST(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = convertToBST(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = convertToBST(size - size / 2 - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}

