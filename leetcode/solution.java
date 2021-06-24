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


    /////862. Shortest Subarray with Sum at Least K

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long [] newArr = new long[n+1];
        for(int i=0; i<n; i++){
            newArr[i+1] = newArr[i] + (long)nums[i];
        }
        
        int ans = n+1;
        
        Deque<Integer> que = new LinkedList<>();
        
        for(int y=0; y<newArr.length; y++){
            while(!que.isEmpty() && newArr[y] <= newArr[que.getLast()]){
                que.removeLast();
            }
            while(!que.isEmpty() && newArr[y] >= newArr[que.getFirst()] + k){
                ans = Math.min(ans,y-que.removeFirst());
            }
            
            que.addLast(y);
        }
        
        if(ans < n+1){
            return ans;
        }else{
            return -1;
        }
    }

//////// decode ways 2

static int mod =1000000007;
public int numDecodings(String s) {
    long[] dp = new long[s.length() + 1];
    Arrays.fill(dp, -1);
    long ans = numDecodings_opti(s);
    return (int) ans; 
}
public long numDecodings_opti(String s) {
    long a = 1, b = 0;
    for (int idx = s.length() - 1; idx >= 0; idx--) {

        long count = 0;
        char ch1 = s.charAt(idx);
        if (ch1 == '0') {
            count = 0;
        } else if (ch1 == '*') {
            count = (count + 9 * a) % mod;
            if (idx < s.length() - 1) {
                char ch2 = s.charAt(idx + 1);
                if (ch2 == '*')
                    count = (count + 15 * b) % mod;
                else if (ch2 >= '0' && ch2 <= '6')
                    count = (count + 2 * b) % mod;
                else if (ch2 > '6')
                    count = (count + b) % mod;

            }
        } else {
            count = (count + a) % mod;
            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) != '*') {
                    char ch2 = s.charAt(idx + 1);
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num <= 26)
                        count = (count + b) % mod;
                } else {
                    if (s.charAt(idx) == '1')
                        count = (count + 9 * b) % mod;
                    else if (s.charAt(idx) == '2')
                        count = (count + 6 * b) % mod;
                }
            }
        }

        b = a;
        a = count;
    }

    return (int) a;
}s


  public static void main(String[] args) {



    }
}
