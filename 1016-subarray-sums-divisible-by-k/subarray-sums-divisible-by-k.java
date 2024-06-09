class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            sum = (sum % k + k) % k; 
            
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        
        return count;
    }
}