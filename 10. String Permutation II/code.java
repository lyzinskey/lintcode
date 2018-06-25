//Given a string, find all permutations of it without duplicates.

//Example
//Given "abb", return ["abb", "bab", "bba"].
//
//Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].



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
    
    
