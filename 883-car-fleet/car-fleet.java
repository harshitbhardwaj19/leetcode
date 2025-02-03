class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double maxTime = 0;
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < position.length; i++) {
            pq.add(new int[] { position[i], speed[i] });
        }

        while (pq.size() > 0) {
            int car[] = pq.poll();
            double time = (double) (target - car[0]) / (double) car[1];
            if (time > maxTime) {
                maxTime = time;
                count++;
            }
        }

        return count;
    }
}