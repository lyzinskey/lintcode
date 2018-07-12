//Given an integer array, find a subarray where the sum of numbers is zero. 
//Your code should return the index of the first number and the index of the last number.

//There is at least one subarray that it's sum equals to zero.

//Example
//Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].



    // 思路：使用hashmap判断两数之和是否为固定整数
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hashmap = new HashMap<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int sum = 0;
        hashmap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // hashmap当中，sum存储的初始值是0，当出现两个sum的值相同时，
            // 必然是前面有数字之和为0，这样加上当前数字的和才能与之前相同
            if (hashmap.containsKey(sum)) {
                result.add(hashmap.get(sum) + 1);
                result.add(i);
                return result;
            }

            hashmap.put(sum, i);
        }

        return result;
    }
    
    
    
