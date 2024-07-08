class FreqStack {
    HashMap<Integer, List<Integer>> map;
    HashMap<Integer, Integer> freqMap;
    int max;

    public FreqStack() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        max = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0);
        freqMap.put(val, freq + 1);
        max = Math.max(max, freq + 1);

        if (!map.containsKey(freq + 1)) {
            map.put(freq + 1, new ArrayList<>());
        }
        map.get(freq + 1).add(val);
        // System.out.println("Push  "+max+" "+map+" "+freqMap);
    }

    public int pop() {
        List<Integer> list = map.get(max);
        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        int freq = freqMap.get(val);
        freqMap.put(val, freq - 1);
        if (list.size() == 0) {
            max--;
        }
        // System.out.println("POP  "+max+" "+map+" "+freqMap);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */