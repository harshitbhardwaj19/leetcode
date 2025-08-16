class Solution {
    public boolean isPowerOfFour(int n) {
        int bits = 0;
        int count = 0;
        while (n > 0) {
            count++;
            int lsb = n & 1;
            if (lsb == 1) {
                break;
            }
            n = n>>1;
        }
        if (n == 1 && count % 2 == 1) {
            return true;
        }
        return false;
    }
}