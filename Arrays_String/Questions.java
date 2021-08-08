import java.util.Arrays;
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



    public static void main(String[] args) {
        
    }
}