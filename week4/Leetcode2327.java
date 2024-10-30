class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[1] = 1; 
        int totalPeople = 0; 

        for (int day = 2; day <= n; day++) {
            for (int j = Math.max(1, day - forget + 1); j <= day - delay; j++) {
                dp[day] = (dp[day] + dp[j]) % MOD;
            }
        }

        for (int i = n - forget + 1; i <= n; i++) {
            totalPeople = (totalPeople + dp[i]) % MOD;
        }
        return totalPeople;
    }
}