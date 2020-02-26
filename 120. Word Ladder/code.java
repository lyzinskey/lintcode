//Given two words (start and end), and a dictionary, 
//find the length of shortest transformation sequence from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.

//Example
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.





public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    // Time: O(n * 26^l)  n: lengh of wordList, l: 
    // Space: O(n)
    public int ladderLength(String beginWord, String endWord, Set<String> dict) {
        if (beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int step = 0;

        while (!set1.isEmpty() && !set2.isEmpty()) {
            step++;
            Set<String> delete = new HashSet<>();
            Set<String> add = new HashSet<>();
            int counter = 0;
            int size;
            if (set1.size() < set2.size()) {
                size = set1.size();
                for (String word : set1) {
                    counter++;
                    delete.add(word);
                    if (expand(dict, word, set1, visited, set2, add)) {
                        return step + 1;
                    }
                    if (counter >= size) {
                        break;
                    }
                }
                update(set1, delete, add);
            } else {
                size = set2.size();
                for (String word : set2) {
                    counter++;
                    delete.add(word);
                    if (expand(dict, word, set2, visited, set1, add)) {
                        return step + 1;
                    }
                    if (counter >= size) {
                        break;
                    }
                }
                update(set2, delete, add);
            }
        }
        return 0;
    }

    private boolean expand(Set<String> dict, String word, Set<String> expandSet, Set<String> visited, Set<String> set, Set<String> add) {
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            for (char j = 'a'; j < 'z'; j++) {
                array[i] = j;
                String temp = new String(array);
                if (set.contains(temp)) {
                    return true;
                }
                if (visited.contains(temp) || !dict.contains(temp)) {
                    continue;
                }
                add.add(temp);
                visited.add(temp);
            }
            array[i] = ch;
        }
        return false;
    }

    private void update(Set<String> set, Set<String> delete, Set<String> add) {
        for (String word : delete) {
            set.remove(word);
        }
        for (String word : add) {
            set.add(word);
        }
    }
}




