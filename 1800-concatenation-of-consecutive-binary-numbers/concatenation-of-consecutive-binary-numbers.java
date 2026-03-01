class Solution {
    public int concatenatedBinary(int n) {
        long sum = 0;
        int ls = 1;
        for (int i = 1; i <= n; i = i * 2) {
            for (int j = i; j < i * 2 && j <= n; j++) {
                sum = (sum << ls) | j;
                sum = sum % 1000000007;
            }
            ls++;
        }
        return (int) sum;
    }
}