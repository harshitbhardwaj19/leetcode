class Solution {
    public double averageWaitingTime(int[][] customers) {
        int max = 0;
        Double sum = (double) 0;
        for (int arr[] : customers) {
            max = Math.max(max, arr[0]);
            sum += (arr[1] + max - arr[0]);
            max = max + arr[1];
        }
        double len = customers.length;
        return sum / len;
    }
}