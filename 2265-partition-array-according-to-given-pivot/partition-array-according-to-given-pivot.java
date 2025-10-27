class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int l = nums.length;
        int arr[] = new int[l];
        int pivotCount = 0;
        int less = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == pivot) {
                pivotCount++;
            } else if (nums[i] < pivot) {
                arr[less] = nums[i];
                less++;
            }
        }
        for (int i = less; i < less + pivotCount; i++) {
            arr[i] = pivot;
        }
        int greater = less + pivotCount;
        for (int i = 0; i < l; i++) {
            if (nums[i] > pivot) {
                arr[greater] = nums[i];
                greater++;
            }
        }
        return arr;
    }
}