//Given a directed graph where each edge is represented by a tuple, 
//such as [u, v, w]represents an edge with a weight w from u to v.
//You need to calculate at least the need to add the number of edges to ensure that each point of the weight are balancing. 
//That is, the sum of weight of the edge pointing to this point is equal to 
//the sum of weight of the edge of the point that points to the other point.

//Example
//Example 1
//
//Input: [[0,1,10],[2,0,5]]
//Output: 2
//Explanation:
//Two edges are need to added. There are [1,0,5] and [1,2,5]

//Example 2
//
//Input: [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
//Output: 1
//Explanation:
//Only one edge need to added. There is [1,0,4]

//Notice
//1.Note that u ≠ v and w > 0.
//2.index may not be linear, e.g. we could have the points 0, 1, 2 or we could also have the points 0, 2, 6.





public class Solution {
    /*
     * @param edges: a directed graph where each edge is represented by a tuple
     * @return: the number of edges
     */
    /*
        1. 先计算每个人的净得款/净欠款，目标是让所有人的balance = 0，不用管是得的谁的钱也不用管是欠的谁的钱
        2. 删除所有balance = 0的人
        3.1 找到2个人的balance之和为0的，这2个人可以用1次transaction解决
        3.2 找到3个人的balance之和为0的，这3个人可以用2次transaction解决
        3.3 找到4个人的balance之和为0的，这4个人可以用3次transaction解决
        ...
        3.N-1 找到N个人的balance之和为0的，这N个人可以用N-1次transaction解决
    */
    public int balanceGraph(int[][] transactions) {
        // convert the transactions to a balance count for each person
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            if (!map.containsKey(transactions[i][0])) {
                map.put(transactions[i][0], 0);
            }
            if (!map.containsKey(transactions[i][1])) {
                map.put(transactions[i][1], 0);
            }

            map.put(transactions[i][0], map.get(transactions[i][0]) + transactions[i][2]);
            map.put(transactions[i][1], map.get(transactions[i][1]) - transactions[i][2]);
        }

        // take the non-zero balances and sort them into an array
        // the sorting will help with DFS pruning
        List<Integer> nums = new ArrayList<>();
        for (int value : map.values()) {
            if (value != 0) {
                nums.add(value);
            }
        }
        Collections.sort(nums);

        int cnt = 0;
        int targetLen = 2;
        while (nums.size() > 0) {
            // try to find a set of length = targetLen which sum to 0
            List<Integer> indexes = new ArrayList<>();
            boolean found = dfs(nums, indexes, targetLen, 0, 0);

            if (found) {
                // because this is the minimum length set that can sum to zero,
                // this set will require (len - 1) transactions to balance
                cnt += indexes.size() - 1;

                // remove these values from the list and try again for another set of this length
                int indexesIndex = 0;
                List<Integer> next = new ArrayList<>();
                for (int i = 0; i < nums.size(); i++) {
                    if (indexesIndex < indexes.size() && i == indexes.get(indexesIndex)) {
                        indexesIndex++;
                    } else {
                        next.add(nums.get(i));
                    }
                }
                nums = next;
            } else {
                // no set of this length was found, try the next length
                targetLen++;
            }
        }

        return cnt;
    }

    // DFS - find targetLen amount of items that sum to zero
    // store the indexes of these elements
    public boolean dfs(List<Integer> nums, List<Integer> indexes, int targetLen, int sum, int index) {
        if (sum > 0) {
            return false; // pruning - array is sorted
        }
        if (indexes.size() == targetLen && sum == 0) {
            return true;
        }
        if (indexes.size() == targetLen || nums.size() - index < targetLen - indexes.size()) {
            return false;
        }

        for (int i = index; i < nums.size(); i++) {
            indexes.add(i);
            if (dfs(nums, indexes, targetLen, sum + nums.get(i), i + 1)) {
                return true;
            }
            indexes.remove(indexes.size() - 1);
        }
        return false;
    }    
}


