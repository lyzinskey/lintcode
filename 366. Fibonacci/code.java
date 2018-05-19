//Find the Nth number in Fibonacci sequence.

//A Fibonacci sequence is defined as follow:

//The first two numbers are 0 and 1.
//The i th number is the sum of i-1 th number and i-2 th number.
//The first ten numbers in Fibonacci sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

//Example
//Given 1, return 0

//Given 2, return 1

//Given 10, return 34


public int fibonacci(int n) {
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


//    do not use recursion, or the "Time Limit Exceeded error would occur
//    public int fibonacci(int n) {
//        if (n == 1){
//            return 0;
//        }
//        if (n == 2){
//            return 1;
//        }
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }
