//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
//You begin the journey with an empty tank at one of the gas stations.

//Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

//Example
//Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.

//Challenge
//O(n) time and O(1) extra space

//Notice
//The solution is guaranteed to be unique.





public class Solution {
    /**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int curr = 0;
        
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}



