class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                String str = num.substring(i - 2, i + 1);
                if (max.length() == 0 || str.charAt(0) > max.charAt(0)) {
                    max = str;
                }
            }
        }
        return max;
    }
}