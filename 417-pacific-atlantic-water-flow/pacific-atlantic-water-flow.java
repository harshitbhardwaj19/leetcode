class Solution {
    int m;
    int n;
    int atl[][];
    int pac[][];

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        atl = new int[m][n];
        pac = new int[m][n];

        for (int j = 0; j < n; j++) {
            pacificAtlantic(heights, pac, 0, j, 0);
        }

        for (int j = 0; j < n; j++) {
            pacificAtlantic(heights, atl, m - 1, j, 0);
        }

        for (int i = 0; i < m; i++) {
            pacificAtlantic(heights, pac, i, 0, 0);
        }

        for (int i = 0; i < m; i++) {
            pacificAtlantic(heights, atl, i, n - 1, 0);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atl[i][j] == 1 && pac[i][j] == 1) {
                    list.add(List.of(i, j));
                }
            }
        }
        return list;
    }

    public void pacificAtlantic(int[][] heights, int[][] arr, int i, int j, int prev) {
        if (i < 0 || i >= m || j < 0 || j >= n || heights[i][j] < prev || arr[i][j] == 1) {
            return;
        }

        arr[i][j] = 1;

        pacificAtlantic(heights, arr, i + 1, j, heights[i][j]);
        pacificAtlantic(heights, arr, i - 1, j, heights[i][j]);
        pacificAtlantic(heights, arr, i, j + 1, heights[i][j]);
        pacificAtlantic(heights, arr, i, j - 1, heights[i][j]);
    }
}