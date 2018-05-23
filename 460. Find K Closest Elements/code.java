//Given a target number, a non-negative integer target and an integer array A sorted in ascending order,
//find the k closest numbers to target in A,
//sorted in ascending order by the difference between the number and target.
//Otherwise, sorted in ascending order by number if the difference is same.

//Example
//Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
//
//Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

//Challenge
//O(logn + k) time complexity.


    public int[] kClosestNumbers(int[] A, int target, int k) {
        int left = findLowerClosest(A, target);
        int right = left + 1;

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                results[i] = A[left];
                left--;
            } else {
                results[i] = A[right];
                right++;
            }
        }

        return results;
    }

    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }

        if (right >= A.length) {
            return true;
        }

        if (target - A[left] != A[right] - target) {
            return target - A[left] < A[right] - target;
        }

        return true;
    }

    private int findLowerClosest(int[] A, int target) {
        // find the last element smaller than target
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] < target) {
            return end;
        }
        if (A[start] < target) {
            return start;
        }

        return -1;
    }
    
    
    
