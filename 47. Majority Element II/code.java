//Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
//Find it.

//Example
//Given [1, 2, 1, 2, 1, 3, 3], return 1.

//Challenge
//O(n) time and O(1) extra space.

//Notice
//There is only one majority number in the array.




public class Solution {
    public int majorityNumber(List<Integer> array) {
        int counter1 = 0;
        int counter2 = 0;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == num1) {
                counter1++;
            } else if (array.get(i) == num2) {
                counter2++;
            } else if (counter1 == 0) {
                num1 = array.get(i);
                counter1++;
            } else if (counter2 == 0) {
                num2 = array.get(i);
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }

        counter1 = 0;
        counter2 = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == num1) {
                counter1++;
            } else if (array.get(i) == num2) {
                counter2++;
            }
        }

        return counter1 > counter2 ? num1 : num2;
    }
}



