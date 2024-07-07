class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int empty = numBottles;
        int filled =0;
        while(empty>=numExchange){
            filled = empty/numExchange;
            sum+=filled;
            empty = filled + (empty - numExchange * filled);
            System.out.println(empty + "  "+sum);
        }
        return sum;
    }
}