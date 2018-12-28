//Given an integer, convert it to a roman numeral.

//The number is guaranteed to be within the range from 1 to 3999.

//Example
//4 -> IV
//
//12 -> XII
//
//21 -> XXI
//
//99 -> XCIX
//
//more examples at: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm

//Clarification
//What is Roman Numeral?
//
//https://en.wikipedia.org/wiki/Roman_numerals
//https://zh.wikipedia.org/wiki/罗马数字
//http://baike.baidu.com/view/42061.htm



public class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}



