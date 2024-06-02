class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][] = new int[2][k];
        Arrays.fill(dp[0], Integer.MIN_VALUE);

        for (int i = 0; i < prices.length; i++) {

            dp[0][0] = Math.max(dp[0][0], -1 * prices[i]);
            dp[1][0] = Math.max(dp[1][0], prices[i] + dp[0][0]);

            for (int j = 1; j < k; j++) {
                dp[0][j] = Math.max(dp[0][j], dp[1][j-1] - prices[i]);
                dp[1][j] = Math.max(dp[1][j], prices[i] + dp[0][j]);
            }
        }

        return dp[1][k-1];
    }
}