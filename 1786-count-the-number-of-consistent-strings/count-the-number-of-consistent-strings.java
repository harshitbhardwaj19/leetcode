class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean arr[] = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            arr[ch - 'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            if (allowed(arr, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean allowed(boolean arr[], String word) {
        for (char ch : word.toCharArray()) {
            if (!arr[ch - 'a']) {
                return false;
            }
        }
        return true;
    }
}