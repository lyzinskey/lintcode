//Merge two sorted (ascending) lists of interval and return it as a new sorted list. The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.

//The intervals in the given list do not overlap.
//The intervals in different lists may overlap.

//Example
//Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].




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

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        
        if (list1 == null || list2 == null) {
            return result;
        }
        
        Interval prev = null;
        Interval curr = null;
        int i = 0;
        int j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                curr = list1.get(i++);
            }
            else {
                curr = list2.get(j++);
            }
            
            prev = merge(result, prev, curr);
        }
        
        while (i < list1.size()) {
            prev = merge(result, prev, list1.get(i++));
        }
        while (j < list2.size()) {
            prev = merge(result, prev, list2.get(j++));
        }
        
        if (prev != null) {
            result.add(prev);
        }
        
        return result;
    }
    
    private Interval merge(List<Interval> result, Interval prev, Interval curr) {
        if (prev == null) {
            return curr;
        }
        
        if (prev.end < curr.start) {
            result.add(prev);
            return curr;
        }
        else {
            prev.end = Math.max(curr.end, prev.end);
            return prev;
        }
    }
}


