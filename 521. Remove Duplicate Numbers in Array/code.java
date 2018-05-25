//Given an array of integers, remove the duplicate numbers in it.

//You should:

//Do it in place in the array.
//Move the unique numbers to the front of the array.
//Return the total number of the unique numbers.
//You don't need to keep the original order of the integers.

//Example
//Given nums = [1,3,1,4,4,2], you should:

//Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
//Return the number of unique integers in nums => 4.

//Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.


    //solve in O(n) time complexity
    //using hash table
    public int deduplication(int[] nums) {
        HashSet<Integer> unique = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }
        int index = 0;
        for (int i : unique){
            nums[index] = i;
            index++;
        }
        return unique.size();
    }
    
    
        //solve in O(nlogn) time without extra space
    //using two pointers
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if (nums[fast] == nums[slow]){
                fast++;
            }
            else {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
    
    
