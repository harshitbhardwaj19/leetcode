class Solution {
    int m;
    int n;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        m = rowSum.length;
        n = colSum.length;
        int matrix[][] = new int[m][n];

        int temp = Math.min(rowSum[0], colSum[0]);
        for (int i = temp; i >= 0; i--) {
            matrix[0][0] = i;
            rowSum[0] -= i;
            colSum[0] -= i;
            if (isPossible(1, matrix, rowSum, colSum)) {
                return matrix;
            }
            rowSum[0] += i;
            colSum[0] += i;
        }
        return null;
    }

    public boolean isPossible(int index, int matrix[][], int[] rowSum, int[] colSum) {
        int row = index / n;
        int col = index % n;

        if(index >= m*n){
            return true;
        }

        if (rowSum[row] < 0 || colSum[col] < 0) {
            return false;
        }

        int temp = Math.min(rowSum[row], colSum[col]);
        for (int i = temp; i >= 0; i--) {
            matrix[row][col] = i;
            rowSum[row] -= i;
            colSum[col] -= i;
            if (isPossible(index + 1, matrix, rowSum, colSum)) {
                return true;
            }
            rowSum[row] += i;
            colSum[col] += i;
        }
        return false;
    }
}