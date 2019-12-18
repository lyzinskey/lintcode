//Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. 
//Return a list of all possible strings we could create.

//Example
//Example 1:
//
//Input: S = "a1b2"
//Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

//Example 2:
//
//Input: S = "3z4"
//Output: ["3z4", "3Z4"]

//Example 3:
//
//Input: S = "12345"
//Output: ["12345"]

//Notice
//S will be a string with length at most 12.
//S will consist only of letters or digits.




public class Solution {
    /**
     * @param S: a string
     * @return: return a list of strings
     */
    public List<String> letterCasePermutation(String S) {        
        List<String> result = new ArrayList<>();
        if (S == null) {
            return result;
        }
        
        dfs(S.toCharArray(), result, 0);
        return result;
    }
    
    private void dfs(char[] arr, List<String> result, int index) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        
        if (Character.isDigit(arr[index])) {
            dfs(arr, result, index + 1);
            return;
        }
        
        arr[index] = Character.toLowerCase(arr[index]);
        dfs(arr, result, index + 1);
        arr[index] = Character.toUpperCase(arr[index]);
        dfs(arr, result, index + 1);
    }    
}



