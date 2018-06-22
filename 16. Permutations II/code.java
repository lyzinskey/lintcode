//Given a list of numbers with duplicate number in it. Find all unique permutations.

//Example
//For numbers [1,2,2] the unique permutations are:
//  
//  [
//    [1,2,2],
//    [2,1,2],
//    [2,2,1]
//  ]

//Challenge
//Using recursion to do it is acceptable. If you can do it without recursion, that would be great!



    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, result, new boolean[nums.length], new ArrayList<Integer>());
        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, boolean[] visited, ArrayList<Integer> list) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<Integer> (list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }   
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, result, visited, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
    
