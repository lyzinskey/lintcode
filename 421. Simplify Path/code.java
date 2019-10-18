//Given an absolute path for a file (Unix-style), simplify it.

//In a UNIX-style file system, a period . refers to the current directory. 
//Furthermore, a double period .. moves the directory up a level.

//The result must always begin with /, and there must be only a single / between two directory names. 
//The last directory name (if it exists) must not end with a trailing /. 
//Also, the result must be the shortest string representing the absolute path.

//Example
//Example 1:
//
//Input: "/home/"
//Output: "/home"

//Example 2:
//
//Input: "/a/./../../c/"
//Output: "/c"
//Explanation: "/" has no parent directory, so "/../" equals "/".

//Notice
//Did you consider the case where path is "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".




public class Solution {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        if (path ==  null || path.length() == 0) {
            return "";
        }
        
        Deque<String> stack = new ArrayDeque<>();
        Set<String> hashset = new HashSet<>();
        hashset.add("");
        hashset.add(".");
        hashset.add("..");
        
        for (String str : path.split("/")) {
            if (hashset.contains(str)) {
                if (str.equals("..") && !stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollFirst());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}



