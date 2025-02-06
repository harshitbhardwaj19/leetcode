class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = Integer.MAX_VALUE;

        while (s < e) {
            int mid = s + (e - s) / 2;
            System.out.println(s+" "+e+" "+mid);
            int timeTaken = timeTaken(piles, h, mid);
            if (timeTaken > h) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }

    public int timeTaken(int[] piles, int h, int k) {
        int total = 0;

        for (int pile : piles) {
            int time = pile / k;
            if (pile > time * k) {
                time++;
            }
            total += time;
        }
        return total;
    }
}