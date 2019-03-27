//Given two binary strings, return their sum (also a binary string).

//Example
//Example 1:
//
//Input:
//a = "0", b = "0"
//Output:
//"0"

//Example 2:
//
//Input:
//a = "11", b = "1"
//Output:
//"100"





public class Solution {
    public String addBinary(String a, String b) {
        int ap = a.length() - 1;
        int bp = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (ap >= 0 || bp >= 0) {
            int sum = carry;
            if (ap >= 0) {
                sum += a.charAt(ap--) - '0';
            }
            if (bp >= 0) {
                sum += b.charAt(bp--) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
        }
        
        if (carry > 0) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }    
}



