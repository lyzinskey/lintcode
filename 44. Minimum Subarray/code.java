//Given an array of integers, find the subarray with smallest sum.

//Return the sum of the subarray.

//The subarray should contain one integer at least.

//Example
//For [1, -1, -2, 1], return -3.


//和Maximum Subarray思路完全相同，只不过计算sum时每次累加的是元素的相反数
//最后得到的最大值的相反数就是最小值
//
    public int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }        
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minSum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            sum -= nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        
        return -max;
    }
    
    
    
