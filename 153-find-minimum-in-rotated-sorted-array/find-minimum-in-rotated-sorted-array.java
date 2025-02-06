class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int s = 0;
        int e = nums.length - 1;
        if (nums[s] < nums[e]) {
            return nums[s];
        }
        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] < nums[e]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return nums[s];
    }
}