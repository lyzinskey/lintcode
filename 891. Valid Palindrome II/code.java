//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

//Example
//Given s = "aba" return true
//Given s = "abca" return true // delete c


    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    
