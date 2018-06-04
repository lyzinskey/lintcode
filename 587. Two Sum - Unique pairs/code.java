//Given an array of integers, 
//find how many unique pairs in the array such that their sum is equal to a specific target number. 
//Please return the number of pairs.

//Example
//Given nums = [1,1,2,45,46,46], target = 47
//return 2
//
//1 + 46 = 47
//2 + 45 = 47


    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int counter = 0;
        
        while (left < right){
            if (nums[left] + nums[right] == target){
                counter++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            }
            else if (nums[left] + nums[right] < target){
                left++;
            }
            else {
                right--;
            }
        }
        
        return counter;
    }
    
        
