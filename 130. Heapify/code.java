//Given an integer array, heapify it into a min-heap array.

//For a heap array A, A[0] is the root of heap, 
//and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].

//Clarification
//What is heap?
//Heap is a data structure, which usually have three methods: push, pop and top. 
//where "push" add a new element the heap, 
//"pop" delete the minimum/maximum element in the heap, 
//"top" return the minimum/maximum element.

//What is heapify?
//Convert an unordered integer array into a heap array. 
//If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

//What if there is a lot of solutions?
//Return any of them.

//Example
//Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

//Challenge
//O(n) time complexity


    //O(nlogn) solution
    //
    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftUp(A, i);
        }
    }
    
    private void siftUp(int[] A, int i) {
        while (i != 0) {
            int father = (i - 1) / 2;
            if (A[father] < A[i]) {
                break;
            }
            
            int temp = A[father];
            A[father] = A[i];
            A[i] = temp;
            
            i = father;
        }
    }
    


    //O(n) solution
    //
    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }
    
    private void siftDown(int[] A, int i) {
        while (i * 2 + 1 < A.length) {
            int son = i * 2 + 1;
            if (son + 1 < A.length && A[son] > A[son + 1]) {
                son++;
            }
            
            if (A[son] >= A[i]) {
                break;
            }
            
            int temp = A[son];
            A[son] = A[i];
            A[i] = temp;
            
            i = son;
        }
    }
    
    
