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


    public static void main(String[] args) {
        
    }

}