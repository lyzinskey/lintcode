//Implement an algorithm to determine if a string has all unique characters.

//Example
//Given "abc", return true.
//
//Given "aab", return false.

//Challenge
//What if you can not use additional data structures?



// Solution 1
// use boolean array
//
    public boolean isUnique(String str) {
        boolean[] charArray = new boolean[256];
        
        for (int i = 0; i < str.length(); i++) {
            if (charArray[str.charAt(i)]) {
                return false;
            }
            charArray[str.charAt(i)] = true;
        }
        
        return true;
    }
    
    
    
    
    
// Solution 2
// use hashset
//
    public boolean isUnique(String str) {
        char[] charArray = str.toCharArray();
        Set<Character> hashset = new HashSet<>();
        
        for (char c : charArray) {
            if (hashset.contains(c)) {
                return false;
            }
            hashset.add(c);
        }
        return true;
    }
    
    



// Solution 3
// use bit operation
//
    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        int[] bit_vector = new int[8];

        for (int i = 0; i < word.length(); i++) {
            int row = word.charAt(i) / 32;
            int col = word.charAt(i) % 32;
            int weight = 1 << col;
            if ((bit_vector[row] & weight) != 0) {
                return false;
            }
            bit_vector[row] |= weight;
        }
        return true;
    }    

    


