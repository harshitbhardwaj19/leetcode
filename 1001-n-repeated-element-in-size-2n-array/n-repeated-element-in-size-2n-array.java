class Solution {
    public int repeatedNTimes(int[] nums) {
        int l = nums.length/2;
        int n = l/2;
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}