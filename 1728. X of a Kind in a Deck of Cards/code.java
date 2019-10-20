//In a deck of cards, each card has an integer written on it.

//Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

//Each group has exactly X cards.
//All the cards in each group have the same integer.

//Example
//Example1
//
//Input: [1,2,3,4,4,3,2,1]
//Output: true
//Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]

//Example2:
//
//Input: [1,1,1,2,2,2,3,3]
//Output: false
//Explanation: No possible partition.

//Example3:
//
//Input: [1]
//Output: false
//Explanation: No possible partition.

//Notice
//1 <= deck.length <= 10000
//0 <= deck[i] < 10000





public class Solution {
    /**
     * @param deck: a integer array
     * @return: return a value of bool
     */
    public boolean hasGroupsSizeX(List<Integer> deck) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < deck.size(); i++) {
            if (!hashmap.containsKey(deck.get(i))) {
                hashmap.put(deck.get(i), 0);
            }
            hashmap.put(deck.get(i), hashmap.get(deck.get(i)) + 1);
        }
        
        int common = hashmap.get(deck.get(0));
        for (int key : hashmap.keySet()) {
            common = gcd(common, hashmap.get(key));
        }
        return common >= 2;
    }
    
    // private int gcd(int a, int b) {
    //     int gcd = 1;
    //     for (int i = 1; i < Math.min(a, b); i++) {
    //         if (a % (i + 1) == 0 && b % (i + 1) == 0) {
    //             gcd = i + 1;
    //         }
    //     }
    //     return gcd;
    // }  
    
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}



