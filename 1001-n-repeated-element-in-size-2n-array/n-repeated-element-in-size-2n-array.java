class Solution {
    public int repeatedNTimes(int[] A) {
        for (int i = 0; i < A.length - 2; i++)
            if (A[i] == A[i + 1] || A[i] == A[i + 2])
                return A[i];
        return A[A.length - 1];
    }
}

// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int l = nums.length/2;
//         int n = l/2;
//         Set<Integer> set = new HashSet<>();

//         for(int num:nums){
//             if(set.contains(num)){
//                 return num;
//             }
//             set.add(num);
//         }
//         return -1;
//     }
// }