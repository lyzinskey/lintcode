//Given an unsorted array nums, reorder it in-place such that
//nums[0] <= nums[1] >= nums[2] <= nums[3]....

//Example
//Example 1:
//
//Input: [3, 5, 2, 1, 6, 4]
//Output: [1, 6, 2, 5, 3, 4]
//Explanation: This question may have multiple answers, and [2, 6, 1, 5, 3, 4] is also ok.

//Example 2:
//
//Input: [1, 2, 3, 4]
//Output: [1, 4, 2, 3]

//Notice
//Please complete the problem in-place.



//swap
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// sort
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (i + 1 < nums.length) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    } 
}




