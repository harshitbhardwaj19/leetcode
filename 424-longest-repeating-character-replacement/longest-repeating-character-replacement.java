class Solution {
    public int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int l = 0;
        int r = 0;
        int maxLen = 1;
        int max = 1;
        while (r < s.length()) {
            char ch = s.charAt(r);
            arr[ch - 'A']++;
            maxLen = Math.max(maxLen, arr[ch - 'A']);
            if (maxLen + k < r - l + 1) {
                char ch2 = s.charAt(l);
                arr[ch2 - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}