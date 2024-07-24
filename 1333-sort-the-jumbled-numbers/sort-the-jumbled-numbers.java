class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; ++i) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> getNew(mapping, nums[a]) - getNew(mapping, nums[b]));

        int k = 0;
        int[] newNums = new int[n];
        // System.out.println(indices);
        for (int idx : indices) {
            // System.out.println(idx);
            newNums[k++] = nums[idx];
        }
        return newNums;
    }

    public int getNew(int[] mapping, int num) {
        if(num==0){
            return mapping[num];
        }
        int newNum = 0;
        int mul = 1;
        while (num > 0) {
            newNum = newNum + mapping[(num % 10)] * mul;
            mul *= 10;
            num = num / 10;
        }
        // System.out.println(newNum);
        return newNum;
    }
}