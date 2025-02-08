class TimeMap {

    Map<String, List<Value>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Value> list = map.get(key);
        if(list==null){
            return "";
        }
        return bs(list, timestamp);
    }

    private String bs(List<Value> list, int timestamp) {
        int start = 0;
        int end = list.size()-1;
        String cand = "";
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid).time == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).time > timestamp) {
                end = mid - 1;
            } else {
                cand = list.get(mid).value;
                start = mid+1;
            }
        }
        return cand;
    }
}

class Value {
    public String value;
    public int time;

    Value(String v, int t) {
        value = v;
        time = t;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */