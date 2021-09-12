public class OA {
    


// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1# a
public int maxSumIS(int arr[], int n)  
	{  

	  int [] dp = new int[n];
	  
	  int omax = Integer.MIN_VALUE;
	  
	  for(int i =0; i<dp.length; i++){
	      int max = Integer.MIN_VALUE;
	      for(int j =0; j<i;j++){
	          if(arr[j] < arr[i]){
	              if(max == Integer.MIN_VALUE){
	                  max = dp[j];
	              }else if(dp[j] > max){
	                  max = dp[j];
	              }
	          }
	      }
	      
	      if(max == Integer.MIN_VALUE){
	         dp[i] = arr[i];
	      }else{
	          dp[i] = arr[i] + max;
	      }
	      
	      if(dp[i] > omax){
	          omax = dp[i];
	      }
	  }
	  return omax;
	}  


    // 300. Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
       
        int n = nums.length;
        int [] dp = new int[n];
        int omax =0;   
       
        
        for(int i =0; i<dp.length; i++){
               int max =0;
                for(int j =0; j<i; j++){
                    if(nums[j] < nums[i]){
                        if(dp[j] > max)
                        max = dp[j];
                    }
                }
            dp[i] = max+1;
            if(dp[i] > omax){
             omax = dp[i];
            }
         }
            return omax;
    
        }


		// https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1#

		public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int [] lis = new int[n];
        
        for(int i =0; i<nums.length; i++){
            int max =0;
            for(int j =0; j<i; j++){
                if(nums[j] < nums[i]){
                    if(max < lis[j])
                    max = lis[j];
                }
            }
            lis[i] = max+1;
        }
        
        int [] lds = new int[n];
        
        for(int i = nums.length-1; i >= 0; i--){
            int max = 0;
            for(int j = nums.length-1; j>i; j--){
                if(nums[j] < nums[i]){
                    if(max < lds[j]){
                        max = lds[j];
                    }
                    
                }
            }
            lds[i] = max+1;
        }
        
        int omax =0;
        
        for(int i =0; i<nums.length; i++){
            if(lis[i] + lds[i] -1 > omax ){
                omax = lis[i] + lds[i] -1;
            }
        }
        return omax;
    }

	// https://leetcode.com/problems/palindromic-substrings/submissions/
	public int countSubstrings(String s) {
        
        
        boolean [][] dp = new boolean[s.length()][s.length()];
        int count =0;
        
        for(int gap =0; gap <s.length(); gap++){
            for(int i=0,j = gap; j<dp.length; i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j] == true){
                    count++;
                }
            }
        }
        return count;
    }

	// https://leetcode.com/problems/longest-palindromic-substring/submissions/

	public String longestPalindrome(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        // int count =0;
        String ans ="";
        for(int gap =0; gap <s.length(); gap++){
            for(int i=0,j = gap; j<dp.length; i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j] == true){
                   ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
//   64. Minimum Path Sum

public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    
    int[][] dp = new int[n][m];
    int max = Integer.MIN_VALUE;
    
    for(int i = dp.length-1; i>=0; i--){
        for(int j = dp[0].length-1; j>=0; j--){
            
            if(i == dp.length-1 && j == dp[0].length-1){
             dp[i][j] = grid[i][j];
                max = dp[i][j];
            }else if(i == dp.length -1){
                dp[i][j] = grid[i][j] + dp[i][j+1];
                max = dp[i][j];
            }else if(j == dp[0].length-1){
                 dp[i][j] = grid[i][j] + dp[i+1][j];
                max = dp[i][j];
            }else{
                
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
                max = dp[i][j];
            }
        }
    }
    return max;
}

// 45. Jump Game II

public int jump(int[] nums) {
        
    Integer [] dp = new Integer[nums.length];
    dp[nums.length-1] = 0;
    
    
   
    for(int i = nums.length-2; i>=0; i--){
        int step = nums[i];
        
         int min = Integer.MAX_VALUE;
        
        for(int j =1; j<=step && i+j < nums.length; j++){
            if(dp[i+j] != null && dp[i+j] < min){
                min = dp[i+j];
            }
        }
        
        if(min != Integer.MAX_VALUE){
            dp[i] = min+1;
        }
    }
    return dp[0];
}

// 55. Jump Game
public boolean canJump(int[] nums) {
    int n = nums.length;
    boolean [] dp = new boolean[n];
    
    dp[n-1] = true;
    
    for(int i = n-2; i>=0; i--){
        int step = nums[i];
        for(int j =0; j<=step && i+j < n; j++){
            if(dp[i+j] == true){
                dp[i] = true;
                break;
            }
        }
    }
    return dp[0];
}


// https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1

static int maxGold(int n, int m, int M[][])
{
   
   int max = 0;
   
   int dp[][] = new int[n][m];
   
   for(int i=0;i<M.length; i++){
       max = Math.max(max, maxGoldrec(M,i,0,dp));
   }
   return max;
}
public static int maxGoldrec (int [][] arr, int sr, int sc,int[][] dp){
    
    if(sr < 0 || sr >= arr.length){
        return 0;
    }
    if(sc == arr[0].length-1){
        return arr[sr][sc];
    }
    if(dp[sr][sc] !=0){
        return dp[sr][sc];
    }
    
    int rec1 = maxGoldrec(arr, sr-1,sc+1,dp);
    int rec2 = maxGoldrec(arr, sr,sc+1,dp);
    int rec3 = maxGoldrec(arr, sr+1,sc+1,dp);
    
    int ans = arr[sr][sc] + Math.max(rec1,Math.max(rec2,rec3));
    dp[sr][sc] = ans;
    return ans;
}

    public static void main(String[] args) {
        
    }
}
