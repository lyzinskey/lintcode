//Given an array of strings, group anagrams together.

//Example
//Example 1:
//
//Input:
//["eat","tea","tan","ate","nat","bat"]
//Output:
//[["ate","eat","tea"],
// ["bat"],
// ["nat","tan"]]

//Example 2:
//
//Input:
//["eat","nowhere"]
//Output:
//[["eat"],
// ["nowhere"]]

//Notice
//All inputs will be in lower-case.




public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, List<String>> hashmap = new HashMap<>();
        for (String word : strs) {
            int[] array = new int[26];
            for (char ch : word.toCharArray()) {
                array[ch - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                sb.append("#");
            }
            
            String key = sb.toString();
                        
            if (!hashmap.containsKey(key)) {
                hashmap.put(key, new ArrayList<String>());                                                            
            }
            hashmap.get(key).add(word);
        }
        
        for (List<String> list : hashmap.values()) {
            result.add(list);
        }
        return result;
    }
}




