//Given an integers array A.

//Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.Out put B

//Example
//For A = [1, 2, 3], return [6, 3, 2].




public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Long> B = new ArrayList<Long>();
        long[] f = new long[len];

        long tmp = 1;
        long now = 1;
        f[len - 1] = A.get(len - 1);
        int i;
        for (i = len - 2; i >= 0; --i) {
            f[i] = A.get(i);
            f[i] = f[i] * f[i + 1];
        }

        for (i = 0; i < len; ++i) {
            now = tmp;
            if (i + 1 < len)
                B.add(now * f[i + 1]);
            else
                B.add(now);
            now = A.get(i);
            tmp = tmp * now;
        }
        return B;
    } 
}



