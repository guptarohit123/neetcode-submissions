class Solution {
    public int maxProfit(int[] prices) {

        int L = 0;
        int maxProfit = 0;

        while(L < prices.length - 1) {
            for(int R = L + 1; R < prices.length; R++) {
                int currentProfit = prices[R] - prices[L];
                maxProfit = Math.max(maxProfit,currentProfit);
            }
            L ++;
        }
        
        return maxProfit;
    }
}
