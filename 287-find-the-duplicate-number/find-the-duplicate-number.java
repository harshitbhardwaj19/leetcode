class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int num = nums[i];
            if (nums[Math.abs(num)] < 0) {
                return Math.abs(num);
            }

            nums[Math.abs(num)] = nums[Math.abs(num)] * -1;
        }

        return -1;
    }
}