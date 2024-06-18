class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        for (int i = 0; i < worker.length / 2; i++) {
            int temp = worker[i];
            worker[i] = worker[worker.length - i - 1];
            worker[worker.length - i - 1] = temp;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < profit.length; i++) {
            pq.add(new int[] { profit[i], difficulty[i] });
        }

        int j = 0;
        int finalProfit = 0;
        while (pq.size() != 0 && j < worker.length) {
            int work[] = pq.poll();
            System.out.println("Processing job from priority queue: profit=" + work[0] + ", difficulty=" + work[1]);
            while (j < worker.length && work[1] <= worker[j]) {
                finalProfit += work[0];
                System.out.println("Worker with ability " + worker[j] + " assigned job with profit " + work[0]);
                j++;
            }
        }

        return finalProfit;
    }
}