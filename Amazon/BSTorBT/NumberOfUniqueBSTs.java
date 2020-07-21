package Amazon.BSTorBT;

public class NumberOfUniqueBSTs {

    static int numTrees(int n){
        long[] dp = new long[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            dp[i] = 0;
            for(int j=0; j<i; j++){
                long res = (dp[j]*dp[i-j-1])%1000000007;
                dp[i] = (dp[i] + res)%1000000007;
            }
        }
        return (int)dp[n];
    }


}
