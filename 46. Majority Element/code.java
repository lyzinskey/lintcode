//Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

//Example
//Given [1, 1, 1, 1, 2, 2, 2], return 1

//Challenge
//O(n) time and O(1) extra space

//Notice
//You may assume that the array is non-empty and the majority number always exist in the array.




public class Solution {
    public int majorityNumber(List<Integer> array) {
        int counter = 0;
        int major = array.get(0);
    
        for (int i = 0; i < array.size(); i++) {
            if (counter != 0) {
                if (array.get(i) == major) {
                counter++;
                } else {
                    counter--;
                }
            } else {
                major = array.get(i);
                counter++;
            }
        }
        return major;        
    }
}



