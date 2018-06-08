//Find the number connected component in the undirected graph. 
//Each node in the graph contains a label and a list of its neighbors. 
//(a connected component (or just component) of an undirected graph is a subgraph 
//in which any two vertices are connected to each other by paths, 
//and which is connected to no additional vertices in the supergraph.)

//Each connected component should sort by label.

//Example
//Given graph:
//
//  A------B  C
//   \     |  | 
//    \    |  |
//     \   |  |
//      \  |  |
//        D   E
//Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}


/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        List<List<Integer>> connectedList = new ArrayList<>();

        if (nodes == null || nodes.size() == 0) {
            return connectedList;
        }

        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        for (UndirectedGraphNode node : nodes){
            visited.put(node, false);
        }

        for (UndirectedGraphNode node : nodes){
            if (visited.get(node) == false){
                BFS(node, visited, connectedList);
            }
        }

        return connectedList;
    }

    private void BFS(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> connectedList){
        ArrayList<Integer> connectedNodes = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, true);

        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                UndirectedGraphNode newNode = queue.poll();
                connectedNodes.add(newNode.label);

                for (UndirectedGraphNode neighbor : newNode.neighbors){
                    if (!visited.get(neighbor)){
                        queue.offer(neighbor);
                        visited.put(neighbor, true);
                    }
                }
            }
        }
        
        Collections.sort(connectedNodes);
        connectedList.add(connectedNodes);
    }
}


