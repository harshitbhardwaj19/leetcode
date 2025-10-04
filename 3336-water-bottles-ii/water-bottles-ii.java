class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;
        // int full = 0;

        while(empty >= numExchange){
            empty = empty + 1 - numExchange;
            drunk++;
            numExchange++;
        }
        return drunk;
    }
}