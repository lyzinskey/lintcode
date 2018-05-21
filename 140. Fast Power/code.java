//Calculate the a^n % b where a, b and n are all 32bit integers.

//Example
//For 231 % 3 = 2
//For 1001000 % 1000 = 0


    public int fastPower(int a, int b, int n) {
        int ans = Integer.MIN_VALUE;
        if (n > 0){
            ans = myPow(a, b, n);
        }
        else {
            ans = myPow(a, b, -n);
            if (ans == 0){
                return 0;
            }
            ans = 1 / ans;
        }
        return ans;
    }

    //recursion solution
    private static int myPow(int a, int b, int n){
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }

        long product = myPow(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }
