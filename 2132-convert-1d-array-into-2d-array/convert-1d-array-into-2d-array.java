class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int arr[][] = new int[m][n];
        int len = original.length;
        if(len!=m*n){
            return new int[0][0];
        }
        for(int i=0; i<len; i++){
            int row = i/n;
            int col = i%n;
            arr[row][col] = original[i];
        }
        return arr;
    }
}