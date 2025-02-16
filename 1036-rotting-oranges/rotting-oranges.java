class Solution {
    int m;
    int n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i + 1, j, 3);
                    dfs(grid, i - 1, j, 3);
                    dfs(grid, i, j + 1, 3);
                    dfs(grid, i, j - 1, 3);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
                if(grid[i][j]!=0){
                    max = Math.max(max, grid[i][j]-2);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, int i, int j, int t) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] != 1 && grid[i][j] <= t) {
            return;
        }
        grid[i][j] = t;
        dfs(grid, i + 1, j, t + 1);
        dfs(grid, i - 1, j, t + 1);
        dfs(grid, i, j + 1, t + 1);
        dfs(grid, i, j - 1, t + 1);
    }
}