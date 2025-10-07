class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for (String word : words) {
            if (word.contains(x+"")) {
                list.add(i);
            }
            i++;
        }
        return list;
    }
}