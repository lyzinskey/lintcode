//Given a target number and an integer array sorted in ascending order.
//Find the total number of occurrences of target in the array.

//Example
//Given [1, 3, 3, 4, 5] and target = 3, return 2.
//
//Given [2, 2, 3, 4, 6] and target = 4, return 1.
//
//Given [1, 2, 3, 4, 5] and target = 6, return 0.

//Challenge
//Time complexity in O(logn)


    //use binary search twice to solve this problem
    public int totalOccurrence(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        //first binary search, find the first position of target
        int start = 0;
        int end = nums.length - 1;
        int leftOccurrence = 0;
        int rightOccurrence = 0;

        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                end = mid;
            }
            else if (nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] == target){
            leftOccurrence = start;
        }
        else if (nums[end] == target){
            leftOccurrence = end;
        }
        else {
            return 0;
        }


        //second binary search, find the last position of target
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                start = mid;
            }
            else if (nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[end] == target){
            rightOccurrence = end;
        }
        else if (nums[start] == target){
            rightOccurrence = start;
        }
        else {
            return 0;
        }

        //don't forget to add 1
        return rightOccurrence - leftOccurrence + 1;
    }
    
    
