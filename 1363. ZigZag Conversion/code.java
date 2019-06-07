//Given a string s and an integer numRows. You need to place s like zigzag. 
//Then read the 'zigzag' line by line. Return the string you read.

//Notice that zigzag extends according to the directions of down->up-right->down->up-right...
//
//    |   /|   /|
//    |  / |  / | ...
//    | /  | /  | ...
//    |/   |/   |/

//Example
//Example 1:
//
//Input: "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//Explanation: 
//    After conversion, we get
//      P   A   H   N
//      A P L S I I G
//      Y   I   R
//    Read line by line, the answer is "PAHNAPLSIIGYIR".

//Example 2:
//
//Input: "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation: 
//    After conversion, we get
//      P     I     N
//      A   L S   I G
//      Y A   H R
//      P     I
//    Read line by line, the answer is "PINALSIGYAHRPI".

//Example 3:
//
//Input: "PAYPALISHIRING", numRows = 1
//Output: "PAYPALISHIRING"
//Explanation: 
//    After conversion, we get
//      PAYPALISHIRING
//    Read line by line, the answer is "PAYPALISHIRING".




public class Solution {
    /**
     * @param s: the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     */
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
    
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) {// vertically down
                sb[idx].append(c[i++]);
            }
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) {// obliquely up
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }        
        return sb[0].toString();
    }
}



