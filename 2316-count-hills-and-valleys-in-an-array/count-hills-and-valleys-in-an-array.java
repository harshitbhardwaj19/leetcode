class Solution {
    public int countHillValley(int[] nums) {
        int len = nums.length;
        int increasing = 0;
        int count = 0;
        for(int i = 0; i<len-1; i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            else if(nums[i]<nums[i+1]){
                if(increasing == -1){
                    count++;
                }
                increasing = 1;
            } else {
                if(increasing == 1){
                    count++;
                }
                increasing = -1;
            }
        }
        return count;
    }
}