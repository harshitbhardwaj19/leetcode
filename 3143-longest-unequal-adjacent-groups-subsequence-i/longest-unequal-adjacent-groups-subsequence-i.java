class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int prevGroup = groups[0];
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != prevGroup) {
                list.add(words[i]);
                prevGroup = groups[i];
            } else if (words[i].length() > list.get(list.size() - 1).length()) {
                list.remove(list.size() - 1);
                list.add(words[i]);
            }
        }
        return list;
    }
}