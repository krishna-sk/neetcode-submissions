class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0], maxProfit = 0, profit = 0;
        for(int i=1;i<n;i++){
            profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit,profit);
            buy = Math.min(buy,prices[i]);
        }

        return maxProfit;
    }
}
