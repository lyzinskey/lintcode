//Given an array of n integer with duplicate number, 
//and a moving window(size k), move the window at each iteration from the start of the array, 
//find the maximum number inside the window at each moving.

//Example
//  For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]
//  At first the window is at the start of the array like this
//  [|1, 2, 7| ,7, 8] , return the maximum 7;
//  then the window move one step forward.
//  [1, |2, 7 ,7|, 8], return the maximum 7;
//  then the window move one step forward again.
//  [1, 2, |7, 7, 8|], return the maximum 8;

//Challenge
//O(n) time and O(k) memory



    public List<Integer> maxSlidingWindow(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {
            // 新来一个元素，将deque尾端所有小于新元素的全部poll出去
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 移动sliding window左端点
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            // 只有当sliding window的size达到k才开始输出
            if (i >= k - 1) {
                result.add(array[deque.peekFirst()]);
            }
        }
        return result;        
    }
    
    
    
    
