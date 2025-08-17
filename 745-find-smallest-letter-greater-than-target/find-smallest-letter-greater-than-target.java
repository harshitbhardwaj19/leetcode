class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;
        if (target >= letters[e]) {
            return letters[s];
        }
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target >= letters[m]) {
                s = m+1;
            } else {
                e = m-1;
            }
        }
        return letters[s];
    }
}

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         int start = 0;
//         int end = letters.length-1;
//         if(letters[end]<=target){
//             return letters[start];
//         }
//         while(start<end){
//             int mid = (start+end)/2;
//             if(letters[mid]>target){
//                 end = mid;
//             } else {
//                 start = mid+1;
//             }
//         }
//         return letters[start];
//     }
// }