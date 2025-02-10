
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] arr = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getDistance(a[0], a[1]) - getDistance(b[0], b[1]));

        for (int[] point : points) {
            pq.add(point);
        }

        for (int i = 0; i < k; i++) {
            arr[i] = pq.poll();
        }

        return arr;
    }

    public int getDistance(int x, int y) {
        return (x * x) + (y * y);
    }
}