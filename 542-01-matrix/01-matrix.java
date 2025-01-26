class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int nearest[][] = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    nearest[i][j] = 0;
                    q.add(new int[] { i, j, 0});
                } else {
                    nearest[i][j] = -1;
                }
            }
        }
        while(q.size()>0){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int s = arr[2];

            if(r-1 >=0 && nearest[r-1][c] == -1){
                System.out.println("1");
                nearest[r-1][c] = s+1;
                q.add(new int[] { r-1, c, s+1 }); 
            }

            if(c-1 >=0 && nearest[r][c-1] == -1){
                System.out.println("2");
                nearest[r][c-1] = s+1;
                q.add(new int[] { r, c-1, s+1 }); 
            }

            if(r+1 < m && nearest[r+1][c] == -1){
                System.out.println("3");
                nearest[r+1][c] = s+1;
                q.add(new int[] { r+1, c, s+1 }); 
            }

            if(c+1 < n && nearest[r][c+1] == -1){
                System.out.println("4");
                nearest[r][c+1] = s+1;
                q.add(new int[] { r, c+1, s+1 }); 
            }
        }

        return nearest;
    }
}