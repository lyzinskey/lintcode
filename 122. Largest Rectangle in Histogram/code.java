//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
//find the area of largest rectangle in the histogram.

//https://lintcode-media.s3.amazonaws.com/problem/histogram1.png
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

//https://lintcode-media.s3.amazonaws.com/problem/histogram_area.png
//The largest rectangle is shown in the shaded area, which has area = 10 unit.

//Example
//Given height = [2,1,5,6,2,3],
//return 10.





public class Solution {
    public int largestRectangleArea(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i <= array.length; i++) {
            int cur = i < array.length ? array[i] : 0;

            while (!stack.isEmpty() && array[stack.peek()] >= cur) {
                int height = array[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                area = Math.max(area, (i - left) * height);
            }
            stack.push(i);
        }
        return area;         
    }
}



