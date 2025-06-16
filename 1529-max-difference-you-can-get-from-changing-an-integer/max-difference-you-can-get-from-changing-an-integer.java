class Solution {
    public int maxDiff(int num) {
        String numStr = num + "";
        char first = numStr.charAt(0);
        int pos = 1;
        while (first == '9' && pos < numStr.length()) {
            first = numStr.charAt(pos);
            pos++;
        }
        String max = numStr.replace(first, '9');

        char firstMin = numStr.charAt(0);
        pos = 1;
        while ((firstMin == '1' || firstMin == '0') && pos < numStr.length()) {
            firstMin = numStr.charAt(pos);
            pos++;
        }
        String min = firstMin == numStr.charAt(0) ? numStr.replace(firstMin, '1') : numStr.replace(firstMin, '0');
        System.out.println(first);
        System.out.println(max);
        System.out.println(min);
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}