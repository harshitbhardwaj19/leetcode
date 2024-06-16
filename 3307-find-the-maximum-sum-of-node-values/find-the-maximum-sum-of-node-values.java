class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int countPositive = 0;
        int min = Integer.MAX_VALUE;
        long positiveSum = 0;
        for (int num : nums) {
            sum += num;

            int diff = (num ^ k) - num;
            if (diff > 0) {
                countPositive++;
                positiveSum += diff;
            }
            min = Math.min(min, Math.abs(diff));
        }

        if (countPositive % 2 == 1) {
            positiveSum -= min;
        }
        return sum + positiveSum;
    }
}