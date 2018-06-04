//Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

//All elements < k are moved to the left
//All elements >= k are moved to the right
//Return the partitioning index, i.e the first index i nums[i] >= k.

//Example
//If nums = [3,2,2,1] and k=2, a valid answer is 1.

//Challenge
//Can you partition the array in-place and in O(n)?


    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        
        int left = 0;
        int pointer = 0;
        int right = nums.length - 1;
        
        while (pointer <= right){
            if (nums[pointer] == k){
                pointer++;
            }
            else if (nums[pointer] < k){
                swap(nums, left, pointer);
                left++;
                pointer++;
            }
            else {
                swap(nums, pointer, right);
                right--;
            }
        }
        return left;
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    
