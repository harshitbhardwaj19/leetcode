class Solution {
    int max;
    int dp[][];

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0] - fee);
        }
        dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = prices[0] * -1;
        dp[1][0] = Math.max(0, prices[1] - prices[0] - fee);
        dp[1][1] = Math.max(prices[1] * -1, dp[0][1]);
        ;

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1] -fee);
            dp[i][1] = Math.max(prices[i] * -1 + dp[i - 1][0], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}