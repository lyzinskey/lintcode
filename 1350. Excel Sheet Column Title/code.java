//Given a positive integer, return its corresponding column title as appear in an Excel sheet.

//Example
//Example1
//
//Input: 28
//Output: "AB"

//Example2
//
//Input: 29
//Output: "AC"

//Notice
//1 -> A
//2 -> B
//3 -> C
// ...
//26 -> Z
//27 -> AA
//28 -> AB 




public class Solution {
    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }        
        return result.reverse().toString();
    }
}



