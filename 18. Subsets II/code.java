//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

//Each element in a subset must be in non-descending order.
//The ordering between two subsets is free.
//The solution set must not contain duplicate subsets.

//Example
//Input: [1,2,2]
//Output:
//  
//  [
//    [2],
//    [1],
//    [1,2,2],
//    [2,2],
//    [1,2],
//    []
//  ]

//Challenge
//Can you do it in both recursively and iteratively?



public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null) {
            return result;
        }
        
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        
        dfs(nums, result, 0, new ArrayList<Integer>());

        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, int index, ArrayList<Integer> subset) {
        result.add(new ArrayList<Integer> (subset));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            subset.add(nums[i]);
            dfs(nums, result, i + 1, subset);
            subset.remove(subset.size() - 1);            
        }
    }
}

