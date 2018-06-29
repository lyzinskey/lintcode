//Implement an algorithm to determine if a string has all unique characters.

//Example
//Given "abc", return true.
//
//Given "aab", return false.

//Challenge
//What if you can not use additional data structures?



    public boolean isUnique(String str) {
        boolean[] charArray = new boolean[250];
        
        for (int i = 0; i < str.length(); i++) {
            if (charArray[str.charAt(i)]) {
                return false;
            }
            charArray[str.charAt(i)] = true;
        }
        
        return true;
    }
    
    
    
    
    
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
    
    
    
