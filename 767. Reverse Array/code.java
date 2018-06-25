//Reverse the given array nums inplace.

//Inplace means you can't use extra space.

//Example
//Given nums = [1,2,5]
//return [5,2,1]


    public void reverseArray(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        
        int left = 0; 
        int right = nums.length - 1;
        
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    
