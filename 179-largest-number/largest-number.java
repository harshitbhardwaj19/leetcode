class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String arr[] = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i]+"";
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s1+s2).compareTo(s2+s1); 
            }
        });
        // for(int i=0; i<nums.length; i++){
        //     System.out.print(arr[i]+"  ");
        // }
        if (arr[arr.length-1].charAt(0) == '0') return "0";
        String str="";
        for(int i=0; i<arr.length; i++){
            str = arr[i] + str;
        }
        return str;
    }
}