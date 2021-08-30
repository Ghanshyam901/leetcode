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


    public static void main(String[] args) {
        
    }
}
