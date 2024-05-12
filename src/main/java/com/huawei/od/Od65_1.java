package com.huawei.od;

public class Od65_1 {
    public static void main(String[] args) {

    }

    private void dp(int[] cost, int[] play) {
        int[] dp = new int[365];
        int idx = 0;
        for (int i = 1; i <= 365; i++) {
            if (i == play[idx]) {
                for (int j = 0; j < 4; j++) {

                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
    }
}
