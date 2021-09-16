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

    public static void main(String[] args) {
        
    }

}