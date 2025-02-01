class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        st.push(temp.length - 1);
        int arr[] = new int[temp.length];
        arr[temp.length - 1] = 0;
        
        for (int i = temp.length - 2; i >= 0; i--) {
            while (st.size() > 0 && temp[i] >= temp[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                arr[i] = 0;
            } else {
                arr[i] = st.peek() - i;
            }
            st.push(i);
        }
        return arr;
    }
}