//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array, 
//and it should return false if every element is distinct.

//Example
//Given nums = [1,1], return ture.



public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        
        for (int num : nums) {
            if (hashset.contains(num)) {
                return true;
            }
            hashset.add(num);
        }
        return false;
    }
}



