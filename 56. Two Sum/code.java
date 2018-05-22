//Given an array of integers, find two numbers such that they add up to a specific target number.

//The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2.
// Please note that your returned answers (both index1 and index2) are zero-based.

//Example
//numbers=[2, 7, 11, 15], target=9
//
//return [0, 1]


    // using HashMap
    // O(n) Space, O(n) Time
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    
    
