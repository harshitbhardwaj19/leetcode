class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] != i) {

                // System.out.println(i);

                // for (int j = 0; j < nums.length; j++) {
                //     System.out.print(nums[j] + " , ");   
                // }

                // System.out.println();
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