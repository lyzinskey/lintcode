//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

//You may assume that the array does not change.
//There are many calls to sumRange function.

//Example
//Given nums = [-2, 0, 3, -5, 2, -1]

//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3



class NumArray {

    private int[] sum;
    
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        int subSum = 0;
        for (int i = 1; i < sum.length; i++) {
            subSum += nums[i - 1];
            sum[i] = subSum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 
 
 
