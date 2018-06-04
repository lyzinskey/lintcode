//Find the kth smallest numbers in an unsorted integer array.

//Example
//Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

//Challenge
//Do it in O(n).


    public int kthSmallest(int k, int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low <= high){  
            int pivot = nums[high];
            int index = low-1;
            //把所有比pivot小的数字全部集中在左侧
            for(int i = low; i < high; i++){
                if(nums[i] < nums[high]){
                    swap(nums, i, ++index);
                }
            }
            
            //让index左侧全是小于pivot的数，右侧全是大于pivot的数
            swap(nums, ++index, high);
            if(index == k - 1){
                return nums[index];
            }
            if(index < k - 1){
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
    
    
