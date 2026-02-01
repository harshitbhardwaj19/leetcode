class Solution {
    public int minimumCost(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                sMin = min;
                min = nums[i];
            } else if (nums[i] < sMin) {
                sMin = nums[i];
            }
        }
        return nums[0] + min + sMin;
    }
}