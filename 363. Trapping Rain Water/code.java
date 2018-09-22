//Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it is able to trap after raining.

//https://lintcode-media.s3.amazonaws.com/problem/rainwatertrap.png

//Example
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

//Challenge
//O(n) time and O(1) memory
//O(n) time and O(n) memory is also acceptable.




public class Solution {
    public int trapRainWater(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
    
        int[] left = new int[array.length];
        int[] right = new int[array.length];
    
        left[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            left[i] = Math.max(left[i - 1], array[i]);
        }
        right[right.length - 1] = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], array[i]);
        }
    
        int[] water = new int[array.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            water[i] = Math.min(left[i], right[i]) - array[i];
            sum += water[i];
        }
        return sum;
    }    
}



