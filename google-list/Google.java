public class google{


    //332

    public boolean isSelfCrossing(int[] distance) {
        if(distance.length <= 3){
            return false;
        }
        
        int i =2;
        //spiraling 
        
        while(i <distance.length && distance[i] > distance[i-2]){
            i++;
        }
        
        if(i >= distance.length){
            return false;
        }
        
        //
        if(i >=4 && distance[i] >= distance[i-2]-distance[i-4] || (i ==3  && distance[i]==distance[i-2])){
            distance[i-1] -=distance[i-3];
        }
        
        i++;
        
        while(i< distance.length){
            if(distance[i] >=distance[i-2]){
                return true;
            }
            i++;
        }
        
        return false;
    }


    /// jump 2 lc: 45

    public int jump(int[] nums) {
        // int count =0;
        Integer [] dp = new Integer[nums.length];
            dp[nums.length-1] =0;    
            
        for(int i = nums.length-2; i>=0; i--){
            int steps = nums[i];
            
         int min = Integer.MAX_VALUE;
            for(int j =1; j<=steps && i+j < nums.length; j++){
                if(dp[i+j] != null && dp[i+j] < min){
                    min = dp[i+j];  
                    // count++;
                }
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i] = min+1;
                // count++;
            }
        }
     
        
        return dp[0];
    }

    // 41 find missiing number

    public int firstMissingPositive(int[] nums) {
     
        int n = nums.length;
        
        for(int i =0; i<nums.length; i++){
            if(i+1 == nums[i])continue;
            
            if(nums[i] < 1 || nums[i] > n)continue;
            
            int idx1 = i;
            int idx2 = nums[i]-1;
            
            if(nums[idx2] == nums[idx1]) continue;
            
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            i--;
        }
        int ans = -1;
        for(int i =0; i<n; i++){
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }


public static void main(String[] args) {
    
}


}