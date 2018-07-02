//Ugly number is a number that only have factors 2, 3 and 5.

//Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

//Note that 1 is typically treated as an ugly number.

//Example
//If n=9, return 10.

//Challenge
//O(n log n) or O(n) time.



    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> hashset = new HashSet<>();
        Long[] prime = new Long[3];
        prime[0] = (long) 2;
        prime[1] = (long) 3;
        prime[2] = (long) 5;
        
        Long number = (long) 1;
        queue.add(number);
        hashset.add(number);
        
        for (int i = 0; i < n; i++) {
            number = queue.poll();
            for (int j = 0; j < 3; j++) {
                if (!hashset.contains(number * prime[j])) {
                    queue.add(number * prime[j]);
                    hashset.add(number * prime[j]);
                }
            }
        }
        
        return number.intValue();
    }
    
    
    
