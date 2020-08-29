package amazon;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        
        int[][] uniquePathLookUp = new int[m][n];
        
        for(int i = 0 ; i < m ; i ++){
            uniquePathLookUp[i][0]  =1 ;
        }
        
        for(int j = 0 ; j < n ; j ++){
            uniquePathLookUp[0][j]  = 1;
        }
        
        for(int i = 1; i < m ; i ++){
            for(int j = 1 ; j < n ; j ++){
                uniquePathLookUp[i][j]  =  uniquePathLookUp[i-1][j] + uniquePathLookUp[i][j-1];
            }
        }
        
        return uniquePathLookUp[m-1][n-1];
    }
}