//Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

//Example
//Example1
//
//Input: [[1,1],[-1,1]]
//Output: true

//Example2
//
//Input: [[1,1],[-1,-1]]
//Output: false

//Challenge
//Could you do better than O(n2)?




public class Solution {
    /**
     * @param points: n points on a 2D plane
     * @return: if there is such a line parallel to y-axis that reflect the given points
     */
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return true;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> hashset = new HashSet<>();
        
        for (int[] point : points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            hashset.add(point[0] + " " + point[1]);
        }
        
        for(int[] point : points) {
            int reflect = min + max - point[0];
            if (!hashset.contains(reflect + " " + point[1])) {
                return false;
            }
        }
        return true;
    }
}



