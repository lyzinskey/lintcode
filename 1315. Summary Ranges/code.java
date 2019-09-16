//Given a sorted integer array without duplicates, return the summary of its ranges.

//Example
//Example1
//
//Input: [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]

//Example2
//
//Input: [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]

//Notice
//The result is in ascending order




public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                result.add(nums[i] + "");
            } else {
                result.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return result;
    }
}



