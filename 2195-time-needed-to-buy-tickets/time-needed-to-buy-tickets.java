class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int circle = tickets[k];
        int time =0;
        for (int i = 0; i <= k; i++) {
            time += Math.min(tickets[i], circle);
        }

        for (int i = k+1; i < tickets.length; i++) {
            time += Math.min(tickets[i], circle-1);
        }
        return time;
    }
}