//Given an array S of n integers, 
//find three integers in S such that the sum is closest to a given number, target. 
//Return the sum of the three integers.

//Example
//For example, given array S = [-1 2 1 -4], and target = 1. 
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

//Challenge
//O(n^2) time, O(1) extra space


    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }
        
        Arrays.sort(numbers);
        
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                
                if (sum < target) {
                    start++;
                } 
                else {
                    end--;
                }
            }
        }
        
        return bestSum;
    }
    
    
