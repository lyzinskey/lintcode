//Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
//Your code should return the index of the first number and the index of the last number. 
//(If their are duplicate answer, return the minimum one in lexicographical order)

//Example
//Example 1:
//
//Input: [-3, 1, 3, -3, 4]
//Output: [1, 4]

//Example 2:
//
//Input: [0, 1, 0, 1]
//Output: [0, 3]
//Explanation: The minimum one in lexicographical order.




public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
                start = i;
                end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (max < sum) {
                max = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }
}



