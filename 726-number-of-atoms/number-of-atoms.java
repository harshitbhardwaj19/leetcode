class Solution {
    public String countOfAtoms(String formula) {
        int i = 0;
        int n = formula.length();
        Stack<Element> st = new Stack<>();
        Element dummy = new Element("(", -1);

        while (i < formula.length()) {
            char ch = formula.charAt(i);
            i++;
            if (ch == '(') {
                st.push(dummy);
            } else if (ch == ')') {

                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    val = val * 10 + formula.charAt(i++) - '0';

                if (val == 0)
                    val = 1;

                Stack<Element> temp = new Stack<>();
                while (st.peek() != dummy) {
                    temp.push(st.pop());
                }

                st.pop();
                while (temp.size() > 0) {
                    Element e = temp.pop();
                    e.count *= val;
                    st.push(e);
                }

            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String s = formula.substring(start, i);
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i++) - '0';
                }
                if (val == 0)
                    val = 1;
                Element e = new Element(s, val);
                st.push(e);
            }
        }

        // System.out.println(st);

        Map<String, Integer> map = new HashMap<>();
        while(st.size()>0){
            Element e = st.pop();
            map.put(e.symbol, map.getOrDefault(e.symbol, 0) + e.count);
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);
        for (String key : list) {
            sb.append(key);
            if (map.get(key) > 1){
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
}

class Element {
    String symbol;
    int count;

    public Element(String s, int c) {
        symbol = s;
        count = c;
    }

    public String toString() {
        return symbol + "" + count;
    }
}