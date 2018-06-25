//Given a string, find all permutations of it without duplicates.

//Example
//Given "abb", return ["abb", "bab", "bba"].
//
//Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].


    //recursion
    //
    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<>();
        
        if (str == null) {
            return result;
        }
        
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        dfs(sb, result, charArray, new boolean[str.length()]);
        return result;
    }
    
    private void dfs(StringBuilder sb, List<String> result, char[] charArray, boolean[] visited) {
        if (charArray.length == sb.length()) {
            result.add(new String(sb));
            return;
        }
        
        for (int i = 0; i < charArray.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && charArray[i] == charArray[i - 1] && !visited[i - 1]) {
                continue;
            }
            sb.append(charArray[i]);
            visited[i] = true;
            dfs(sb, result, charArray, visited);
            visited[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
    
    


    //non-recursion
    //
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        char[] s = str.toCharArray();
        Arrays.sort(s);
        result.add(String.valueOf(s));
        while ((s = nextPermutation(s)) != null) {
            result.add(String.valueOf(s));
        }
        return result;
    }

    public char[] nextPermutation(char[] nums) {
        int index = -1;
        for(int i = nums.length -1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                index = i-1;
                break;
            }
        }
        if(index == -1){
            return null;
        }
        for(int i = nums.length -1; i > index; i--){
            if(nums[i] > nums[index]){
                char temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        reverse(nums,index+1,nums.length-1);
        return nums;
        
    }

    public void reverse(char[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

