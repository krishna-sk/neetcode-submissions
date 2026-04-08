class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], maxProfit = 0;
        int n = prices.length;
        for(int i=1;i<n;i++){
            int profit = prices[i] - buy;
            maxProfit = Math.max(profit, maxProfit);
            if(prices[i]<buy){
                buy = prices[i];
            }
        }

        return maxProfit;
    }
}
