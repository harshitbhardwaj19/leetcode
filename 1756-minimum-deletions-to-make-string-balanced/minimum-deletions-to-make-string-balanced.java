class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else {
                // is 'a'
                // if countB is zero, 
                //     then ans will be 0, because we do not need to remove anything
                // in the case where countB is no longer 0
                //     then we just need to remove the min(countB, ans + 1) 
                //     [this +1 represents the 'a' we encounter in this iteration + ans (those to be removed in previous iteration)]
                ans = Math.min(ans + 1, countB);
            }
        }
        return ans;
    }
}