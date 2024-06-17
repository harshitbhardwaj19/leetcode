class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int i = left;
        int j = right;
        int count = 0;
        while(i != 0 && j != 0){
            i = i >> 1;
            j = j >> 1;
            count++;
            System.out.println("Iteration " + count + ", i = " + i + ", j = " + j);
        }
        if( (i ==0 && j!=0) || (i !=0 && j==0)){
            return 0;
        }
        count--;

        int ans = 0;
        while(count >= 0){
            System.out.println(count+"  "+((left>>count) & 1) +"  "+((right>>count) & 1));
            if( ((left>>count) & 1) !=  ((right>>count) & 1)){
                System.out.println("Early exit at count " + count + ", left >> " + count + " = " + (left >> count) + ", right >> " + count + " = " + (right >> count));
                return ans;
            }
            ans += ((left>>count) & 1)<<count;
            count--;
        }

        return ans;
    }
}