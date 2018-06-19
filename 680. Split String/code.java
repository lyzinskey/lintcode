//Give a string, you can choose to split the string after one character or two adjacent characters, 
//and make the string to be composed of only one character or two characters. Output all possible results.

//Example
//Given the string "123"
//return [["1","2","3"],["12","3"],["1","23"]]



    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        } else if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        
        dfs(results, new ArrayList<>(), 0, s);
        
        return results;
    }
    
    private void dfs(List<List<String>> results,
                           List<String> result,
                           int index,
                           String s) {
        if (index == s.length()) {
            results.add(new ArrayList<>(result));
            return;
        }
        
        for (int i = index; i < index + 2 && i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            result.add(substring);
            dfs(results, result, i + 1, s);
            result.remove(result.size() - 1);
        }
    }
    
    
