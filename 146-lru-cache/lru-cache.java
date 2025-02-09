class LRUCache {
    Node head;
    Node tail;
    int size;
    int cap;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
        cap = capacity;
        map = new HashMap();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node.key);
        moveFront(node);
        // System.out.println("get");
        // System.out.println(map);
        // printList();
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = remove(key);
            node.val = value;
            size--;
            moveFront(node);
        } else if (size == cap) {
            remove();
            size--;
            Node node = new Node(key, value);
            map.put(key, node);
            moveFront(node);
        } else {
            Node node = new Node(key, value);
            moveFront(node);
            map.put(key, node);
        }
        size++;
        // System.out.println("put");
        // System.out.println(map);
        // printList();
    }

    private void remove() {
        Node prev = tail.prev;
        Node prevPrev = prev.prev;
        prevPrev.next = tail;
        tail.prev = prevPrev;
        map.remove(prev.key);
    }

    private Node remove(int key) {
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
        return node;
    }

    private void moveFront(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
        head.next = node;
    }

    // private void printList(){
    //     Node node = head;
    //     while(node!=null){
    //         System.out.print(node.key+","+node.val+" -> ");
    //         node = node.next;
    //     }
    //     System.out.println();
    // }

}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int k, int v) {
        key = k;
        val = v;
        next = null;
        prev = null;
    }

    public String toString(){
        return key+","+val+"";
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */