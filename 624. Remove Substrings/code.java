//Given a string s and a set of n substrings. 
//You are supposed to remove every instance of those n substrings from s 
//so that s is of the minimum length and output this minimum length.

//Example
//Given s = ccdaabcdbb, substrs = ["ab", "cd"]
//Return 2
//
//Explanation:
//ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)


    public int minLength(String s, Set<String> dict) {
        // Write your code here
        Queue<String> queue = new LinkedList<String>();
        Set<String> hashSet = new HashSet<String>();

        int min = s.length();
        queue.offer(s);
        hashSet.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            for (String sub : dict) {
                int found = s.indexOf(sub);
                while (found != -1) {
                    String new_s = s.substring(0, found) +
                            s.substring(found + sub.length(), s.length());
                    if (!hashSet.contains(new_s)) {
                        if (new_s.length() < min){
                            min = new_s.length();
                        }
                        queue.offer(new_s);
                        hashSet.add(new_s);
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
        }
        return min;
    }
    
    
