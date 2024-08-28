class Solution {
    int m;
    int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        boolean visited[][] = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    // System.out.println(i+"  "+j+"##########");
                    if (helper(grid1, grid2, i, j, visited)) {
                        // System.out.println(i+"  "+j+" ***********");
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean helper(int[][] grid1, int[][] grid2, int i, int j, boolean visited[][]) {
        // System.out.println(i+"  "+j);
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid2[i][j] == 0) {
            return true;
        }

        if (grid1[i][j] == 0) {
            return false;
        }
        visited[i][j] = true;

        boolean b1 = helper(grid1, grid2, i + 1, j, visited);
        boolean b2 = helper(grid1, grid2, i, j + 1, visited);
        boolean b3 = helper(grid1, grid2, i - 1, j, visited);
        boolean b4 = helper(grid1, grid2, i, j - 1, visited); 
        return b1 && b2 && b3 && b4;
    }
}