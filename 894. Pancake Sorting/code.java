//Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.
//flip(arr, i): Reverse array from 0 to i 

//Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, 
//the goal is to sort the sequence in as few reversals as possible.

//Example
//Given array = [6, 7, 10, 11, 12, 20, 23]
//Use flip(arr, i) function to sort the array.

//烙饼排序，只能做翻转操作，第一次遍历n长度数组，每次遍历到的数和首位比较，
//比首位大的话，翻转，这样使得第一位是最大数字，循环结束翻转数组，这样最大数就位

//接下来的循环则是对n-1长度部分找到最大值，使得最大值就位，以此类推


    public void pancakeSort(int[] array) {
        // Write your code here
        int n = array.length;
        while(n > 1){
            for(int i = 0; i < n - 1; i++){
                if(array[0] < array[i + 1]){
                    FlipTool.flip(array, i + 1);
                }
            }
            FlipTool.flip(array, n - 1);
            n--;
        }
    }
    
    
