class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Integer arr[] = new Integer[len];
        for(int i = 0;i<len; i++){
            arr[i] = i;
        }
        Arrays.sort(arr, (a,b) -> heights[b] - heights[a]);
        String ans[] = new String[len];
        for(int i = 0;i<len; i++){
            ans[i] = names[arr[i]];
        }
        return ans;
    }
}