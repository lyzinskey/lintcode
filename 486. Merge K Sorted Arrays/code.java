//Given k sorted integer arrays, merge them into one sorted array.

//Example
//Given 3 sorted arrays:

//  [
//    [1, 3, 5, 7],
//    [2, 4, 6],
//    [0, 8, 9, 10, 11]
//  ]
//return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

//Challenge
//Do it in O(N log k).
//
//N is the total number of integers.
//k is the number of arrays.



public class Solution {
    public int[] mergekSortedArrays(int[][] arrayOfArrays) {
        int[] result = new int[getLength(arrayOfArrays)];
        PriorityQueue<Element> pq = new PriorityQueue<>(new myComparator());
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0) {
                pq.offer(new Element(i, 0, arrayOfArrays[i][0]));
            }
        }

        int index = 0;
        while (!pq.isEmpty()) {
            Element elem = pq.poll();
            result[index++] = elem.value;
            if (elem.indexInArray < arrayOfArrays[elem.indexOfArray].length - 1) {
                pq.offer(new Element(elem.indexOfArray, elem.indexInArray + 1, arrayOfArrays[elem.indexOfArray][elem.indexInArray + 1]));
            }
        }
        return result;
    }

    public class Element {
        int indexOfArray;
        int indexInArray;
        int value;
        Element(int indexOfArray, int indexInArray, int value) {
            this.indexOfArray = indexOfArray;
            this.indexInArray = indexInArray;
            this.value = value;
        }
    }

    public class myComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            return e1.value - e2.value;
        }
    }

    private int getLength(int[][] arrayOfArrays) {
        int len = 0;
        for (int[] array : arrayOfArrays) {
            len += array.length;
        }
        return len;
    }     
}



