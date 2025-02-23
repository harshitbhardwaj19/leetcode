class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        int in[] = new int[n];
        int graph[][] = new int[n][n];
        for (int arr[] : prereq) {
            in[arr[0]]++;
            graph[arr[1]][arr[0]] = 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            // System.out.println(in[i]);
            if (in[i] == 0) {
                pq.add(i);
            }
        }

        int count = 0;
        while (pq.size() > 0) {
            count++;
            int curr = pq.poll();
            int arr[] = graph[curr];
            for (int i = 0; i < n; i++) {
                if (graph[curr][i] == 1) {
                    in[i]--;
                    if (in[i] == 0) {
                        pq.add(i);
                    }
                }
            }
        }
        return count == n;
    }
}