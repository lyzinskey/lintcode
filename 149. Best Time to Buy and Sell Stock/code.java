//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

//Example
//Given array [3,2,3,1,2], return 1.



    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int price : prices) {
            min = min < price ? min : price;
            profit = price - min > profit ? price - min : profit;
        }
        
        return profit;
    }
    
    
    
