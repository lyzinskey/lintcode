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

        int result = 0;

        for (int i = 0; i < points.length; i++) {
            Point seed = points[i];
            int same = 1;
            int sameX = 0;
            int most = 0;
            HashMap<Double, Integer> cnt = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == seed.x && tmp.y == seed.y) {
                    same++;
                } else if (tmp.x == seed.x) {
                    sameX++;
                } else {
                    double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
                    if (!cnt.containsKey(slope)) {
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, cnt.get(slope));
                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
    }
}



