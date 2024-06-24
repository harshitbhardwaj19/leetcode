class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = m * n;
        for (int i = 0; i < m; i++) {
            int area = minimumArea(grid, 0, i, 0, n);
            for (int j = 0; j < n; j++) {
                int inner = 0;
                inner += minimumArea(grid, i, m, 0, j);
                inner += minimumArea(grid, i, m, j, n);
                min = Math.min(min, area+inner);
            }
        }

        for (int i = 0; i < m; i++) {
            int area = minimumArea(grid, i, m, 0, n);
            for (int j = 0; j < n; j++) {
                int inner = 0;
                inner += minimumArea(grid, 0, i, 0, j);
                inner += minimumArea(grid, 0, i, j, n);
                min = Math.min(min, area+inner);
            }
        }

        for (int i = 0; i < m; i++) {
            int area = minimumArea(grid, 0, i, 0, n);
            for (int j = i; j < m; j++) {
                int inner = 0;
                inner += minimumArea(grid, i, j, 0, n);
                inner += minimumArea(grid, j, m, 0, n);
                min = Math.min(min, area+inner);
            }
        }

        for (int i = 0; i < n; i++) {
            int area = minimumArea(grid, 0, m, 0, i);
            for (int j = 0; j < m; j++) {
                int inner = 0;
                inner += minimumArea(grid, 0, j, i, n);
                inner += minimumArea(grid, j, m, i, n);
                min = Math.min(min, area+inner);
            }
        }

        for (int i = 0; i < n; i++) {
            int area = minimumArea(grid, 0, m, i, n);
            for (int j = 0; j < m; j++) {
                int inner = 0;
                inner += minimumArea(grid, 0, j, 0, i);
                inner += minimumArea(grid, j, m, 0, i);
                min = Math.min(min, area+inner);
            }
        }

        for (int i = 0; i < n; i++) {
            int area = minimumArea(grid, 0, m, 0, i);
            for (int j = i; j < n; j++) {
                int inner = 0;
                inner += minimumArea(grid, 0, m, i, j);
                inner += minimumArea(grid, 0, m, j, n);
                min = Math.min(min, area+inner);
            }
        }

        return min;
    }

    public int minimumArea(int[][] grid, int rowS, int rowE, int colS, int colE) {
        int minX = grid.length;
        int maxX = -1;
        int minY = grid[0].length;
        int maxY = -1;

        for (int i = rowS; i < rowE; i++) {
            for (int j = colS; j < colE; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        if (maxX == -1 || maxY == -1) {
            return 0;
        }

        int height = maxX - minX + 1;
        int width = maxY - minY + 1;
        return height * width;
    }

}