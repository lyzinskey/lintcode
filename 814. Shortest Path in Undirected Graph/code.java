//Give an undirected graph, in which each edge's length is 1, and give two nodes from the graph. 
//We need to find the length of the shortest path between the given two nodes.

//Example
//Given graph = {1,2,4#2,1,4#3,5#4,1,2#5,3}, and nodeA = 3, nodeB = 5.
//return 1.


/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode start, UndirectedGraphNode end) {
        if (start.equals(end)) {
            return 1;
        }
        // 起点开始的BFS队列
        Queue<UndirectedGraphNode> startQueue = new LinkedList<>();
        // 终点开始的BFS队列
        Queue<UndirectedGraphNode> endQueue = new LinkedList<>();
        startQueue.add(start);
        endQueue.add(end);
        int step = 0;
        // 记录从起点开始访问到的节点
        Set<UndirectedGraphNode> startVisited = new HashSet<>();
        // 记录从终点开始访问到的节点
        Set<UndirectedGraphNode> endVisited = new HashSet<>();
        startVisited.add(start);
        endVisited.add(end);
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            int endSize = endQueue.size();
            // 按层遍历
            step++;
            for (int i = 0; i < startSize; i++) {
                UndirectedGraphNode cur = startQueue.poll();
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (startVisited.contains(neighbor)) {//重复节点
                        continue;
                    } else if (endVisited.contains(neighbor)) {//相交
                        return step;
                    } else {
                        startVisited.add(neighbor);
                        startQueue.add(neighbor);
                    }
                }
            }
            step++;
            for (int i = 0; i < endSize; i++) {
                UndirectedGraphNode cur = endQueue.poll();
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (endVisited.contains(neighbor)) {
                        continue;
                    } else if (startVisited.contains(neighbor)) {
                        return step;
                    } else {
                        endVisited.add(neighbor);
                        endQueue.add(neighbor);
                    }
                }
            }
        }
        return -1; // 不连通
    }
    
    
