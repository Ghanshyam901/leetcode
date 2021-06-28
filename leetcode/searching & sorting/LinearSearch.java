
public class LinearSearch {
    
public static boolean Linearsearch(int [] arr , int data){

    for(int i =0; i<arr.length; i++){
        if(arr[i] ==  data){
            // System.out.println("found");
            return true;
           
        }
    }
    // System.out.println("not found");
    return false;
    

}

/// 1021

public String removeOuterParentheses(String s) {
    Stack<Character> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    
    for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
        
        if(ch == '('){
            if(!st.isEmpty()){
                sb.append(ch);
            }
            st.push(ch);
        }else{
            st.pop();
            if(!st.isEmpty()){
                sb.append(ch);
            }
        }
    }
    
    return sb.toString();
}

////643

public double findMaxAverage(int[] nums, int k) {
  
        
        
    int sum =0;
    for(int i =0; i<k; i++){
        sum+=nums[i];
    }
    
    int max =sum;
    
    for(int i =k; i<nums.length; i++){
        sum =sum + nums[i];
        sum = sum - nums[i-k];
        
        
        max = Math.max(sum,max);
    }
    return (max*1.0)/k;
        
}


 public static void main(String[] args) {
        int [] arr ={2,4,8,1,5,0,88,98,66};
            int data= 97;
   
            System.out.println(Linearsearch(arr, data));
      
    }
}
