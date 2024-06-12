class Solution {
    public void sortColors(int[] nums) {
        int j = 0; // Represnts 0
        int k = nums.length - 1; // Represnts 2

        for (int i = 0; i <= k;) {
            if(nums[i]==0){
                nums[i] = nums[j];
                nums[j]=0;
                j++;
                i++;
            } else if(nums[i] == 1){
                i++;
            } else {
                nums[i] = nums[k];
                nums[k] = 2;
                k--;
            }
        }
    }
}