class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = s.charAt(i) == '0' ? 0 : 1;
            int sum = carry + current;
            if (sum == 0) {
                carry = 0;
                count++;
            } else if (sum == 1) {
                if (i == 0) {
                    break;
                }
                carry = 1;
                count += 2;
            } else if (sum == 2) {
                carry = 1;
                count++;
            }
        }
        return count;
    }
}