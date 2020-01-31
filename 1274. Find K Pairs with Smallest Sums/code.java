//You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

//Define a pair (u,v) which consists of one element from the first array and one element from the second array.

//Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

//Return results need to be orderly.

//Example
//Example 1:
//Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
//
//Return: [1,2],[1,4],[1,6]
//
//The first 3 pairs are returned from the sequence:
//[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

//Example 2:
//Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
//
//Return: [1,1],[1,1]
//
//The first 2 pairs are returned from the sequence:
//[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

//Example 3:
//Given nums1 = [1,2], nums2 = [3],  k = 3 
//
//Return: [1,3],[2,3]
//
//All possible pairs are returned from the sequence:
//[1,3],[2,3]





public class Solution {
    /**
     * @param nums1: List[int]
     * @param nums2: List[int]
     * @param k: an integer
     * @return: return List[List[int]]
     */
    // Time: O(klogk)
    // Space: O(k)    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return res;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] + a[1] == b[0] + b[1]) {
                    return a[0] - b[0];
                }
                return a[0] + a[1] - b[0] - b[1];
            }
        });
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }
        
        while(k > 0 && !pq.isEmpty()) {
            int[] nums = pq.poll();
            res.add(Arrays.asList(nums[0], nums[1]));
            int index = nums[2];
            if (index + 1< nums2.length) {
                pq.offer(new int[] {nums[0], nums2[index + 1], index + 1});
            }
            k--;
        }
        return res;
    }
}




