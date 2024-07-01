class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        arr[0] = arr[0]%2==1 ? 1 : 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] % 2 ==1){
                arr[i] = arr[i-1]+1;
                if(arr[i]==3){
                    return true;
                }
            } else {
                arr[i] = 0;
            }
        }
        return false;
    }
}