//Some people will make friend requests. 
//The list of their ages is given and ages[i] is the age of the ith person.

//Person A will NOT friend request person B (B != A) if any of the following conditions are true:
//
//age[B] <= 0.5 * age[A] + 7
//age[B] > age[A]
//age[B] > 100 && age[A] < 100
//Otherwise, A will friend request B.
//Note that if A requests B, B does not necessarily request A. Also, people will not friend request themselves.

//How many total friend requests are made?

//Example
//Example 1:
//
//Input: [16,16]
//Output: 2
//Explanation: 2 people friend request each other.

//Example 2:
//
//Input: [16,17,18]
//Output: 2
//Explanation: Friend requests are made 17 -> 16, 18 -> 17.

//Example 3:
//
//Input: [20,30,100,110,120]
//Output: 3
//Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.

//Notice
//1 <= ages.length <= 20000.
//1 <= ages[i] <= 120.




public class Solution {
    /**
     * @param ages: 
     * @return: nothing
     */
    // Time: O(n)
    // Space: O(121)
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] ageCount = new int[121];
        int[] agePrefix = new int[121]; // agePrefix[i]: num of people whose age <= i

        for(int i : ages) {
            ageCount[i]++;
        }

        for(int i = 1; i <= 120; ++i) {
            agePrefix[i] = ageCount[i] + agePrefix[i - 1];
        }

        // 0.5A + 7 <= B < A    =>  A > 14, that's why i starts from 15
        for(int i = 15; i <= 120; ++i) {
            if(ageCount[i] == 0) {
                continue;
            }
            int count = agePrefix[i] - agePrefix[i / 2 + 7];
            res += count * ageCount[i] - ageCount[i]; //people will not friend request themselves, so  - ageCount[i]
        }
        return res;
    }        
}



