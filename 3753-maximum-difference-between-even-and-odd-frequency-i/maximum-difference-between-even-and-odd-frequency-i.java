class Solution {
    public int maxDifference(String s) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int minE = 101;
        int maxO = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] % 2 == 0) {
                minE = Math.min(minE, freq[i]);
            } else {
                maxO = Math.max(maxO, freq[i]);
            }
        }
        return maxO - minE;
    }
}