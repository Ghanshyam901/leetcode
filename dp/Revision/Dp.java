public class Dp {

    public static void display(int[] dp) {
        for (int ele : dp) {
            System.out.println(ele + " ");
        }
        System.out.println();
    }

    public static void Display(int[][] dp) {

        for (int[] ele : dp) {
            display(ele);

        }
        System.out.println();

    }

    // 62 lc
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        return mazePath_memo(0, 0, m - 1, n - 1, dp, dir, obstacleGrid);
    }

    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir, int[][] obstacleGrid) {
        if (er == sr && ec == sc) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int[] d : dir) {
            int r = sr + d[0], c = sc + d[1];
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && obstacleGrid[r][c] == 0) {
                count += mazePath_memo(r, c, er, ec, dp, dir, obstacleGrid);
            }
        }

        return dp[sr][sc] = count;
    }
// lc 746

public int minCostClimbingStairs(int[] cost) {
    int N = cost.length;
    int[] dp  = new int[N];
    
    for(int n =0; n<N; n++){
        if(n <= 1){ 
             dp[n] = cost[n];
            continue;
        }
        
        int ans = Math.min(dp[n-1],dp[n-2])+cost[n];
        dp[n] = ans;
    }
    return Math.min(dp[N-1],dp[N-2]);
}



    public static void main(String[] args) {

    }

}