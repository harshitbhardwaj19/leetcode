class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minRow[] = new int[m];
        int maxCol[] = new int[n];

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }

            minRow[i] = min;
        }

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
            }

            maxCol[i] = max;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]){
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }
}