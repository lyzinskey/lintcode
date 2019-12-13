//Koko loves to eat bananas. There are N piles of bananas, the i-th pile has piles[i] bananas. 
//The guards have gone and will come back in H hours.

//Koko can decide her bananas-per-hour eating speed of K. 
//Each hour, she chooses some pile of bananas, and eats K bananas from that pile. 
//If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

//Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

//Return the minimum integer K such that she can eat all the bananas within H hours.

//Example
//Example 1:
//
//Input: piles = [3,6,7,11], H = 8
//Output: 4
//Explanation：6->4*2,7->4*2,11->4*3,3->4*1

//Example 2:
//
//Input: piles = [30,11,23,4,20], H = 5
//Output: 30
//Explanation：4->30*1,11->30*1,20->30*1,23->30*1,30->30*1

//Notice
//1 <= piles.length <= 10^4
//piles.length <= H <= 10^9
//1 <= piles[i] <= 10^9




public class Solution {
    /**
     * @param piles: an array
     * @param H: an integer
     * @return: the minimum integer K
     */
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = getMax(piles);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, H, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(num, max);
        }
        return max;
    }
    
    private boolean canEat(int[] piles, int H, int mid) {
        int hour = 0;
        for (int num : piles) {
            hour += num / mid;
            if (num % mid != 0) {
                hour++;
            }
        }
        return hour <= H;
    }    
}



