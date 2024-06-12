class Solution {
    int n;
    int dp[][];

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new int[n+1][n+1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return paintWalls(cost, time, 0, n);
    }

    public int paintWalls(int[] cost, int[] time, int index, int remaining) {
        if (remaining <= 0) {
            return 0;
        }
        if (index >= n) {
            return 1000000000;
        }
        if(dp[index][remaining] != -1 ){
            return dp[index][remaining];
        }
        int pick = cost[index] + paintWalls(cost, time, index + 1, remaining - 1 - time[index]);
        int notPick = paintWalls(cost, time, index + 1, remaining);

        return dp[index][remaining] = Math.min(pick, notPick);
    }
}