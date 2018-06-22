//Given a list of integers, which denote a permutation.

//Find the next permutation in ascending order.

//The list may contains duplicate integers.

//Example
//For [1,3,2,3], the next permutation is [1,3,3,2]
//
//For [4,3,2,1], the next permutation is [1,2,3,4]



    public int[] nextPermutation(int[] nums) {
        int len = nums.length;
        
        if (nums == null || len <= 1) {
            return nums;
        }
        
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        
        if (i > 0) {
            int j = len - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swapItems(nums, i - 1, j);
        }
        swapList(nums, i, len - 1);
        return nums;
    }
    
    private void swapItems(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItems(nums, i, j);
            i++;
            j--;
        }
    }
    
    
