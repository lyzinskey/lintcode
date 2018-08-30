//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?

//For example,
//Given sorted array A = [1,1,1,2,2,3],
//Your function should return length = 5, and A is now [1,1,2,2,3].



public class Solution {
    public int removeDuplicates(int[] array) {
        if (array.length < 3) {
            return array.length;
        }

        int slow = 1;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[++slow] = array[fast];
            }
        }
        return slow + 1;
    }    
}



