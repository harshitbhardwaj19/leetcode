class Solution {
    int m;
    int n;
    int arr[][];

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        arr = new int[m][n];

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
        }

        for (int i = 0; i < m; i++) {
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '1';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}