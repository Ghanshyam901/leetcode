public class solution {
    


    ///1380

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        
        
        for(int i =0; i<n; i++){
            int min = Integer.MAX_VALUE;
            int idx = -1;
              for(int j =0; j<m; j++){
                  if(matrix[i][j] < min){
                      min = matrix[i][j];
                      idx =j;
                      
                  }
              }
            
            int maxI = -1;
            for(int j =0; j<n; j++){
                if(matrix[j][idx] > maxI){
                    maxI = matrix[j][idx];
                    
                }
            }
            
            if(maxI == min){
                list.add(maxI);
            }
        }
        return list;
    }


    ////////////////  1365

    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int [] num = nums.clone();
        
        Arrays.sort(num);
        
        for(int i = 0; i< nums.length; i++){
            map .putIfAbsent(num[i],i);
            
        }
        for(int i =0; i<nums.length; i++){
            num[i] = map.get(nums[i]);
        }
        return num;
        
        
        
    }

    //// 1464  

    public int maxProduct(int[] nums) {
        int length = nums.length;
        
        if(length == 1){
            return nums[0];
        }
               

        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
         if(length == 2){
            return (nums[0]-1) *(nums[1]-1);
        }
        
        if(length == 2){
            return (nums[0]-1) *(nums[1]-1);
        }
        
        for(int i =0; i<length; i++){
            
            
            if(nums[i] >= max2){
                
                if(nums[i] >= max1){
                max2 = max1;
                max1 = nums[i];
                
                
            }else{
                max2 = nums[i];
            }
        }
        
        }
        return (max1 -1) * (max2-1);
   
    }

    //   1486

    public int xorOperation(int n, int start) {
        
        int ans = start;
        
        for(int i =1; i<n; i++){
            ans^=(start+2*i);
        }
        return ans;
        
    }


    //1437

    public boolean kLengthApart(int[] nums, int k) {
        int j =-1;
        
        for(int i =0; i<nums.length; i++){
            if(nums[i] == 1 && j == -1){
                j = i;
                
                 
            }else if(nums[i] == 1){
                if(i -j-1 < k ){
                    return false;
                } 
                
                j = i;
            }
        }
        return true;
    }

    ////498. Diagonal Traverse

    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0){
            return new int[]{}; 
        }
        
        int m = mat.length;
        int n = mat[0].length;
        
        int row =0;
        int col =0;
        int res [] = new int[m*n];
        
        for(int i=0; i<res.length; i++){
            res[i] = mat[row][col];
            if((row + col) % 2 == 0){
                if(col == n-1){
                    row++;
                }else if(row == 0){
                    col++;
                    
                }else{
                    row--;
                    col++;
                    
                }
                
                
            }else{
                
                if(row == m-1){
                    col ++;
                    
                }else if(col == 0){
                    row++;
                }else{
                    row++;
                    col--;
                }
                
            }
        }
        return res;
    }



  public static void main(String[] args) {



    }
}
