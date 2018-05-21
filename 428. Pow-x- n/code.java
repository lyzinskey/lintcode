//Implement pow(x, n).

//Example
//Pow(2.1, 3) = 9.261
//Pow(0, 1) = 0
//Pow(1, 0) = 1


    public double myPow(double x, int n) {
        double ans = Integer.MIN_VALUE;
        if (n > 0){
            ans = fastPow(x, n);
        }
        else {
            ans = fastPow(x, -n);
            ans = 1 / ans;
        }
        return ans;
    }

    private static double fastPow(double x, int n){
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            double temp = fastPow(x, n / 2);
            return temp * temp;
        } else {
            double temp = fastPow(x, n / 2);
            return temp * temp * x;
        }
    }
