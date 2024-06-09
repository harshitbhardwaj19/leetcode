class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        
        boolean[] possible = new boolean[4001];
        possible[0] = true; // Initial reward is 0
        
        int maxReward = 0;
        
        for (int reward : rewardValues) {
            for (int j = reward-1; j >= 0; j--) {
                if (possible[j]) {
                    possible[j + reward] = true;
                    maxReward = Math.max(maxReward, j+reward);

                }
            }
        }    
        return  maxReward;
    }
}