class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int q1 = Integer.parseInt(st.pop());
                int q2 = Integer.parseInt(st.pop());
                if(token.equals("+")){
                    st.push((q2+q1)+"");
                }
                if(token.equals("-")){
                    st.push((q2-q1)+"");
                }
                if(token.equals("*")){
                    st.push((q2*q1)+"");
                }
                if(token.equals("/")){
                    st.push((q2/q1)+"");
                }
            } else {
                st.push(token);
            }
        }
        return Integer.parseInt(st.pop());
    }
}