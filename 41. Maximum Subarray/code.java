//Given an array of integers, find a contiguous subarray which has the largest sum.

//The subarray should contain at least one number.

//Example
//Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

//Challenge
//Can you do it in time complexity O(n)?


    // 思路：Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
    // PrefixSum[j + 1]的值是固定的，就是前j个数的和，
    // 因此想让Sum(i~j)最大，PrefixSum[i]必须最小
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // sum相当于PrefixSum[j + 1]，每次累加数组中的元素            
            sum += nums[i];
            
            // max相当于Sum(i~j)，
            // 不停更新PrefixSum[j + 1] - PrefixSum[i]以保持最大            
            max = Math.max(max, sum - minSum);
            
            // 找到最小的PrefixSum[i]            
            minSum = Math.min(minSum, sum);
        }
        
        return max;
    }
    
    
    
    // DP
    //
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        
        
        int lastmax = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            lastmax = Math.max(nums[i], nums[i] + lastmax);
            max = Math.max(max, lastmax);
        }
        
        return max;
    }



