class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = mat[i][j];
                rowMap.put(a, i);
                colMap.put(a, j);
            }
        }

        int rowSum[] = new int[m];
        int colSum[] = new int[n];

        for (int i = 0; i < m * n; i++) {
            int a = arr[i];
            int row = rowMap.get(a);
            int col = colMap.get(a);

            if (++rowSum[row] == n || ++colSum[col] == m) {
                return i;
            }
        }
        return -1;
    }
}