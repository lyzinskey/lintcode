//Prime factorize a given integer.
//
//Example
//Given 10, return [2, 5].
//Given 660, return [2, 2, 3, 5, 11].


public List<Integer> primeFactorization(int num) {
        List<Integer> factors = new ArrayList<Integer>();

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                num = num / i;
                factors.add(i);
            }
        }
        
        if (num != 1) {
            factors.add(num);
        }
        
        return factors;
    }
    
    
//具体步骤：
//   1. 记up = |sqrt(n)|，作为质因数k的上界, 初始化k = 2
//
//   2. 当n <= up 且 n不为1时，执行步骤3，否则执行步骤4
//
//   3. 当n被k整除时，不断整除并覆盖n，同时结果中记录k，直到n不能整除k为止；
//      之后k++，执行步骤2
//
//   4. 当n不为1时，把n也加入结果当中，算法结束


//几点解释：
//   1. 不需要判定k是否为质数，如果k不为质数，且能整除n时，
//      n早被k的因数所除。故能整除n的k必是质数。
//
//   2. 为何引入up？为了优化性能。当k大于up时，k已不可能整除n，除非k是n自身。
//      也即为何步骤5判断n是否为1，n不为1时必是比up大的质数。
//
//   3. 步骤2中，也判定n是否为1，这也是为了性能，当n已为1时，可早停。


//   最坏时间复杂度 O(sqrt(n))。当n为质数时，取到其最坏时间复杂度。
//
//   空间复杂度 O(log(n))，当n质因数很多时，需要空间大，
//   但总不会多于 O(log(n))个。

//    public List<Integer> primeFactorization(int n) {
//        List<Integer> result = new ArrayList<>();
//        int up = (int) Math.sqrt(n);
//
//        for (int k = 2; k <= up && n > 1; ++k) {
//            while (n % k == 0) {
//                n /= k;
//                result.add(k);
//            }
//        }
//
//        if (n > 1) {
//            result.add(n);
//        }
//
//        return result;
//    }
