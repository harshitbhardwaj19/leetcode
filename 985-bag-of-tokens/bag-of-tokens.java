class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int max = 0;
        int start = 0;
        int end = tokens.length - 1;
        while (start <= end) {
            if (power >= tokens[start]) {
                score++;
                power -= tokens[start];
                start++;
            } else if (score>0){
                score--;
                power += tokens[end];
                end--;
            } else {
                return max;
            }
            max = Math.max(max, score);
        }
        return max;
    }
}