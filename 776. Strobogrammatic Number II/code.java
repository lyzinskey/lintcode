//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//Find all strobogrammatic numbers that are of length = n.

//Example
//Example 1:
//
//Input: n = 2, 
//Output: ["11","69","88","96"]

//Example 2:
//
//Input: n = 1, 
//Output: ["0","1","8"]




public class Solution {
    /**
     * @param n: the length of strobogrammatic number
     * @return: All strobogrammatic numbers
     */
    // Time: O(5^n)
    // Space: O(n)
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    // n: size of sub-problem
    // m: size of total problem
    private List<String> dfs(int n, int m) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }

        List<String> list = dfs(n - 2, m);

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            
            // valid number should start with '0'
            if (n != m) {
                res.add("0" + s + "0");
            }

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }    
}



