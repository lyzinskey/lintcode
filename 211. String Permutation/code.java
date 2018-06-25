//Given two strings, write a method to decide if one is a permutation of the other.

//Example
//abcd is a permutation of bcad, but abbe is not a permutation of abe


    public boolean Permutation(String A, String B) {
        int[] nums = new int[125];
        for (int i = 0; i < A.length(); i++) {
            nums[(int) A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            nums[(int) B.charAt(i)]--;
        }
        for (int i : nums) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    
    
