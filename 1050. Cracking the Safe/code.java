//There is a box protected by a password. 
//The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.

//You can keep inputting the password, the password will automatically be matched against the last n digits entered.

//For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.

//Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.

//Example
//Example 1:
//
//Input: n = 1, k = 2
//Output: "01"
//Note: "10" will be accepted too.

//Example 2:
//
//Input: n = 2, k = 2
//Output: "00110"
//Note: "01100", "10011", "11001" will be accepted too.

//Notice
//n will be in the range [1, 4].
//k will be in the range [1, 10].
//k^n will be at most 4096.




public class Solution {
    /**
     * @param n: n
     * @param k: k
     * @return: Cracking the Safe
     */
    public String crackSafe(int n, int k) {
        int size = (int) Math.pow(k, n) + n - 1;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            ans.append('0');
        }
        Set<String> visited = new HashSet<>();
        visited.add(ans.toString());
        if (dfs(ans, size, n, k, visited)) {
            return ans.toString();
        }
        return "";
    }

    private boolean dfs(StringBuilder ans, int size, int n, int k, Set<String> visited) {
        if (ans.length() == size) {
            return true;
        }
        StringBuilder node = new StringBuilder(ans.substring(ans.length() - n + 1, ans.length()));
        for (char c = '0'; c < '0' + k; c++) {
            node.append(c);
            if (!visited.contains(node.toString())) {
                String str = node.toString();
                ans.append(c);
                visited.add(str);
                if (dfs(ans, size, n, k, visited)) {
                    return true;
                }
                visited.remove(str);
                ans.deleteCharAt(ans.length() - 1);
            }
            node.deleteCharAt(node.length() - 1);
        }
        return false;
    }    
}



