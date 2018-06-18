//Given n unique integers, number k (1<=k<=n) and target.

//Find all possible k integers where their sum is target.

//Example
//Given [1,2,3,4], k = 2, target = 5. Return:
//
//  [
//    [1,4],
//    [2,3]
//  ]


public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param targer: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] candidates, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (candidates == null || target <= 0) {
            return result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, subset, k);
        
        return result;        
    }
    
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> result, ArrayList<Integer> subset, int k) {
        if (target == 0) {
            if (subset.size() == k) {
                result.add(new ArrayList<Integer>(subset));
            }
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            subset.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, result, subset, k);
            subset.remove(subset.size() - 1);
        }
    }     
}

