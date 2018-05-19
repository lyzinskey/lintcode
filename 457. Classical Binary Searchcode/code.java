//Find any position of a target number in a sorted array. Return -1 if target does not exist.

//Example
//Given [1, 2, 2, 4, 5, 5].
//
//For target = 2, return 1 or 2.
//
//For target = 5, return 4 or 5.
//
//For target = 6, return -1.


public int findPosition(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        if (start > end){
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] < target){
            return binarySearch(nums, mid + 1, end, target);
        }
        if (nums[mid] > target){
            return binarySearch(nums, start, mid - 1, target);
        }
        return mid;
    }
