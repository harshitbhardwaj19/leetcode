class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int l = nums.size();
        int arr[] = new int[l];
        arr[0] = 1;
        for (int i = 1; i < l; i++) {
            if ((nums.get(i - 1) < nums.get(i))) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < l - k; i++) {
            if (arr[i] >= k && arr[i + k] >= k) {
                return true;
            }
        }
        return false;
    }
}