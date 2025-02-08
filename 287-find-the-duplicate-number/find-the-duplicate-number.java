class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                int temp2 = nums[nums[i]];
                if(temp == temp2){
                    return temp;
                }
                nums[i] = temp2;
                nums[temp] = temp;
            }
        }

        return nums[0];
    }
}