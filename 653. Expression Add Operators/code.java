//Given a string that contains only digits 0-9 and a target value, 
//return all possibilities to add binary operators (not unary) +, -, or * between the digits 
//so they evaluate to the target value.

//Example
//"123", 6 -> ["1+2+3", "1*2*3"] 
//"232", 8 -> ["2*3+2", "2+3*2"]
//"105", 5 -> ["1*0+5","10-5"]
//"00", 0 -> ["0+0", "0-0", "0*0"]
//"3456237490", 9191 -> []




public class Solution {
    /**
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    // Time: O(n^2 * 4^(n - 1))
    // Space: O(n^2)
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }

    public void dfs(List<String> res, StringBuilder path, String num, int target, int index, long curr, long prev) {
        if (index == num.length()) {
            if (target == curr) {
                res.add(path.toString());
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            // corner case: if current position is 0, we can only use it as a single digit number, should be 0
            // if it is not a single digit number with leading 0, it should be considered as an invalid number             
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long temp = Long.parseLong(num.substring(index, i + 1));
            int len = path.length();
            // position 0 should be considered individually, since it does not have any operand character before curNum
            if (index == 0) {
                dfs(res, path.append(temp), num, target, i + 1, temp, temp);
                path.setLength(len);
            } else {
                dfs(res, path.append("+").append(temp), num, target, i + 1, curr + temp, temp);
                path.setLength(len);
                dfs(res, path.append("-").append(temp), num, target, i + 1, curr - temp, -temp);
                path.setLength(len);
                dfs(res, path.append("*").append(temp), num, target, i + 1, curr - prev + prev * temp, prev * temp);
                path.setLength(len);
            }
        }
    }
}



