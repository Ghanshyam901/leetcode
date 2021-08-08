import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
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








    public static void main(String[] args) {
        // int [] nums ={2,4,4,4,5,5};
        // System.out.println(majorityElement(nums));
        // majorityElement(nums);
    }
}