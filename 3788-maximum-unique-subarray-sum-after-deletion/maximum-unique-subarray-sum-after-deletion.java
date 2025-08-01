class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = -101;
        for (int num : nums) {
            max = Math.max(max, num);
            if (set.contains(num) || num < 0) {
                continue;
            }
            sum += num;
            set.add(num);
        }
        return set.size() == 0 ? max : sum;
    }
}