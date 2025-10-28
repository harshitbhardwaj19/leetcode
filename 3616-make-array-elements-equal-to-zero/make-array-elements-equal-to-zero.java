class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        int rsum = 0;
        int lsum = 0;
        for (int num : nums) {
            rsum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (lsum == rsum) {
                    total += 2;
                } else if (Math.abs(lsum - rsum) == 1) {
                    total += 1;
                }
            } else {
                lsum += nums[i];
                rsum -= nums[i];
            }
        }
        return total;
    }
}