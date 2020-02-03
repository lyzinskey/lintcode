//Given a list routes, and routes[i] is the circular route of the i-th bus. 
//For example, if routes[0] = [1, 5, 7], the first bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 ... forever.

//Given S and T. Travelling by buses only, what is the least number of buses we need take to reach T from S ? 
//Return -1 if it is not possible.

//Example
//Example 1:
//
//Input: routes = [[1, 2, 7], [3, 6, 7]], S = 1, T = 6
//Output: 2
//Explanation: Take the first bus to the bus stop 7, and then take the second bus to 6.

//Example 2:
//
//Input: routes = [[1], [15, 16, 18], [3, 4,12,14]], S = 3, T = 15
//Output: -1
//Explanation: There is no way to get 15 from 3.

//Notice
//1 <= routes.length <= 500
//1 <= routes[i].length <= 500
//0 <= routes[i][j] < 10 ^ 6





public class Solution {
    /**
     * @param routes:  a list of bus routes
     * @param S: start
     * @param T: destination
     * @return: the least number of buses we must take to reach destination
     */
    // bfs
    // Time: O(mn)
    // Space: O(mn)     
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        
        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        boolean[] visited = new boolean[routes.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int res = 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!hashmap.containsKey(routes[i][j])) {
                    hashmap.put(routes[i][j], new ArrayList<>());
                }
                hashmap.get(routes[i][j]).add(i);
            }
        }

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                List<Integer> buses = hashmap.get(stop);
                for (int bus : buses) {
                    if (visited[bus]) {
                        continue;
                    }
                    visited[bus] = true;
                    for (int next : routes[bus]) {
                        if (next == T) {
                            return res;
                        }
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;        
    }
}



