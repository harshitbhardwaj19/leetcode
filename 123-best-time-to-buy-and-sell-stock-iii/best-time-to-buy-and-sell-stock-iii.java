class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int maxBuyFirst = -1 * prices[0];
        int maxBuySecond = Integer.MIN_VALUE;

        int maxSellFirst = 0;
        int maxSellSecond = 0;

        for (int i = 1; i < prices.length; i++) {
            maxBuyFirst = Math.max(maxBuyFirst, -1 * prices[i]);
            maxSellFirst = Math.max(maxSellFirst, prices[i] + maxBuyFirst);

            maxBuySecond = Math.max(maxBuySecond, maxSellFirst - prices[i]);
            maxSellSecond = Math.max(maxSellSecond, prices[i] + maxBuySecond);
        }

        return maxSellSecond;
    }
}