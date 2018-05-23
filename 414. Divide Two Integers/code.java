//Divide two integers without using multiplication, division and mod operator.

//If it is overflow, return 2147483647

//Example
//Given dividend = 100 and divisor = 9, return 11.


    //based on long division
    //reference: https://stackoverflow.com/questions/5386377/division-without-using
    public int divide(int dividend, int divisor) {
        //corner case
        if (divisor == 0){
            if (dividend >= 0){
                return Integer.MAX_VALUE;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }
        if (divisor == 1){
            return dividend;
        }

        if (dividend == 0){
            return 0;
        }

        //pay attention to this corner case!!!
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        //since we will change dividend and divisor to unsigned number
        //so check whether the answer should be negative first
        boolean negative = false;
        if (dividend > 0 && divisor < 0){
            negative = true;
        }
        if (dividend < 0 && divisor > 0){
            negative = true;
        }

        //change dividend and divisor to positive (unsigned)
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        int currentBit = 1;
        int ans = 0;

        while ((longDivisor << 1) <= longDividend){
            currentBit <<= 1;
            longDivisor <<= 1;
        }

        while (currentBit != 0){
            if (longDividend >= longDivisor){
                longDividend -= longDivisor;
                ans += currentBit;
            }
            currentBit >>= 1;
            longDivisor >>= 1;
        }

        if (negative){
            return -ans;
        }
        else {
            return ans;
        }
    }
    
    
