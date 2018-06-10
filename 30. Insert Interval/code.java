//Given a non-overlapping interval list which is sorted by start point.

//Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

//Example
//Insert (2, 5) into [(1,2), (5,9)], we get [(1,9)].
//
//Insert (3, 4) into [(1,2), (5,9)], we get [(1,2), (3,4), (5,9)].


/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null){
            return intervals;
        }

        List<Interval> mergedList = new ArrayList<>();

        if (intervals == null || intervals.size() == 0){
            mergedList.add(newInterval);
            return mergedList;
        }

        intervals.add(newInterval);
        intervals.sort(new myComparator());

        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= lastEnd){
                lastEnd = Math.max(intervals.get(i).end, lastEnd);
            }
            else {
                mergedList.add(new Interval(lastStart, lastEnd));
                lastStart = intervals.get(i).start;
                lastEnd = intervals.get(i).end;
            }
        }
        
        mergedList.add(new Interval(lastStart, lastEnd));
        
        return mergedList;
    }
}

class myComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }
}

