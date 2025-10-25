class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int l = nums.size();
        int min = 1;
        int max = l/2;
        int ans = 1;
        while(min<=max){
            int mid = (min+max)/2;
            // System.out.println(max+". "+ mid +". "+ min);
            if(hasIncreasingSubarrays(nums,mid)){
                ans = mid;
                min = mid+1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }
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