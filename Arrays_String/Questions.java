import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Questions{


    // 11. Container With Most Water

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        
        int max = 0;
        
        while(left < right){
            int lh = height[left];
            int rh = height[right];
            
            int min_length = Math.min(lh, rh);
            int len = right-left;
            
            int currArea = min_length * len;
            
            max = Math.max(max, currArea);
            
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    //===================================================================

    // 977. Squares of a Sorted Array

    public int[] sortedSquares_(int[] nums) {
        
        int [] ans = new int[nums.length];
        
        for(int i =0; i<nums.length; i++){
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    // 2.

    public int[] sortedSquares(int[] nums) {
    int left =0;
    int right = nums.length-1;
    int []ans = new int[nums.length]; 
    int square =0;

    for(int i = nums.length-1; i>=0; i--){
        if(Math.abs(nums[left]) < Math.abs(nums[right])){
            square = nums[right];
            right--;
        }else{
            square = nums[left];
            left++;
        }

        ans[i] = square*square;
    }
    return ans;

    }
// ================================================================
// 169. Majority Element

//  approach : by using Boyer moore algo ;
public static int majorityElement(int[] nums) {
    int val = nums[0];
     
     int count =1;
     
     for(int i =1; i<nums.length; i++){
         if(nums[i] ==  val) {
             count++;
         }else if(count == 0){
             val = nums[i];
             count =1;
         
         }else{
             count--;
         }
     }
     return val;
 }

//  ===================================================================

// 229. Majority Element II
public List<Integer> majorityElement2(int[] nums) {
    int val1 = nums[0];
    int val2 = nums[0];
    int count1 =1;
    int count2 = 0;
    
    
    for(int i =1; i<nums.length; i++){
        if(nums[i] == val1){
            count1++;
        }else if(nums[i] == val2){
            count2++;
        }else if(count1 == 0){
            val1 = nums[i];
            count1 =1;
        }else if(count2 == 0){
            val2 = nums[i];
            count2=1;
        }else{
            count1--;
            count2--;
        }
    }
    
//         make freq;
    
    int freq1 =0;
    int freq2 =0;
    
    for(int i =0; i<nums.length; i++){
        if(nums[i] == val1){
            freq1++;
            
        }else if(nums[i] == val2){
            freq2++;
        }
    }
    
    
    ArrayList<Integer> ans = new ArrayList<>();
    
    if(freq1 > nums.length/3){
        ans.add(val1);
    }
    if(val1 != val2 && freq2 > nums.length / 3){
        ans.add(val2);
    }
    
    return ans;
}

// ============================================================
// 556. Next Greater Element III
public int nextGreaterElement(int n) {
    char[] number = (n + "").toCharArray();
      
      int i, j;
      for (i = number.length-1; i > 0; i--){
          if (number[i-1] < number[i]){
             break;
          }
          
   
      }
      if (i == 0){
          return -1;
      }
      
      
      int x = number[i-1], smallest = i;
      for (j = i+1; j < number.length; j++){
          if (number[j] > x && number[j] <= number[smallest]){
              smallest = j;
          }
      }
     
      char temp = number[i-1];
      number[i-1] = number[smallest];
      number[smallest] = temp;
          
      
       // Arrays.sort(number, i, number.length);
      reverseChar_(number,i);
     
      
      long val = Long.parseLong(new String(number));
      return (val <= Integer.MAX_VALUE) ? (int) val : -1;
  }
  private void reverseChar_(char [] arr , int i){
      int start = i;
      int end = arr.length-1;
      while(end >= start){
          char temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          end --;
          start ++;
      }
  }

  // 2 approach

  public int nextGreaterElement_(int nums) {
     
    char[] arr = (nums+"").toCharArray();
        
        int i = arr.length-1;
        
        while(i > 0){
            if(arr[i] > arr[i -1]){
                break;
            }
            i--;
        }
        
        if(i == 0){
            return -1;
        }
        int val1 = i-1;
        
        int val2 = arr.length-1;
        
        while(val2 >= val1){
            if(arr[val1] < arr[val2]){
                break;
            }
            val2--;
        }
        
        System.out.println(arr[val2]+" " + arr[val1]);
        
//         swap
        
        char temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
        
        reverseChar (arr,i);
        
        Long rev = Long.parseLong(new String(arr));
        if(rev <= Integer.MAX_VALUE){
            return rev.intValue();
        }else{
            return -1;
        }
    }
    
    private void reverseChar(char [] arr , int i){
        int start = i;
        int end = arr.length-1;
        while(end >= start){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end --;
            start ++;
        }
    }
// ==================================================================

// 628. Maximum Product of Three Numbers

public int maximumProduct(int[] nums) {
    int max1 = -(int)1e9;  
    int max2 = -(int)1e9;
    int max3 = -(int)1e9;
      
     int min1= (int)1e9;
      int min2 = (int)1e9;
      
      for(int n=0;n<nums.length; n++){
          if(nums[n] < min1){
              min2= min1;
              min1 = nums[n];
          }else if(nums[n] < min2 ){
              min2 = nums[n];
          }
          
          if(nums[n] >= max1){
              max3 = max2;
              max2 = max1;
              max1 = nums[n];
              
          }else if(nums[n] >= max2){
              max3 = max2;
              max2 = nums[n];
              
              
          }else if(nums[n] >= max3){
              max3 = nums[n];
          }
      }
      
      return Math.max(max1*max2*max3, max1*min1*min2);
  }

//   769. Max Chunks To Make Sorted

public int maxChunksToSorted(int[] arr) {
    int max = -(int)1e9;
    int count =0;
    
    for(int i =0; i<arr.length; i++){
        max = Math.max(arr[i],max);
        if(max == i){
            count++;
        }
    }
    return count;
}

// 768. Max Chunks To Make Sorted II

    public int maxChunksToSorted_(int[] arr) {
    int n = arr.length;

    int [] prefixMax = new int[n];
    int [] sufficMin = new int[n];

    prefixMax[0] = arr[0];
    sufficMin[n-1] = arr[n-1];

    for(int i =1;i<n; i++){
        prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
    }

    for(int i= n-2; i>=0; i--){
        sufficMin[i] = Math.min(sufficMin[i+1],arr[i]);
    }

    int ans =0;

    for(int i =0; i<n-1; i++ ){
        if(prefixMax[i] <= sufficMin[i+1]){
            ans++;
        }
    }
    ans++;

        return ans;
    }

    // 795. Number of Subarrays with Bounded Maximum

    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        // int n 
        int ans =0;
        int precount =0;
        int i =0;

        
        for(int j =0; j<arr.length; j++){
            if(arr[j] >= left && arr[j] <= right){
                ans +=((j-i)+1);
                precount += ((j-i)+1);
            }else if(arr[j] < left){
                ans +=precount;
            }else{
                i =j+1;
                precount =0;
            }
        }
        return ans;
    }

    // https://www.lintcode.com/problem/508/
    // wiggle sort 508

    public void wiggleSort(int[] arr) {
        // write your code here
    for(int i =0; i<arr.length-1; i++){
        if(i %2 == 0){
            if(arr[i+1] < arr[i]){
                swap(arr, i, i+1);
            }
        }else{
            if(arr[i+1] > arr[i]){
                swap(arr,i,i+1);
            }

        }
    }


    }
    public void swap(int [] arr , int si , int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    // =============================
    // 747. Largest Number At Least Twice of Others
    public int dominantIndex(int[] arr) {
       
        
        int max = 0;
        int secondMAX =0;
        int maxIdx = -1;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max){
                secondMAX = max;
                max = arr[i];
                maxIdx =i;
            }else if(arr[i] > secondMAX){
                secondMAX = arr[i];
            }
        }
        
        return secondMAX * 2 > max ? -1: maxIdx; 
        
        
    }

    // ==========================================================
    // 238. Product of Array Except Self

    public int[] productExceptSelf(int[] arr) {
        
        int[] ans = new int[arr.length];
        int i=0;
        int product=1;
        
        ans[0] = 1;
        for(i=1; i<arr.length; i++){
               ans[i] = arr[i-1]*ans[i-1];
        }
         
        for(i=arr.length-2; i>=0; i--){
            product = product*arr[i+1];
            ans[i] = ans[i]*product;
        }
        return ans;
    }

    // ======================================================
    // 41. First Missing Positive

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
           
         for(int i =0; i<nums.length; i++){
             if(i+1 == nums[i]) {
                 continue;
             }
             
             if(nums[i] < 1 || nums[i] > n){
                 continue;
             }
             
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

    //    849. Maximize Distance to Closest Person

    public int maxDistToClosest(int[] seats) {
        int maxval =0;
        int  prev=-1;
        int s=seats.length;
        int i=0;
        
        if(seats[0]==1){prev=0;}
        for (i=prev+1;i<s;i++){
            if(seats[i]==1){                                 
                if(prev !=-1){
                    maxval = Math.max(maxval,((i+prev)/2)-prev);
                }else{                    
                     maxval = Math.max(maxval,i-1-prev);
                }                
                prev = i;
            }
        }
        
        return Math.max(maxval,s-1-prev);
    }
// ==============================================================================
// 345. Reverse Vowels of a String

    public String reverseVowels(String s) {
            
        if(s == null || s.length() <= 1){
            return s;
        }
        char [] arr =  s.toCharArray();
        int i =0;
        int j = arr.length -1;
        
        while(i < j){
            if(IsVowel(arr,i) && IsVowel(arr, j)){
                swap(arr, i, j);
                i++;
                j--;
            }else if(IsVowel(arr,i)){
                j--;
            }else if(IsVowel(arr,j)){
                i++;
            }else{
                i++;
                j--;
            }
        }
        
        return new String(arr);
    }

    //     check vowels 
    public boolean IsVowel(char [] arr, int i){
        
        char ch = Character.toLowerCase(arr[i]);
        
        if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    //     swap function
    public void swap(char [] arr, int i , int j ){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // /===============================================

    // 903 · Range Addition    /// lint codet ad
    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] res = new int[length];

        for(int i = 0; i < queries.length; i++) {
            int st = queries[i][0];
            int end = queries[i][1];
            int inc = queries[i][2];

            res[st] += inc;
            if(end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }

    // 215. Kth Largest Element in an Array

    public int findKthLargest(int[] nums, int k) {
       
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0; i<nums.length; i++){
            pq.add(nums[i]);
            
            if(pq.size() > k){
                
             pq.poll();
            }
        }
        
        return pq.poll();
        
//         Arrays.sort(nums);
        
//         return nums[nums.length -k];
        
        
    }


    // 829. Consecutive Numbers Sum
    public int consecutiveNumbersSum(int N) {
        int count =0;
        for(int k =1; k< Math.sqrt(2*N); k++){
            if((N -(k*(k-1)/2))%k ==0){
                count++;
            }
        }
        return count;
    }



    // 33. Search in Rotated Sorted Array
    
    public int search(int[] nums, int target) {
        int si =0; 
       int ei = nums.length-1;
       
       while(si <= ei){
           int mid = (ei+si)/2;
           
           if(nums[mid] == target) return mid;
           else if(nums[si] <= nums[mid]){
               if(nums[si] <= target && target < nums[mid]) ei = mid-1;
               else{
                   si = mid+1;
               }
               
           }else{
               if(nums[mid] < target && target <= nums[ei] )si = mid+1;
               else{
                   ei = mid-1;
               }
           }
       }
       return -1;
   }





    public static void main(String[] args) {
        // int [] nums ={2,4,4,4,5,5};
        // System.out.println(majorityElement(nums));
        // majorityElement(nums);
    }
}