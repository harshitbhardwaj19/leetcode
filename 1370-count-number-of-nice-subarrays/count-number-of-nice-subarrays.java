class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int oddCount = 0;
        int count[] = new int[nums.length+1];
        count[0]=1;
        for(int num : nums){
            oddCount += num&1; 
            if(oddCount - k >= 0){
                ans += count[oddCount-k];
            }
            count[oddCount]++;
        }
        return ans;
    }
}