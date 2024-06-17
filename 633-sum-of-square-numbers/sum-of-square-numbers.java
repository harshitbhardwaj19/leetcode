class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<=1){
            return true;
        }
        long start=0;
        long end=(long) (Math.sqrt(c));
        while(start<=end){
            long sum = (long)(start*start)+(long)(end*end);
            if(sum==c){
                return true;
            } else if(sum>c){
                end--;
            } else{
                start++;
            }
        }
        return false;
    }
}