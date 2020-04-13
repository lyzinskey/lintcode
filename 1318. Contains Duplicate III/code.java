//Given an array of integers, 
//find out whether there are two distinct indices i and j in the array 
//such that the absolute difference between nums[i] and nums[j] is at most t 
//and the absolute difference between i and j is at most k.

//Example
//Example1
//
//Input: nums = [1,3,1], k = 1, t = 1
//Output: false
//Explanation: 
//nums[2] = 1, nums[1] = 3, nums[1] - nums[2] = 2 > t
//nums[0] = 1, nums[2] = 1, nums[1] - nums[2] = 0 < t,
//2 - 0 = 2 > k

//Example2
//
//Input: nums = [1,3,1], k = 1, t = 2
//Output: true
//Explanation: 
//nums[2] = 1, nums[1] = 3, nums[1] - nums[2] = 2 = t,
//2 - 1 = 1 = k




public class Solution {
    /**
     * @param nums: the given array
     * @param k: the given k
     * @param t: the given t
     * @return: whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket) 
                || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
                return true;
            }
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}



