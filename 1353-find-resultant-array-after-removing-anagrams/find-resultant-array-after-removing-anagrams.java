class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        int prev = 0;
        for (int i = 1; i < words.length; i++) {
            if (isAnagram(words[prev], words[i])) {
                continue;
            } else {
                list.add(words[prev]);
                prev = i;
            }
        }
        list.add(words[prev]);
        return list;
    }

    public boolean isAnagram(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int arr[] = new int[26];
        for (int i = 0; i < w1.length(); i++) {
            arr[w1.charAt(i) - 'a']++;
            arr[w2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}