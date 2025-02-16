class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            Node child = node.children[ch - 'a'];
            if (child == null) {
                child = new Node();
                node.children[ch - 'a'] = child;
            }
            node = child;
        }
        node.isEnding = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            Node child = node.children[ch - 'a'];
            System.out.println(child);
            if (child == null) {
                return false;
            }
            node = child;
        }
        return node.isEnding;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            Node child = node.children[ch - 'a'];
            if (child == null) {
                return false;
            }
            node = child;
        }
        return true;
    }
}

class Node {
    Node children[];
    boolean isEnding;

    Node() {
        children = new Node[26];
        isEnding = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */