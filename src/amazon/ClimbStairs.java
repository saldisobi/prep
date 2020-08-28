package amazon;

class ClimbStairs {
    public int climbStairs(int n) {
        if(n < 1){
            return 0;
        }
        
        int[] dp = new int[n+1];
        
    
        
        
        if(n<3){
            return n;
        }
        
        dp[1] = 1;
        
        dp[2] = 2;
        
        for(int i = 3 ;i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
            
        }
        
        return dp[n];
        
        
    }
}