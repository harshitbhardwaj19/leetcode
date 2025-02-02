class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (!s.contains(n)) {
            s.add(n);
            n = getSq(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int getSq(int n) {
        int sq = 0;
        while (n > 0) {
            sq += ((n % 10) * (n % 10));
            n = n / 10;
        }
        return sq;
    }
}