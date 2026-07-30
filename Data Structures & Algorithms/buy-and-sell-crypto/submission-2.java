class Solution {
    public int maxProfit(int[] prices) {
        
        int bestBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i ++) {
            maxProfit = Math.max(prices[i] - bestBuyPrice , maxProfit);
            bestBuyPrice = Math.min(prices[i] , bestBuyPrice);
        }

        return maxProfit;

    }
}
