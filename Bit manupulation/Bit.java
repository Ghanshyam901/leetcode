
import java.util.List;
import java.util.ArrayList;


class Bit{

    // 191. Number of 1 Bits
    public int hammingWeight(int n) {
        
        int count =0;
        
        while(n != 0){
            int rsb = n &(~n+1);
            n-=rsb;
            count++;
        }
        return count;
    }
// Josephus Special

    public static int powerof2(int n){
        int i =1;
        while(i * 2 <= n)
        {
            i = i*2;
            
        }
        return i;
    }
    public static int solution(int n){
    //write your code here
    
    int power2 = powerof2(n);
    int l = n-power2;
    return 2*l+1;
    
    }

    // 89. Gray Code

    public List<Integer> grayCode(int n) {
        
        if(n ==1){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            
            return ans;
        }
        
        List<Integer> temp = grayCode(n - 1);
        int x = 1 << (n-1);
        for (int i = temp.size() - 1; i >= 0; i--) {
            temp.add(temp.get(i) + x);
        }
        return temp;
    }

    public static void main(String[] args) {
        
    }

}