//Merge two given sorted integer array A and B into a new sorted integer array.

//Example
//A=[1,2,3,4]
//
//B=[2,4,5,6]
//
//return [1,2,2,3,4,4,5,6]


    public static int[] mergeSortedArray(int[] A, int[] B) {
        int startA = 0, startB = 0;
        int endA = A.length, endB = B.length;
        int totalLength = A.length + B.length;
        int[] merge = new int[totalLength];
        int index = 0;

        while (startA < endA && startB < endB){
            if (A[startA] < B[startB]){
                merge[index] = A[startA];
                startA++;
            }
            else {
                merge[index] = B[startB];
                startB++;
            }
            index++;
        }

        while (startA < endA){
            merge[index] = A[startA];
            index++;
            startA++;
        }

        while (startB < endB){
            merge[index] = B[startB];
            index++;
            startB++;
        }

        return merge;
    }
    
    

    //merge sort
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0){
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp){
        if (start >= end){
            return;
        }

        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp){
        int left = start; 
        int middle = (start + end) / 2;
        int right = middle + 1;
        int index = left;

        while (left <= middle && right <= end){
            if (A[left] < A[right]){
                temp[index] = A[left];
                left++;
            }
            else {
                temp[index] = A[right];
                right++;
            }
            index++;
        }

        while (left <= middle){
            temp[index] = A[left];
            index++;
            left++;
        }

        while (right <= end){
            temp[index] = A[right];
            index++;
            right++;
        }
        
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }        
    }

