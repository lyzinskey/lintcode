//Given an integer array, find the top k largest numbers in it.

//Example
//Given [3,10,1000,-99,4,100] and k = 3.
//Return [1000, 100, 10].



public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, new topkComparator());

        for (int i : nums) {
            minheap.offer(i);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[k - i - 1] = minheap.poll();
        }
        return result;
    }
}

class topkComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}


