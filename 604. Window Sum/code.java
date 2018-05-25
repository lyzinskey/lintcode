//Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

//Example
//For array [1,2,7,8,5], moving window size k = 3.
//1 + 2 + 7 = 10
//2 + 7 + 8 = 17
//7 + 8 + 5 = 20
//return [10,17,20]


    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        if (nums.length <= k){
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return new int[] {sum};
        }
        
        int left = 1;
        int right = k;
        int sum = 0;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result[0] = sum;
        
        while (right < nums.length){
            sum = sum + (nums[right] - nums[left - 1]);
            result[left] = sum;
            left++;
            right++;
        }
        return result;
    }
    
    
