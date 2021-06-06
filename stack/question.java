import java.util.Stack;
import java.util.ArrayDeque;

public class question {
    // N : Next, G = greater, S : Smaller, L : Left, R : Right
    public static void NGOR(int[] arr, int[] ans) {
        int n = arr.length;
        Arrays.fill(ans, n); // Java : Arrays.fill(ans,n);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.length != 0 && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
    }

    public static void NGOL(int[] arr, int[] ans) {
        int n = arr.length;
        Arrays.fill(ans, -1); // Java : Arrays.fill(ans,n);

        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i>=0; i--) {
            while (st.length != 0 && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
    }
    public static void NSOR(int[] arr, int[] ans) {
        int n = arr.length;
        Arrays.fill(ans, n); // Java : Arrays.fill(ans,n);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.length != 0 && arr[st.peek()] > arr[i]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
    }

    public static void NSOL(int[] arr, int[] ans) {
        int n = arr.length;
        Arrays.fill(ans, -1); // Java : Arrays.fill(ans,n);

        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i>=0; i--) {
            while (st.length != 0 && arr[st.peek()] > arr[i]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
    }

    // 503

    public int[] nextGreaterElements(int[] nums) {
      
        int n = nums.length;
           int [] ans = new int[n];
           Stack<Integer> st = new Stack<>(); 
           
           Arrays.fill(ans,-1);
           
           for(int i=0; i<n *2; i++){
              int idx = i%n;
               
               while(st.size() != 0 && nums[st.peek()] < nums[idx])
                   
                   ans[st.pop()] = nums[idx];
           
               if(i < n){
                   st.push(idx);
               }
                
           }
           return ans;
           
       
       }

    //    901

        Stack<int[]> st;
        int day;

        public StockSpanner() {
            this.st = new Stack<>();
            this.day = 0;

            st.push(new int[] { -1, -1 }); // {day,Data}
        }

        public int next(int price) {
            while (st.peek()[0] != -1 && st.peek()[1] <= price)
                st.pop();

            int span = day - st.peek()[0];
            st.push(new int[] { day++, price });
            return span;
        }

        // 20

        public boolean isValid(String s) {
        
            Stack<Character> st = new Stack<Character>();
             
             for(char c : s.toCharArray()){
                 if(c =='(') 
                     st.push(')');
                 else if(c == '[') 
                     st.push(']');
                 else if(c == '{') 
                     st.push('}');
                 else if(st.isEmpty() || st.pop() != c) 
                     return false;
             }
             return st.isEmpty();
         }

        //  946
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> st = new Stack<>();
            
            int i=0;
            // int n = popped.size();
            
            for(int ele : pushed){
                st.push(ele);
                while(st.size() !=0 && st.peek() == popped[i]){
                    st.pop();
                        i++;
                }
                    
            }
            return st.size() == 0;
        }

        // 1249
        public String minRemoveToMakeValid(String s) {
            ArrayDeque<Integer> st = new ArrayDeque<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(')
                    st.addFirst(i);
                else if (ch == ')') {
                    if (st.size() != 0 && s.charAt(st.getFirst()) == '(')
                        st.removeFirst();
                    else
                        st.addFirst(i);
                }
            }
    
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (st.size() != 0 && st.getLast() == i) {
                    st.removeLast();
                    continue;
                }
    
                ans.append(s.charAt(i));
            }
    
            return ans.toString();
        }

        // 32
        public int longestValidParentheses(String s) {
        
            Stack<Integer> st = new Stack<>();
              int length =0;
              
              st.push(-1);
              
              for(int i=0; i<s.length(); i++){
                  char ch = s.charAt(i);
                  
                  if(ch == '(') st.push(i);
                  
                  else if (ch ==')'){
                      
                      st.pop();
                      
                      if(st.isEmpty() )st.push(i);
                      else{
                          length = Math.max(length,i-st.peek());
                      }
                  }
              }
              return length;
          }

}