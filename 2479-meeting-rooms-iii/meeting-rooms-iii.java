class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int rooms[] = new int[n];

        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return (int) (a[2] - b[2]);
            }
            return (int) (a[1] - b[1]);
        });
        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int len = meetings[i][1] - meetings[i][0];

            while (pq.size() > 0 && start >= pq.peek()[1]) {
                int prevMeeting[] = pq.poll();
                int prevRoom = (int) prevMeeting[2];
                rooms[prevRoom] = -1 * rooms[prevRoom]; // negative means available
            }

            if (pq.size() >= n) {
                int prevMeeting[] = pq.poll();
                int prevRoom = (int) prevMeeting[2];
                rooms[prevRoom] = -1 * rooms[prevRoom]; // negative means available
                start = prevMeeting[1] > start ? prevMeeting[1] : start;
            }
            int room = getRoom(rooms);
            pq.add(new int[] { start, start + len, room });
            rooms[room] = Math.abs(rooms[room]) + 1;
        }

        int max = 0;
        for (int i = 1; i < rooms.length; i++) {
            if (Math.abs(rooms[max]) < Math.abs(rooms[i])) {
                max = i;
            }
        }
        return max;
    }

    public int getRoom(int rooms[]) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] <= 0) {
                return i;
            }
        }
        return -1;
    }
}