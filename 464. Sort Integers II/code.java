//Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.

//Example
//Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].


    //quick sort
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0){
            return;
        }
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end){
        //corner case
        if (start >= end){
            return;
        }

        int left = start;
        int right = end;

        //the pivot should not be A[left] or A[right]
        //
        //assign the value not the index to pivot,
        //because the corresponding value of an index could be changed
        //during the sorting
        int pivot = A[(left + right) / 2];

        //left <= right, not left < right
        while (left <= right){

            //A[left] < pivot, not A[left] <= pivot
            while (left <= right && A[left] < pivot){
                left++;
            }

            //A[right] > pivot, not A[right] >= pivot
            while (left <= right && A[right] > pivot){
                right--;
            }

            if (left <= right){
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;

                //don't forget to update left and right after swapping
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
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
