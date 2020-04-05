//Write a function that takes a string as input and reverse only the vowels of a string.

//Example
//Example 1:
//
//Input : s = "hello"
//Output :  "holle"

//Example 2:
//
//Input : s = "lintcode"
//Output : "lentcodi".

//Notice
//The vowels does not include the letter "y".




public class Solution {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int first = 0;
        int last = s.length() - 1;
        char[] array = s.toCharArray();
        
        while(first < last){
            while(first < last && vowels.indexOf(array[first]) == -1){
                first++;
            }
            while(first < last && vowels.indexOf(array[last]) == -1){
                last--;
            }
            char temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
        return new String(array);
    }
}



