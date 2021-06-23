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




  public static void main(String[] args) {
        
    }
}
