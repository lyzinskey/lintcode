//Given a string, find the first non-repeating character in it and return it's index. 
//If it doesn't exist, return -1.

//Example
//Given s = "lintcode", return 0.
//
//Given s = "lovelintcode", return 2.



    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] charCounter = new int[256];
        char[] character = s.toCharArray();
        for (char c : character) {
            charCounter[c]++;
        }
        
        for (int i = 0; i < character.length; i++) {
            if (charCounter[character[i]] == 1) {
                return i;
            }
        }
        
        return -1;        
    }
    
    
    
