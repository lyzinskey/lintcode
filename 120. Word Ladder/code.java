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
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null){
            return 0;
        }

        int length = 1;

        if (start.equals(end)){
            return length;
        }
        
        dict.add(start);
        dict.add(end);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> hashset = new HashSet<>();

        queue.offer(start);
        hashset.add(start);

        while (!queue.isEmpty()){
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWords : getNextWords(word, dict)) {
                    if (nextWords.equals(end)){
                        return length;
                    }
                    
                    if (hashset.add(nextWords)){
                        queue.offer(nextWords);
                    }
                }
            }
        }

        return 0;
    }
    
    
    private ArrayList<String> getNextWords(String word, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++){
                String nextWord = changeCharacter(word, i, c);
                if (dict.contains(nextWord)){
                    nextWords.add(nextWord);
                }
                else {
                    continue;
                }
            }
        }
        return nextWords;
    }    
    
    
    private String changeCharacter(String word, int index, char character){
        char[] charArray = word.toCharArray();
        charArray[index] = character;
        String newWord = new String (charArray);
        return newWord;
    }    
}

