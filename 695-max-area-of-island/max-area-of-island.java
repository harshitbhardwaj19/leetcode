class Solution {
    int m;
    int n;
    int max;

    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = -1;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }
}