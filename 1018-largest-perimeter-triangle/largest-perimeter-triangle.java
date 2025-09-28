class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (possible(nums[i], nums[i - 1], nums[i - 2])) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public boolean possible(int a, int b, int c) {
        if (c + b <= a) {
            return false;
        }
        return true;
    }
}