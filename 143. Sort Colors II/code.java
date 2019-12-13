//Given an array of n objects with k different colors (numbered from 1 to k), 
//sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

//Example
//Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

//Challenge
//A rather straight forward solution is a two-pass algorithm using counting sort. 
//That will cost O(k) extra memory. Can you do it without using extra memory?

//Notice
//You are not suppose to use the library's sort function for this problem.
//k <= n




public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] array, int k) {
        if (array.length <= 2 || k < 2) {
            return;
        }

        sort(array, 0, array.length - 1, 1, k);
    }

    private void sort(int[] array, int left, int right, int min, int max) {
        if (left + 1 > right || min >= max) {
            return;
        }

        int i = left;
        int j = right;
        int mid = min + (max - min) / 2;
        while (i < j) {
            if (array[i] <= mid) {
                i++;
            } else if (array[j] > mid) {
                j--;
            } else {
                swap(array, i, j);
            }
        }
        sort(array, left, i, min, mid);
        sort(array, j, right, mid + 1, max);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}



