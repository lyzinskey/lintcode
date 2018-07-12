//Given an array of integers and an integer k, 
//you need to find the total number of continuous subarrays whose sum equals to k.

//Example
//Input:nums = [1,1,1], k = 2
/Output: 2


    public int subarraySumEqualsK(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int sum = 0;
        int counter = 0;
        hashmap.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (hashmap.containsKey(sum - k)) {
                counter += hashmap.get(sum - k);
            }
            
            if (hashmap.containsKey(sum)) {
                hashmap.put(sum, hashmap.get(sum) + 1);
            }
            else {
                hashmap.put(sum, 1);
            }
        }
        
        return counter;
    }
    
    
    
