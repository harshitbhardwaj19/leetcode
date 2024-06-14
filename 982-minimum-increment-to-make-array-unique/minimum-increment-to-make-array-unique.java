class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int max = -1;
        int move = 0;
        for (int num : nums) {
            if (num <= max) {
                move += max+1-num;
                num = max+1;
            }
            max = num;

        }
        return move;
    }
}