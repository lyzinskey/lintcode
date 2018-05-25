//Given an array of integers, find two numbers that their difference equals to a target value.
//where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

//It's guaranteed there is only one available solution

//Example
//Given nums = [2, 7, 15, 24], target = 5
//return [1, 2] (7 - 2 = 5)


    public int[] twoSum7(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i] + target;
            if (map.containsKey(sum)) {
                int index = map.get(sum);
                return new int[] {index + 1, i + 1};
            }

            int diff = nums[i] - target;
            if (map.containsKey(diff)) {
                int index = map.get(diff);
                return new int[] {index + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        return null;
    }
