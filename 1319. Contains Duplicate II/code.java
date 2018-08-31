//Given an array of integers and an integer k, 
//find out whether there are two distinct indices i and j in the array 
//such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

//Example
//Given nums = [1,2,1], k = 0, return false.



public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hashset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashset.contains(nums[i])) {
                return true;
            }
            hashset.add(nums[i]);
            if (hashset.size() > k) {
                hashset.remove(nums[i - k]);
            }
        }
        return false;
    }    
}



