//Given an array of integers, find two numbers such that they add up to a specific target number.

//The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2.
// Please note that your returned answers (both index1 and index2) are zero-based.

//Example
//numbers=[2, 7, 11, 15], target=9
//
//return [0, 1]


    // using HashMap
    // O(n) Space, O(n) Time
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]), i};
                return result;
            }
            map.put(target - numbers[i], i);
        }
        return null;
    }
    
    
