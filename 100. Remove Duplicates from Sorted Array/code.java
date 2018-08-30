//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

//Do not allocate extra space for another array, you must do this in place with constant memory.

//Example
//Given input array A = [1,1,2],
//Your function should return length = 2, and A is now [1,2].



public class Solution {
    public int removeDuplicates(int[] array) {
        if (array.length < 2) {
            return array.length;
        }

        int slow = 0;

        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
        }
        return slow + 1;
    }    
}



