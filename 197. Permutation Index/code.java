//Given a permutation which contains no repeated number, 
//find its index in all the permutations of these numbers, 
//which are ordered in lexicographical order. 
//The index begins at 1.

//Example
//Given [1,2,4], return 1.


    public long permutationIndex(int[] A) {
        long permutation = 1;
        long result = 0;
        
        for (int i = A.length - 2; i >= 0; i--) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    smaller++;
                }
            }
            result += permutation * smaller;
            permutation *= A.length - i;
        }
        return result + 1;
    }
    
    
    
