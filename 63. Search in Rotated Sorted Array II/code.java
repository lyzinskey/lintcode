//Follow up for Search in Rotated Sorted Array:

//What if duplicates are allowed?

//Would this affect the run-time complexity? How and why?

//Write a function to determine if a given target is in the array.

//Example
//Example 1:
//
//Input:
//[]
//1
//Output:
//false

//Example 2:
//
//Input:
//[3,4,4,5,7,0,1,2]
//4
//Output:
//true




public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
     
    // Time: avg O(logn), worst case O(n)
    // Space: O(1) 
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0;
        int right = nums.length - 1;        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            /*
            The only difference is that due to the existence of duplicates, 
            we can have nums[left] == nums[mid] and in that case, 
            the first half could be out of order 
            (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) 
            and we have to deal this case separately. 
            In that case, it is guaranteed that nums[right] also equals to nums[mid], 
            so what we can do is to check if nums[mid]== nums[left] == nums[right] 
            before the original logic,
            and if so, we can move left and right both towards the middle by 1. and repeat.
            */            
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }    
}



