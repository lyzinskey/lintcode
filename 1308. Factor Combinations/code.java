//Numbers can be regarded as product of its factors. For example,
//
//8 = 2 x 2 x 2;
//  = 2 x 4.
//Write a function that takes an integer n and return all possible combinations of its factors.

//Example
//Example1
//
//Input: 12
//Output: 
//[
//  [2, 6],
//  [2, 2, 3],
//  [3, 4]
//]
//Explanation:
//2*6 = 12
//2*2*3 = 12
//3*4 = 12

//Example2
//
//Input: 32
//Output: 
//[
//  [2, 16],
//  [2, 2, 8],
//  [2, 2, 2, 4],
//  [2, 2, 2, 2, 2],
//  [2, 4, 4],
//  [4, 8]
//]
//Explanation:
//2*16=32
//2*2*8=32
//2*2*2*4=32
//2*2*2*2*2=32
//2*4*4=32
//4*8=32

//Notice
//You may assume that n is always positive.
//Factors should be greater than 1 and less than n.




public class Solution {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return new ArrayList<>();
        }
        
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, factors, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int remain, List<Integer> factors, int index) {
        if (index == factors.size()) {
            if (remain == 1) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        dfs(result, list, remain, factors, index + 1);
        int factor = factors.get(index);
        int size = getNum(remain, factor);
        for (int i = 0; i < size; i++) {
            list.add(factor);
            remain /= factor;
            dfs(result, list, remain, factors, index + 1);
        }
        for (int i = 0; i < size; i++) {
            list.remove(list.size() - 1);
        }
    }
    
    private int getNum(int target, int factor) {
        if (factor > target || target % factor != 0) {
            return 0;
        }
        int base = factor;
        int count = 0;
        while (target % factor == 0) {
            factor *= base;
            count++;
        }
        return count;
    }
}



