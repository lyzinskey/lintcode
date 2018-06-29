//Given an integer array, find the top k largest numbers in it.

//Example
//Given [3,10,1000,-99,4,100] and k = 3.
//Return [1000, 100, 10].



    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i : nums) {
            minheap.offer(i);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[k - i - 1] = minheap.poll();
        }
        return result;
    }


