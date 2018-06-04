//Find K-th largest element in an array.

//Example
//In array [9,3,2,4,8], the 3rd largest element is 4.
//
//In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

//Challenge
//O(n) time, O(1) extra memory.


    public int kthLargestElement(int k, int[] nums) {
        int low = 0, high = nums.length -1;
        while(low <= high){  
            int pivot = nums[high];
            int index = low-1;
            for(int i = low; i < high; i++){
                if(nums[i] > nums[high]){
                    swap(nums, i, ++index);
                }
            }
            swap(nums, ++index, high);
            if(index == k - 1){
                return nums[index];
            }
            if(index < k -1){
                low = index + 1;
            }else{
                high = index - 1;
            }
        }
        return -1; 
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    
