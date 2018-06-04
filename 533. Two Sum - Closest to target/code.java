//Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

//Return the difference between the sum of the two integers and the target.

//Example
//Given array nums = [-1, 2, 1, -4], and target = 4.
//
//The minimum difference is 1. (4 - (2 + 1) = 1).

//Challenge
//Do it in O(nlogn) time complexity.


    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return 0;
        }

        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int difference = Math.abs(target - (nums[left] + nums[right]));
            if (nums[left] + nums[right] == target){
                return 0;
            }
            else if (nums[left] + nums[right] < target){
                left++;
                if (difference < closest){
                    closest = difference;
                }
            }
            else {
                right--;
                if (difference < closest){
                    closest = difference;
                }
            }
        }
        
        return closest;
    }
    
    
