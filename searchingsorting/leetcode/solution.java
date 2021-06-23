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




  public static void main(String[] args) {
        
    }
}
