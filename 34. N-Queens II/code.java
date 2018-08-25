//Follow up for N-Queens problem.

//Now, instead outputting board configurations, return the total number of distinct solutions.

//Example
//For n=4, there are 2 distinct solutions.



public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    private int results = 0;
    
    public int totalNQueens(int n) {
        if (n <= 0) {
            return results;
        }
        
        search(new ArrayList<Integer>(), n);
        return results;        
    }
    
    /*
     * results store all of the chessboards
     * cols store the column indices for each row
     */
    private void search(List<Integer> cols, int n) {
        if (cols.size() == n) {
            results++;
            return;
        }
        
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            //排除两个Queen在同一列的情况
            if (cols.get(rowIndex) == column) {
                return false;
            }
            
            //排除两个Queen处于右上左下的情况
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            
            //排除两个Queen处于左上右下的情况
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        
        return true;
    }    
}



// solution 2
//
public class Solution {
    private int result = 0;
    
    public int totalNQueens(int n) {            
        List<Integer> res = new ArrayList<>();
        DFS(res, n);
        return result;
    }

    private void DFS(List<Integer> res, int n) {
        if (res.size() == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(res, i)) {
                res.add(i);
                DFS(res, n);
                res.remove(res.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> res, int col) {
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == col || Math.abs(res.get(i) - col) == res.size() - i) {
                return false;
            }
        }
        return true;
    }    
}



