//Count the number of prime numbers less than a non-negative number, n.




class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                counter++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return counter;
    }
}



