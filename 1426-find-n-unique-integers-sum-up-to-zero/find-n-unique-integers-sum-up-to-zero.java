class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        for (int i = n; i > 0; i = i - 2) {
            if (i == 1) {
                arr[0] = 0;
                break;
            }
            arr[i - 1] = i / 2;
            arr[i - 2] = (-1) * i / 2;
        }
        return arr;
    }
}