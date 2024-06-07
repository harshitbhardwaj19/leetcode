class Solution {
    Trie root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for (String word : dictionary) {
            buildTrie(root, word, 0);
        }
        StringBuilder sol = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for(String word : strArr){
            String rootWord = getRootWord(root, word, 0);
            if (sol.length() > 0) {
                sol.append(" ");
            }
            sol.append(rootWord);
        }
        return sol.toString();
    }

    public String getRootWord(Trie root, String word, int index) {
        if (index == word.length()) {
            return word;
        }
        char ch = word.charAt(index);
        if (root.children[ch - 'a'] == null) {
            return word;
        }
        root = root.children[ch - 'a'];
        if(root.isEnding){
            return word.substring(0, index+1);
        }
        return getRootWord(root, word, index+1);
    }

    public void buildTrie(Trie root, String word, int index) {
        char ch = word.charAt(index);
        if (root.children[ch - 'a'] == null) {
            root.children[ch - 'a'] = new Trie();
        }

        root = root.children[ch - 'a'];

        if (index == word.length()-1) {
            root.isEnding = true;
            return;
        }

        buildTrie(root, word, index + 1);
    }
}

class Trie {
    Trie children[];
    boolean isEnding;

    Trie() {
        children = new Trie[26];
    }
}