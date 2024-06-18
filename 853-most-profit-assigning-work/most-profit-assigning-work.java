class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < profit.length; i++) {
            pq.add(new int[] { profit[i], difficulty[i] });
        }

        int j = 0;
        int finalProfit = 0;
        int best = 0;
        for (int work : worker) {
            while (pq.size() != 0 && work >= pq.peek()[1]) {
                // System.out.println("JOB"+ +" , best : "+best)
                best = Math.max(best, pq.poll()[0]);
            }
            // System.out.println("Worker : "+work +" , best : "+best)
            finalProfit += best;
        }

        return finalProfit;
    }
}