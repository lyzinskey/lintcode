//Given a string and an offset, rotate string by offset. (rotate from left to right)

//Example
//Given "abcdefg".
//offset=0 => "abcdefg"
//offset=1 => "gabcdef"
//offset=2 => "fgabcde"
//offset=3 => "efgabcd"


//    Rotate in-place with O(1) extra memory.
    public void rotateString(char[] str, int offset) {
        if (str.length != 0){
            offset %= str.length;
            //don't forget to mod offset by str.length,
            // or there will be ArrayIndexOutOfBoundsException

//            split the array into 3 parts, and then rotate each part separately
            rotation(str, 0, str.length - offset - 1);
            rotation(str, str.length - offset, str.length - 1);
            rotation(str, 0, str.length - 1);
        }
    }

//    rotate character by character in the given range
    private static void rotation(char[] str, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
