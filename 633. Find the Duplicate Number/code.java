//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
//prove that at least one duplicate number must exist. 
//Assume that there is only one duplicate number, find the duplicate one.

//Example
//Given nums = [5,5,4,3,2,1] return 5
//Given nums = [5,4,4,3,2,1] return 4

//Notice
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n^2).
//There is only one duplicate number in the array, but it could be repeated more than once.




public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                return Math.abs(nums[i]);
            }
            else {
                nums[index] = -nums[index];
            }
        }
        return nums[nums.length - 1];
    }    
}



