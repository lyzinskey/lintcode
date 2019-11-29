//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

//Example
//Given 4 points: (1,2), (3,6), (0,0), (1,3).
//
//The maximum number is 3.




/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: an array of point
     * @return: An integer
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int res = 0;

        // any line can be represented by a point and a slope
        // we take the point as seed and find all possible slopes
        for (int i = 0; i < points.length; i++) {            
            Point seed = points[i];
            // record slope frequency with point seed
            Map<Double, Integer> count = new HashMap<>();
            
            // record number of duplicate points with seed
            int duplicate = 1;
            
            // record the points with same x
            // for the special case of infinite slope
            int sameX = 0;
            
            // record the max number of points 
            // on the same line crossing the seed point      
            int counter = 0;      
            
            for (int j = i + 1; j < points.length; j++) {
                Point point = points[j];
                if (seed.x == point.x && seed.y == point.y) {
                    duplicate++;
                } else if (seed.x == point.x) {
                    sameX++;
                } else {
                    double slope = (seed.y - point.y + 0.0) / (seed.x - point.x);
                    if (!count.containsKey(slope)) {
                        count.put(slope, 0);
                    }
                    count.put(slope, count.get(slope) + 1);
                    counter = Math.max(counter, count.get(slope));
                }
            }
            counter = Math.max(counter, sameX) + duplicate;
            res = Math.max(counter, res);
        }
        return res;
    }
}




