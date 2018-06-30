//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

//You may assume NO duplicates in the array.

//Example
//  [1,3,5,6], 5 → 2
//  
//  [1,3,5,6], 2 → 1
//  
//  [1,3,5,6], 7 → 4
//  
//  [1,3,5,6], 0 → 0

//Challenge
//O(log(n)) time



    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] < target) {
                left = mid;
            }
            
            if (nums[mid] > target) {
                right = mid;
            }
        }
        
        if (nums[left] >= target) {
            return left;
        }
        else if (nums[right] >= target){
            return right;
        }
        else {
            return right + 1;
        }
    }
    
    
