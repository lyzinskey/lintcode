//Given a char array representing tasks CPU need to do. 
//It contains capital letters A to Z where different letters represent different tasks.
//Tasks could be done without original order. Each task could be done in one interval. 
//For each interval, CPU could finish one task or just be idle.

//However, there is a non-negative cooling interval n that means between two same tasks, 
//there must be at least n intervals that CPU are doing different tasks or just be idle.

//You need to return the least number of intervals the CPU will take to finish all the given tasks.

//Example
//Example1
//
//Input: tasks = ['A','A','A','B','B','B'], n = 2
//Output: 8
//Explanation:
//A -> B -> idle -> A -> B -> idle -> A -> B.

//Example2
//
//Input: tasks = ['A','A','A','B','B','B'], n = 1
//Output: 6
//Explanation:
//A -> B -> A -> B -> A -> B.

//Notice
//The number of tasks is in the range [1, 10000].
//The integer n is in the range [0, 100].




public class Solution {
    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        char[] cnt = new char[26];
        int maxn = 0;
        for (int task: tasks) {
            cnt[task - 'A']++;
            maxn = Math.max(maxn, cnt[task - 'A']);
        }
        int ans = (maxn - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == maxn) {
                ans++;
            }
        }
        return Math.max(ans, tasks.length);
    }    
}



