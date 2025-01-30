class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            s.add(num);
        }

        int max = 1;
        for (int num : nums) {
            s.remove(num);
            int m = 1;

            int temp = num;
            while (s.contains(temp - 1)) {
                s.remove(temp - 1);
                m++;
                temp--;
            }

            temp = num;
            while (s.contains(temp + 1)) {
                s.remove(temp + 1);
                m++;
                temp++;
            }

            max = Math.max(m, max);
        }
        return max;
    }
}