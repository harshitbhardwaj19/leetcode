class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if (eqArr(arr1, arr2)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
            arr2[s2.charAt(i - s1.length()) - 'a']--;
            if (eqArr(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    public boolean eqArr(int arr1[], int arr2[]) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}