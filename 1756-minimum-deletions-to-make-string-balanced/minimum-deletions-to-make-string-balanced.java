class Solution {
    public int minimumDeletions(String s) {
        int dp[][] = new int[s.length()][2];
        dp[0][0] = s.charAt(0) == 'a' ? 0 : 1;
        dp[0][1] = s.charAt(0) == 'a' ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        // for (int i = 0; i < s.length(); i++) {
        //     System.out.println(dp[i][0] + "  " + dp[i][1]);
        // }

        System.out.println(dp);
        return Math.min(dp[s.length()-1][0], dp[s.length()-1][1]);
    }
}