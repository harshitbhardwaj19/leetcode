class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            q.add(i);
        }

        int count = k;
        while(q.size()>1){
            if(count >1){
                q.add(q.poll());
                count--;
            } else {
                // System.out.println(q.peek());
                q.poll();
                // System.out.println(q);
                count = k;
            }
        }
        return q.poll();
    }
}