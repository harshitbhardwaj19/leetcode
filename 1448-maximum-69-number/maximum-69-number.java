class Solution {
    public int maximum69Number(int num) {
        char arr[] = (num + "").toCharArray();
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        return Integer.parseInt(str);
    }
}