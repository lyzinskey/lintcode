//We have two integer sequences A and B of the same non-zero length.

//We are allowed to swap elements A[i] and B[i]. 
//Note that both elements are in the same index position in their respective sequences.

//After some number of swaps, A and B are both strictly increasing. 
//(A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)

//Given A and B, return the minimum number of swaps to make both sequences strictly increasing. 
//It is guaranteed that the given input always makes it possible.

//Example
//Example 1:
//
//Input: A = [1,3,5,4], B = [1,2,3,7]
//Output: 1
//Explanation: Swap A[3] and B[3]. Then the sequences are:
//  A = [1,3,5,7] and B = [1,2,3,4],
//  which are both strictly increasing.

//Example 2:
//
//Input: A = [2,4,5,7,10], B = [1,3,4,5,9]
//Output: 0

//Notice
//A, B are arrays with the same length, and that length will be in the range of [1, 1000].
//A[i], B[i] are integer values in the range of [0, 2000].




public class Solution {
    /**
     * @param A: an array
     * @param B: an array
     * @return: the minimum number of swaps to make both sequences strictly increasing
     */
    public int minSwap(int[] A, int[] B) {  
        int swap;
        int keep;
        int prevSwap = 1;
        int prevKeep = 0;        
        
        for (int i = 1; i < A.length; i++) {            
            swap = Integer.MAX_VALUE;
            keep = Integer.MAX_VALUE;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                // best case, no swapping needed
                keep = prevKeep;
                // swapped A[i - 1] and B[i - 1], 
                // swap A[i] and B[i] as well to make everything valid
                swap = prevSwap + 1;
            }
            
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {                
                // swapped A[i - 1] and B[i - 1]
                // no swap needed for A[i] and B[i]
                keep = Math.min(keep, prevSwap);                
                // A[i - 1] and B[i - 1] weren't swapped
                swap = Math.min(swap, prevKeep + 1);
            }
            prevKeep = keep;
            prevSwap = swap;
        }
        return Math.min(prevKeep, prevSwap);
    }
}



