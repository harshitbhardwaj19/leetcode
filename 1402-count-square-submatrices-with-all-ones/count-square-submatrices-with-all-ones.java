class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            count += matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                    count += matrix[i][j];
                    // System.out.println("i is " + i + " j is " + j + " count is " + matrix[i][j]);
                }
            }
        }
        return count;
    }
}