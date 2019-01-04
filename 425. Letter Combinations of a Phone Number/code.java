//Given a digit string excluded 01, return all possible letter combinations that the number could represent.

//A mapping of digit to letters (just like on the telephone buttons) is given below.

//Cellphone
//https://lintcode-media.s3.amazonaws.com/problem/200px-Telephone-keypad2.svg.png

//Although the above answer is in lexicographical order, your answer could be in any order you want.

//Example
//Given "23"
//Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]



// Recursion, DFS
public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });                
        
        dfs(digits, result, map, new StringBuilder());
        
        return result;
    }
    
    private void dfs(String digits, List<String> result, Map<Character, char[]> map, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(new String(sb));
            return;
        }
        
        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            dfs(digits, result, map, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}




// Iteration, BFS
public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        
        if (digits.length() == 0) {
            return list;
        }
        
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        
        while (list.peek().length() != digits.length()) {
            String peak = list.remove();
            String map = mapping[digits.charAt(peak.length()) - '0'];
            char[] charArray = map.toCharArray();
            for (char ch : charArray) {
                list.add(peak + ch);
            }
        }
        return list;
    }
}



