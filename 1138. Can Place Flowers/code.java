//Suppose you have a long flowerbed in which some of the pots are planted and some are not. 
//However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

//Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
//and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

//Example
//Example1
//
//Input: flowerbed = [1,0,0,0,1], n = 1
//Output: True

//Example2
//
//Input: flowerbed = [1,0,0,0,1], n = 2
//Output: False

//Notice
//1.The input array won't violate no-adjacent-flowers rule.
//2.The input array size is in the range of [1, 20000].
//3.n is a non-negative integer which won't exceed the input array size.





public class Solution {
    /**
     * @param flowerbed: an array
     * @param n: an Integer
     * @return: if n new flowers can be planted in it without violating the no-adjacent-flowers rule
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                flowerbed[i] = 1;
            }
            if (count >= n) {
                return true;
            }
            i++;
        }
        return false;
    }    
}



