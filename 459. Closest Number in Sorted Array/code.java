//Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

//Return -1 if there is no element in the array.

//Example
//Given [1, 2, 3] and target = 2, return 1.
//
//Given [1, 4, 6] and target = 3, return 1.
//
//Given [1, 4, 6] and target = 5, return 1 or 2.
//
//Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.

//Challenge
//O(logn) time complexity.


    public static int closestNumber(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (Math.abs(nums[start] - target) <= Math.abs(nums[end] - target)){
            return start;
        }
        else {
            return end;
        }
    }
    
    
