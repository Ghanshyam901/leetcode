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


    public static void main(String[] args) {
        
    }
}
