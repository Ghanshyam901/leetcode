  
import java.util.Arrays;
import java.util.LinkedList;

public class dp{
    public static void print1D(int[] arr) {

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] ar : arr) {
            print1D(ar);
        }
    }

    public static int fib_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != -1)
            return dp[n];

        int ans = fib_memo(n - 1, dp) + fib_memo(n - 2, dp);
        return dp[n] = ans;
    }

    public static int fib_DP(int N, int[] dp) {   //tabolation

        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fib_01(n - 1, dp) + fib_01(n - 2, dp);

            dp[n] = ans;
        }

        return dp[N];
    }
    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        if (sc + 1 <= ec)
            count += mazePath_memo(sr, sc + 1, er, ec, dp);
        if (sr + 1 <= er)
            count += mazePath_memo(sr + 1, sc, er, ec, dp);
        if (sc + 1 <= ec && sr + 1 <= er)
            count += mazePath_memo(sr + 1, sc + 1, er, ec, dp);

        return dp[sr][sc] = count;
    }

    public static int mazePath_DP(int SR, int SC, int er, int ec, int[][] dp) {
        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {

                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                if (sc + 1 <= ec)
                    count += dp[sr][sc + 1];// mazePath_memo(sr, sc + 1, er, ec, dp);
                if (sr + 1 <= er)
                    count += dp[sr + 1][sc];// mazePath_memo(sr + 1, sc, er, ec, dp);
                if (sc + 1 <= ec && sr + 1 <= er)
                    count += dp[sr + 1][sc + 1]; // mazePath_memo(sr + 1, sc + 1, er, ec, dp);

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static int mazePathInfi_memo(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int jump = 1; sc + jump <= ec; jump++)
            count += mazePathInfi_memo(sr, sc + jump, er, ec, dp);
        for (int jump = 1; sr + jump <= er; jump++)
            count += mazePathInfi_memo(sr + jump, sc, er, ec, dp);
        for (int jump = 1; sc + jump <= ec && sr + jump <= er; jump++)
            count += mazePathInfi_memo(sr + jump, sc + jump, er, ec, dp);

        return dp[sr][sc] = count;
    }

    public static int mazePathInfi_DP(int SR, int SC, int er, int ec, int[][] dp) {

        for (int sr = er; sr >= SR; sr--) {
            for (int sc = ec; sc >= SC; sc--) {

                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int jump = 1; sc + jump <= ec; jump++)
                    count += dp[sr][sc + jump]; // mazePathInfi_memo(sr, sc + jump, er, ec, dp);
                for (int jump = 1; sr + jump <= er; jump++)
                    count += dp[sr + jump][sc]; // mazePathInfi_memo(sr + jump, sc, er, ec, dp);
                for (int jump = 1; sc + jump <= ec && sr + jump <= er; jump++)
                    count += dp[sr + jump][sc + jump]; // mazePathInfi_memo(sr + jump, sc + jump, er, ec, dp);

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }
    public static int boardPath_opti(int sp, int ep) {
        LinkedList<Integer> list = new LinkedList<>();

        for (sp = ep; sp >= 0; sp--) {
            if (sp >= ep - 1)
                list.addFirst(1);
            else {
                if (list.size() <= 6)
                    list.addFirst(list.getFirst() * 2);
                else
                    list.addFirst(list.getFirst() * 2 - list.removeLast());
            }
        }

        return list.getFirst();

    }


    static long mod = (int) 1e9 + 7;

    public long countFriendsPairings(int n) 
    { 
       //code here
       
       
       long [] dp = new long[n+1];
       
    //   return countfriends_memo(n,dp);
       
       return countfriends_dp(n,dp);
    }
    public long countfriends_memo(int n, long[] dp){
        
        if(n<=1){
            return dp[n] = 1;
        }
        
        if(dp[n] !=0){
            
        
         return dp[n];
        
        }
        long single = countfriends_memo(n-1,dp);
        long pair  = countfriends_memo(n-2,dp)*(n-1);
        
        return dp[n] = (single % mod + pair % mod) % mod;
    }
     public long countfriends_dp(int N, long[] dp){
        
        
        for(int n=0; n<=N; n++){
        if(n<=1){
            dp[n] = 1;
            continue;
        }
        
        long single = dp[n-1];
        long pair  = dp[n-2] * (n-1);
        
        dp[n] = (single % mod + pair % mod) % mod;
        
     }
        return dp[N]; 
        
        
    }

  public static void main(String[] args) {

        
    }
}

