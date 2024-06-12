class Solution {
    int n;
    long dp[][];

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new long[n+1][n+1];
        for (long arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return (int) paintWalls(cost, time, 0, n);
    }

    public long paintWalls(int[] cost, int[] time, int index, int remaining) {
        if (remaining <= 0) {
            return 0;
        }
        if (index >= n) {
            return Integer.MAX_VALUE;
        }
        if(dp[index][remaining] != -1 ){
            return dp[index][remaining];
        }
        long pick = cost[index] + paintWalls(cost, time, index + 1, remaining - 1 - time[index]);
        long notPick = paintWalls(cost, time, index + 1, remaining);

        return dp[index][remaining] = Math.min(pick, notPick);
    }
}