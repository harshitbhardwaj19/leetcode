class Solution {
    double[][] memo;

    public double soupServings(int n) {
        if (n > 5000) return 1.0;
        memo = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1.0);
        }
        return getProb(n, n);
    }

    public double getProb(int A, int B) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        }

        if (A <= 0) {
            return 1.0;
        }

        if (B <= 0) {
            return 0.0;
        }

        if (memo[A][B] != -1) {
            return memo[A][B];
        }

        double prob1 = getProb(A - 100, B);
        double prob2 = getProb(A - 75, B - 25);
        double prob3 = getProb(A - 50, B - 50);
        double prob4 = getProb(A - 25, B - 75);

        double prob = 0.25 * (prob1 + prob2 + prob3 + prob4);

        memo[A][B] = prob;
        return prob;
    }
}