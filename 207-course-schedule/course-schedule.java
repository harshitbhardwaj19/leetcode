class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<Integer> arr[] = new ArrayList[num];
        int in[] = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < pre.length; i++) {
            arr[pre[i][1]].add(pre[i][0]);
            in[pre[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        int total=0;

        while (q.size() > 0) {
            int x = q.poll();
            total++;
            for (int i = 0; i < arr[x].size(); i++) {
                in[arr[x].get(i)]--;
                if (in[arr[x].get(i)] == 0) {
                    q.add(arr[x].get(i));
                }
            }
        }
        return total==num;
    }
}