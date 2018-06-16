//Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

//The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

//The node has an extra attribute parent which point to the father of itself. The root's parent is null.

//Example
//For the following binary tree:
//
//    4
//   / \
//  3   7
//     / \
//    5   6
//LCA(3, 5) = 4
//LCA(5, 6) = 7
//LCA(6, 7) = 7


/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        ParentTreeNode parent = null;
        
        List<ParentTreeNode> listA = parentList(A);
        List<ParentTreeNode> listB = parentList(B);
        
        int indexA = listA.size() - 1;
        int indexB = listB.size() - 1;
        
        while (indexA >= 0 && indexB >= 0) {
            if (listA.get(indexA) != listB.get(indexB)) {
                break;
            }
            parent = listA.get(indexA);
            indexA--;
            indexB--;
        }
        
        return parent;
    }
    
    private List<ParentTreeNode> parentList(ParentTreeNode node) {
        List<ParentTreeNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.parent;
        }
        return list;
    }
}

