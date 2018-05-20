//Description
//Follow up for Search in Rotated Sorted Array:
//
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//
//Write a function to determine if a given target is in the array.

//Example
//Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
//Given [1, 1, 1, 1, 1, 1] and target = 0, return false.


    //    In-place, O(1) extra space and O(n) time.
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        for (int index = 0; index < A.length - 1; index++) {
            if (A[index] > A[index + 1]) {
                rotation(A, 0, index);
                rotation(A, index + 1, A.length - 1);
                rotation(A, 0, A.length - 1);
            }
        }
        return binarySearch(A, target);
    }

    //    rotate character by character in the given range
    private static void rotation(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or end = mid - 1
            }
        }

        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }
        return false;
    }
