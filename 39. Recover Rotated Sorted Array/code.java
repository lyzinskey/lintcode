//Given a rotated sorted array, recover it to sorted array in-place.
//
//Example
//[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]


//    In-place, O(1) extra space and O(n) time.
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums.size() > 0) {
            for (int index = 0; index < nums.size() - 1; index++) {
                if (nums.get(index) > nums.get(index + 1)) {
                    rotation(nums, 0, index);
                    rotation(nums, index + 1, nums.size() - 1);
                    rotation(nums, 0, nums.size() - 1);
                }
            }
        }
    }

    //    rotate character by character in the given range
    private static void rotation(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
