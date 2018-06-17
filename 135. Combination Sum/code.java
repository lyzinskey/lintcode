//Given a set of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums to T.

//The same repeated number may be chosen from C unlimited number of times.

//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.

//Example
//Given candidate set [2,3,6,7] and target 7, a solution set is:
//  
//  [7]
//  [2, 2, 3]



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (candidates == null || target <= 0) {
            return result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, subset);
        
        return result;
    }
    
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> result, ArrayList<Integer> subset) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            //去重，[1, 1, 2, 2，2]保证只使用重复元素的第一个
            //即只用第一个1和第一个2，第二个1和第二第三个2跳过
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            subset.add(candidates[i]);
            //index传i而不是i + 1是因为一个元素可以使用多次
            //注意这里与上方for循环去重的区别
            dfs(candidates, target - candidates[i], i, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
    
    
