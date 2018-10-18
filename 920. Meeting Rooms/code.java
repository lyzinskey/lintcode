//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
//determine if a person could attend all meetings.

//Example
//Given intervals = [[0,30],[5,10],[15,20]], return false.




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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        
        Collections.sort(intervals, new myComparator());

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }
    
    private class myComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval interval1, Interval interval2) {
            return interval1.start - interval2.start;
        }
    }    
}



