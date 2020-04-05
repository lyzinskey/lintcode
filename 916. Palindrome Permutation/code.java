//Given a string, determine if a permutation of the string could form a palindrome.

//Example
//Example1
//
//Input: s = "code"
//Output: False
//Explanation: 
//No solution

//Example2
//
//Input: s = "aab"
//Output: True
//Explanation: 
//"aab" --> "aba"

//Example3
//
//Input: s = "carerac"
//Output: True
//Explanation: 
//"carerac" --> "carerac"




public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        int[] array = new int[128];
        for (char ch : s.toCharArray()) {
            array[(int) ch]++;
        }
        int counter = 0;
        for (int num : array) {
            if (num % 2 == 1) {
                counter++;
            }
            if (counter > 1) {
                return false;
            }
        }
        return true;
    }    
}



