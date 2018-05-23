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
    
    
