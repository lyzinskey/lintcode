//Given a collection of intervals, merge all overlapping intervals.

//Example
//Given intervals => merged intervals:
//
//  [                     [
//    (1, 3),               (1, 6),
//    (2, 6),      =>       (8, 10),
//    (8, 10),              (15, 18)
//    (15, 18)            ]
//  ]

//Challenge
//O(n log n) time and O(1) extra space.


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0){
            return intervals;
        }
        
        intervals.sort(new myComparator());

        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= lastEnd){
                lastEnd = Math.max(intervals.get(i).end, lastEnd);
                intervals.remove(i);
                intervals.get(i - 1).end = lastEnd;
                i--;
            }
            else {
                lastStart = intervals.get(i).start;
                lastEnd = intervals.get(i).end;
            }
        }
        
        return intervals;
    }    
}

class myComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }
}

