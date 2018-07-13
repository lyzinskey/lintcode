//Give a number of arrays, find their intersection, and output their intersection size.

//The total number of all array elements is not more than 500000.
//There are no duplicated elements in each array.

//Example
//Given [[1,2,3],[3,4,5],[3,9,10]], return 1

//explanation:
//Only element 3 appears in all arrays, the intersection is [3], and the size is 1.
//Given [[1,2,3,4],[1,2,5,6,7][9,10,1,5,2,3]], return 2

//explanation:
//Only element 1,2 appear in all arrays, the intersection is [1,2], the size is 2.



public class Solution {

    public int intersectionOfArrays(int[][] arrs) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                int counter = 0;
                if (hashmap.containsKey(arrs[i][j])) {
                    counter = hashmap.get(arrs[i][j]) + 1;
                }
                else {
                    counter = 1;
                }
                hashmap.put(arrs[i][j], counter);
            }
        }
        
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() == arrs.length) {
                result++;
            }
        }
        
        return result;
    }
}



