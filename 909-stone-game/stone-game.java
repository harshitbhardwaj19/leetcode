class Solution {
    public boolean stoneGame(int[] piles) {
        int start = 0;
        int end = piles.length - 1;

        int alice=0;
        int bob=0;

        boolean aTurn = true;

        while(start<=end){
            if(piles[start] > piles[end]){
                if(aTurn){
                    alice+=piles[start];
                } else {
                    bob+=piles[start];
                }
                start++;
            } else {
                if(aTurn){
                    alice+=piles[start];
                } else {
                    bob+=piles[start];
                }
                end--;
            }
        }
        return alice>bob;
    }
}