class Solution {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char ch1 = s.charAt(start);
            char ch2 = s.charAt(end);

            if (ch1 != ch2) {
                return end - start + 1;
            }

            while (start <= end && s.charAt(start) == ch1) {
                start++;
            }

            while (start <= end && s.charAt(end) == ch1) {
                end--;
            }
        }
        return end - start + 1;
    }
}