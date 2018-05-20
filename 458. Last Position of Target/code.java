//Find the last position of a target number in a sorted array. Return -1 if target does not exist.
//
//Example
//Given [1, 2, 2, 4, 5, 5].
//
//For target = 2, return 2.
//
//For target = 5, return 5.
//
//For target = 6, return -1.


public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        //the statement inside while loop should be "start + 1 < end", not "start < end",
        //or there would be endless while loop

        //Example: nums = [1, 1], target = 1
        //start = 0, end = 1, mid = 0, the first if statement will always be true,
        //and there's no way to jump out of this loop.
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                start = mid;  //this line cannot be "start = mid + 1",
                // because it is possible that the second half does not contain target.
                //Example: nums = [1, 2], target = 1
                //start = 0, end = 1, mid = 0,
                // after the first loop, start = 1, mid = 1,
                //the program will return -1, which is a wrong answer.
            }
            else if (nums[mid] < target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if (nums[end] == target){
            return end;
        }
        if (nums[start] == target){
            return start;
        }
        return -1;
    }
