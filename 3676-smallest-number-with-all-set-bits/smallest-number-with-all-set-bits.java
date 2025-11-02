class Solution {
    public int smallestNumber(int n) {
        int ans = 1;
        while(n>1){
            ans = (ans << 1) + 1;
            n = n >> 1;
        }
        return ans;
    }
}