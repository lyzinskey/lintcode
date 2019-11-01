//We have two special characters. The first character can be represented by one bit 0. 
//The second character can be represented by two bits (10 or 11).

//Now given a string represented by several bits. 
//Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

//Example
//Example 1:
//
//Input: 
//bits = [1, 0, 0]
//Output: True
//Explanation: 
//The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.

//Example 2:
//
//Input: 
//bits = [1, 1, 1, 0]
//Output: False
//Explanation: 
//The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.

//Notice
//1.1 <= len(bits) <= 1000.
//2.bits[i] is always 0 or 1.





public class Solution {
    /**
     * @param bits: a array represented by several bits. 
     * @return: whether the last character must be a one-bit character or not
     */
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
            ones++;
        }
        return ones % 2 == 0;
    }
}



