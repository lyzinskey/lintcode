//Given an array of integers and a number k, 
//the majority number is the number that occurs more than 1/k of the size of the array.
//Find it.

//Example
//Example 1:
//
//Input: [3,1,2,3,2,3,3,4,4,4] and k=3, 
//Output: 3.

//Example 2:
//
//Input: [1,1,2] and k=3, 
//Output: 1.

//Challenge
//O(n) time and O(k) extra space

//Notice
//There is only one majority number in the array.




public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    
    // Time: O(n) -> every element added to and removed from map only once
    // Space: O(k)
    public int majorityNumber(List<Integer> array, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                if (count.size() < k - 1) {
                    count.put(num, 1);
                } else {
                    updateMap(count);
                }
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            if (count.containsKey(num)) {
                if (!freq.containsKey(num)) {
                    freq.put(num, 0);
                }
                freq.put(num, freq.get(num) + 1);
            }
        }

        for (int key : freq.keySet()) {
            if (freq.get(key) > array.size() / k) {
                return key;
            }
        }
        return -1;
    }

    private void updateMap(Map<Integer, Integer> count) {
        List<Integer> remove = new ArrayList<>();
        for (int key : count.keySet()) {
            count.put(key, count.get(key) - 1);
            if (count.get(key) == 0) {
                remove.add(key);
            }
        }
        for (int num : remove) {
            count.remove(num);
        }
    }    
}




