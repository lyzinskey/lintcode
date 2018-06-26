//Given a pattern and a string str, find if str follows the same pattern.

//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

//Example
//Given pattern = "abba", str = "dog cat cat dog", return true.
//Given pattern = "abba", str = "dog cat cat fish", return false.
//Given pattern = "aaaa", str = "dog cat cat dog", return false.
//Given pattern = "abba", str = "dog dog dog dog", return false.



    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        char[] c = pattern.toCharArray();
        
        if (words.length != c.length) {
            return false;
        }        
        
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(c[i])) {
                if (!map.get(c[i]).equals(words[i])) {
                    return false;
                }
                continue;
            }
            else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(c[i], words[i]);
            }
        }
        return true;
    }
    
    
