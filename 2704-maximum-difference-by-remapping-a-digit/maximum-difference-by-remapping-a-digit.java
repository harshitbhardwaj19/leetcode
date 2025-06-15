class Solution {
    public int minMaxDifference(int num) {
        String numStr = num + "";
        char first = numStr.charAt(0);
        int pos = 1;
        while (first == '9' && pos < numStr.length()) {
            first = numStr.charAt(pos);
            pos++;
        }
        boolean allSame = true;
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) != numStr.charAt(i + 1)) {
                allSame = false;
                break;
            }
        }
        String max = numStr.replace(first, '9');
        String min = allSame ? numStr.replace(numStr.charAt(0), '0') : numStr.replace(numStr.charAt(0), '0');
        // System.out.println(first);
        // System.out.println(max);
        // System.out.println(min);
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}