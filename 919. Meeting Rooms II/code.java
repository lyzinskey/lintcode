//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
//find the minimum number of conference rooms required.

//Example
//Given intervals = [(0,30),(5,10),(15,20)], return 2.




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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            if (minHeap.peek() <= intervals.get(i).start) {
                minHeap.poll();
            }
            minHeap.offer(intervals.get(i).end);
        }
        return minHeap.size();
    }    
}



