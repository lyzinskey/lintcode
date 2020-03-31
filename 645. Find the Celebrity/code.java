//Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
//The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

//Now you want to find out who the celebrity is or verify that there is not one. 
//The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" 
//to get information of whether A knows B. 
//You need to find out the celebrity (or verify there is not one) 
//by asking as few questions as possible (in the asymptotic sense).

//You are given a helper function bool knows(a, b) which tells you whether A knows B. 
//Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

//Example
//Example1
//
//Input:
//2 // next n * (n - 1) lines 
//0 knows 1
//1 does not know 0
//Output: 1
//Explanation:
//Everyone knows 1,and 1 knows no one.

//Example2
//
//Input:
//3 // next n * (n - 1) lines 
//0 does not know 1
//0 does not know 2
//1 knows 0
//1 does not know 2
//2 knows 0
//2 knows 1
//Output: 0
//Explanation:
//Everyone knows 0,and 0 knows no one.
//0 does not know 1,and 1 knows 0.
//2 knows everyone,but 1 does not know 2.

//Notice
//There will be exactly one celebrity if he/she is in the party. 
//Return the celebrity's label if there is a celebrity in the party. 
//If there is no celebrity, return -1.




/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    // 每次call knows(a, b)我们都能确定a，b其中一人不是celebrity
    // 如果knows(a, b)返回true，说明a不是celebrity，因为celebrity不认识任何人
    // 如果knows(a, b)返回false，说明b不是celebrity，因为所有人都认识celebrity
    //
    // Time: O(n)
    // Space: O(1)
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        if (isCelebrity(candidate, n)) {
            return candidate;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                continue; // Don't ask if they know themselves.
            }
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }    
}



