//Given a unsorted array with integers, find the median of it.

//A median is the middle number of the array after it is sorted.

//If there are even numbers in the array, return the N/2-th number after sorted.

//Example
//Given [4, 5, 1, 2, 3], return 3.

//Given [7, 9, 4, 5], return 5.

//Challenge
//O(n) time.



// 基于lintcode 5. Kth Largest Element
public class Solution {
    public int median(int[] nums) {
        int kth = nums.length / 2 + 1;
        int low = 0, high = nums.length - 1;
        
        while(low <= high){  
            int pivot = nums[high];
            int index = low-1;
            //把所有比pivot大的数字全部集中在左侧
            for(int i = low; i < high; i++){
                if(nums[i] > nums[high]){
                    swap(nums, i, ++index);
                }
            }
            
            //让index左侧全是大于pivot的数，右侧全是小于pivot的数
            swap(nums, ++index, high);
            if(index == kth - 1){
                return nums[index];
            }
            if(index < kth - 1){
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
}


