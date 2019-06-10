//Given a list of sorted characters letters containing only lowercase letters, 
//and given a target letter target, find the smallest element in the list that is larger than the given target.

//Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

//Example
//Example 1:
//
//Input:
//letters = ["c", "f", "j"]
//target = "a"
//Output: "c"

//Example 2:
//
//Input:
//letters = ["c", "f", "j"]
//target = "c"
//Output: "f"

//Example 3:
//
//Input:
//letters = ["c", "f", "j"]
//target = "d"
//Output: "f"

//Example 4:
//
//Input:
//letters = ["c", "f", "j"]
//target = "g"
//Output: "j"

//Example 5:
//
//Input:
//letters = ["c", "f", "j"]
//target = "j"
//Output: "c"

//Example 6:
//
//Input:
//letters = ["c", "f", "j"]
//target = "k"
//Output: "c"

//Notice
//1.letters has a length in range [2, 10000].
//2.letters consists of lowercase letters, and contains at least 2 unique letters.
//3.target is a lowercase letter.



public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length;
        
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return letters[start % letters.length];
    }    
}



