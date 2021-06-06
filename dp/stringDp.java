import java.util.Arrays;

public class stringDp {

    //leetcode 516 

    //  approach . 1 -> check 1 and last is same if same then i++,j--  if not itreate one by one 

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][]dp = new int[s.length()][s.length()];
        
        // for(int [] d : dp) Arrays.fill(d,0);
        return Longsubs_dp(s,0,n-1,dp);
        
    
    }
    
    public int Longsubs(String s, int i, int j,int[][] dp){
        
        if(i >= j) {
            return dp[i][j] = (i==j) ? 1:0;
        } 
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) ==  s.charAt(j)) return dp[i][j] = Longsubs(s, i+1,j-1,dp)+2;
        
        return dp[i][j]= Math.max(Longsubs(s,i+1,j,dp),Longsubs(s,i,j-1,dp));
        
        
    }
        public int Longsubs_dp(String s, int I, int J,int[][] dp){
        
            
         int n = s.length();
            
            for(int gap =0; gap < n; gap++){
                for(int i=0,j = gap; j < n; i++, j++){
                    
                     if(i == j) {
                     dp[i][j] = 1;
                         continue;
            } 
        
        // if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) ==  s.charAt(j)) 
            dp[i][j] = dp[i+1][j-1]+2; //Longsubs(s, i+1,j-1,dp)+2;
        
        else 
            dp[i][j]= Math.max(dp[i+1][j], dp[i][j-1]);         //(Longsubs(s,i+1,j,dp),Longsubs(s,i,j-1,dp));
                }
            }
       
        return dp[I][J];
        
    }

    ///// 516

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int [][]dp = new int[n+1][m+1];
        
        for (int [] d :dp) Arrays.fill(d,-1);
        
        int ans = numDistnct_memo(s,t,n,m,dp);
        return ans;
        
    }
    public int numDistnct_memo(String s, String t, int n, int m , int [][] dp){
        if(m == 0) {
            return dp[n][m] =1;
        }
        
        if(n < m) {
            return dp[n][m] = 0;
        
        }
        if(dp[n][m] != -1) return dp[n][m];
        
        
        int count = 0;
        
        if(s.charAt(n-1) == t.charAt(m-1)){
            count += numDistnct_memo(s,t,n-1,m-1,dp);
            count += numDistnct_memo(s,t,n-1,m,dp);
        }else{
            count += numDistnct_memo(s,t,n-1,m,dp);
        } 
        return dp[n][m] = count;
    }
    


   public static void main(String[] args) {
        System.out.println("hello");
    }
}
