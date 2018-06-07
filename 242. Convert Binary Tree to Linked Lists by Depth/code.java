//Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
//(e.g., if you have a tree with depth D, you'll have D linked lists).

//Example
//Given binary tree:
//
//      1
//     / \
//    2   3
//   /
//  4
//
//return
//
//  [
//    1->null,
//    2->3->null,
//    4->null
//  ]


    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<ListNode>();
        
        if (root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            result.add(dummy.next);
        }
        
        return result;
    }

