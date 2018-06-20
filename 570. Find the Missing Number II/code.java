//Giving a string with number from 1-n in random order, but miss 1 number.Find that number.

//n <= 30

//Example
//Given n = 20, str = 19201234567891011121314151618
//return 17



public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    
    private int missing = -1;
     
    public int findMissing2(int n, String str) {
        boolean[] isFound = new boolean[n + 1];
        dfs(n, str, 0, isFound);
        return missing;
    }
    
    private void dfs(int n, String str, int start, boolean[] isFound) {
        // already found answer
        if (missing != -1) {
            return;
        }
        
        // finished the str, get the missing num
        if (start == str.length()) {
            for (int i = 1; i <= n; i++) {
                if (!isFound[i]) {
                    missing = i;
                    return;
                }
            }
            return;
        }
        
        // if first char is 0, the combination is not gonna work
        if (str.charAt(start) == '0') {
            return;
        }
        
        // check single & double chars separately
        for (int ch = 1; ch <= 2 && start + ch <= str.length(); ch++) {
            int num = Integer.parseInt(str.substring(start, start + ch));
            if (num > 0 && num <= n && !isFound[num]) {
                isFound[num] = true;
                dfs(n, str, start + ch, isFound);
                isFound[num] = false;
            }
        }
        
        return;
    }
}

