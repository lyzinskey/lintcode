//Six degrees of separation is the theory that everyone and everything is six or fewer steps away, 
//by way of introduction, from any other person in the world, 
//so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

//Given a friendship relations, find the degrees of two people, 
//return -1 if they can not been connected by friends of friends.

//Example
//Given a graph:
//
//  1------2-----4
//   \          /
//    \        /
//     \--3--/
//  {1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2
//
//Given a graph:
//
//  1      2-----4
//               /
//             /
//            3
//  {1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1


/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (graph == null || graph.size() == 0){
            return -1;
        }

        if (s == t){
            return 0;
        }

        int degrees = 0;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> hashSet = new HashSet<>();
        queue.offer(s);
        hashSet.add(s);

        while (!queue.isEmpty()){
            degrees++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode neighbor : node.neighbors){
                    if (neighbor == t){
                        return degrees;
                    }
                    else {
                        if (!hashSet.contains(neighbor)){
                            queue.offer(neighbor);
                            hashSet.add(neighbor);
                        }
                    }
                }
            }
        }

        return -1;
    }
}

