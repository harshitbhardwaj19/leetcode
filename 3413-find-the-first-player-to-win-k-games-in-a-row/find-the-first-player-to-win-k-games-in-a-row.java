class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int maxIndex = 0;
        int matchesWon = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] < skills[maxIndex]) {
                matchesWon++;
            } else {
                maxIndex = i;
                matchesWon = 1;
            }
            if (matchesWon == k) {
                return maxIndex;
            }
        }
        return maxIndex;
    }
}