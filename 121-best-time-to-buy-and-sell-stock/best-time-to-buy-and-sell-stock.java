class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int p : prices){
            minSoFar = Math.min(minSoFar, p);
            max = Math.max(max, p - minSoFar);
        }
        return max;
    }
}