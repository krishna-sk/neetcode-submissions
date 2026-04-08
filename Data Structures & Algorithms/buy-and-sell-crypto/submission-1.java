class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = prices[0], maxProfit = 0;
        int n = prices.length;
        int left = 0 , right = 1;

        while(right<n){
            if(prices[left]>prices[right]){
                left = right;
                right++;
            }else{
                maxProfit = Math.max(maxProfit,prices[right]-prices[left]);
                right++;
            }
        }
         
        return maxProfit;
    }
}
