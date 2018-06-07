//Design an algorithm and write code to serialize and deserialize a binary tree. 
//Writing the tree to a file is called 'serialization', 
//and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

//There is no limit of how you deserialize or serialize a binary tree, 
//LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.

//Example
//An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
//
//You can use other method to do serializaiton and deserialization.


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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        //注意这里queue的size在每次循环之后都会变化
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        //删除最后一层的所有为null的叶子节点
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        //String每次修改都会新建一个String
        //StringBuilder的好处在于可以对单一对象进行修改而不是每次都新建对象
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        
        //去掉一头一尾的“{”，“}”, 同时按照“，”将String进行split
        String[] vals = data.substring(1, data.length() - 1).split(",");
        
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        
        int index = 0;
        boolean isLeftChild = true;
        
        //根据isLeftChild判断是左子树还是右子树
        //每次循环结束时isLeftChild取反
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            
            //当前节点的两个子树都已处理完毕，移动到下一节点
            if (!isLeftChild) {
                index++;
            }
            
            isLeftChild = !isLeftChild;
        }
        
        return root;
    }
    
}

