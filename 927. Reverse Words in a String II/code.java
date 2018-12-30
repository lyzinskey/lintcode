//Given an input character array, reverse the array word by word. 
//A word is defined as a sequence of non-space characters.

//The input character array does not contain leading or trailing spaces 
//and the words are always separated by a single space.

//Example
//Given s = "the sky is blue",
//after reversing : "blue is sky the"

//Challenge
//Could you do it in-place without allocating extra space?




class Solution {
    public char[] reverseWords(char[] charArray) {        
        reverse(charArray, 0, charArray.length - 1);

        int space = 0;
        for (int i = 0; i < charArray.length; i++) {
            // 待翻转单词的第一个字母
            if (charArray[i] != ' ' && (i == 0 || charArray[i - 1] == ' ')) {
                space = i;
            }
            // 待翻转单词的最后一个字母
            if (charArray[i] != ' ' && (i == charArray.length - 1 || charArray[i + 1] == ' ')) {
                reverse(charArray, space, i);
            }
        }        
        return charArray;
    }

    private void reverse(char[] charArray, int left, int right) {
        while (left < right) {
            swap(charArray, left++, right--);
        }
    }

    private void swap(char[] charArray, int left, int right) {
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
    }    
}



