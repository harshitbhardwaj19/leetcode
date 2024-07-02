class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m = nums1.length, n = nums2.length, i=0, j=0;
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i]<nums2[j]){
                i++;
            } else{
                j++;
            }
        }
        int ans[]=new int[list.size()];
        for(int k=0; k<list.size(); k++){
            ans[k]=list.get(k);
        }
        return ans;
    }
}