class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        if(l<=4){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<4; i++){
            int diff = nums[l-4+i] - nums[i];
            min = Math.min(min, diff);
        }
        return min;
    }
}