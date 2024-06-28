class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int len = n;
        int in[] = new int[len];

        for (int road[] : roads) {
            // System.out.println(road);
            in[road[0]]++;
            in[road[1]]++;
        }

        Arrays.sort(in);

        long sum = 0;
        long value = n;
        for (int i = len - 1; i >= 0; i--) {
            long imp = in[i] * value;
            sum += imp;
            value--;
        }
        return sum;
    }
}