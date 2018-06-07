//Partition an unsorted integer array into three parts:
//
//The front part < low
//The middle part >= low & <= high
//The tail part > high
//Return any of the possible solutions.

//low <= high in all testcases.

//Example
//Given [4,3,4,1,2,3,1,2], and low = 2 and high = 3.
//
//Change to [1,1,2,3,2,3,4,4].
//
//([1,1,2,2,3,3,4,4] is also a correct answer, but [1,2,1,2,3,3,4,4] is not)

//Challenge
//Do it in place.
//Do it in one pass (one loop).


    public void partition2(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0){
            return;
        }

        int left = 0;
        int middle = 0;
        int right = nums.length - 1;

        while (middle < right){
            if (nums[middle] < low){
                swap(nums, left, middle);
                middle++;
                left++;
            }
            else if (nums[middle] > high){
                swap(nums, middle, right);
                right--;
            }
            else {
                middle++;
            }
        }
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    
