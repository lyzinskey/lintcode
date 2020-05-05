//Given a directed, acyclic graph of N nodes. 
//Find all possible paths from node 0 to node N-1, and return them in any order.

//The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1. 
//graph[i] is a list of all nodes j for which the edge i->j exists.

//Example
//Example 1:
//
//Input: [[1,2],[3],[3],[]] 
//Output: [[0,1,3],[0,2,3]] 
//Explanation: The graph looks like this:
//  0--->1
//  |    |
//  v    v
//  2--->3
//  There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

//Example 2:
//
//Input: [[1,3],[2],[3],[]]
//Output: [[0,1,2,3],[0,3]]

//Notice
//The number of nodes in the graph will be in the range of [2, 15].
//You can return different paths in any order, but you should keep the order of nodes inside one path.




public class Solution {
    /**
     * @param graph: a 2D array
     * @return: all possible paths from node 0 to node N-1
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
					
        path.add(0);
        dfsSearch(graph, 0, res, path);
					
        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }    
}




