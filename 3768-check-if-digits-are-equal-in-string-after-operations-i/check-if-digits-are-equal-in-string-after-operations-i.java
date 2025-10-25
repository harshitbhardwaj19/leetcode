class Solution {
    public boolean hasSameDigits(String s) {
        int l = s.length();
        int arr[] = new int[l];

        for (int i = 0; i < l; i++) {
            arr[i] = s.charAt(i) - 'a';
        }

        while (l > 2) {
            for (int i = 0; i < l - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            l--;
        }
        return arr[0] == arr[1];
    }
}