class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int arr[] = new int[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            arr[brokenLetters.charAt(i) - 'a'] = 1;
        }
        int count = 0;
        String words[] = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int c = 1;
            for (int j = 0; j < word.length(); j++) {
                if (arr[word.charAt(j)-'a'] == 1) {
                    c = 0;
                    break;
                }
            }
            count += c;
        }
        return count;
    }
}