class Solution {
    public int findCenter(int[][] edges) {
        int in[] = new int[edges.length + 2];
        int max = 0;
        int result = -1;
        for (int edge[] : edges) {
            in[edge[0]]++;
            in[edge[1]]++;
            
            if (in[edge[0]] > max) {
                result = edge[0];
                max = Math.max(max, in[edge[0]]);
            }

            if (in[edge[1]] > max) {
                result = edge[1];
                max = Math.max(max, in[edge[1]]);
            }
        }
        return result;
    }
}