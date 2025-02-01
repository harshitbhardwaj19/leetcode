class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 > s2) {
                pq.add(s1 - s2);
            } else if (s1 < s2) {
                pq.add(s2 - s1);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}