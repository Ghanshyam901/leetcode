
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


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

    // 1178. Number of Valid Words for Each Puzzle
    // TLE for 1 input

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i =0; i<26; i++){
            map.put((char)('a'+i),new ArrayList<>());
            
        }
        
        for(String word : words){
            int mask =0;
            for(char ch :word.toCharArray()){
                int bit = ch -'a';
                mask = mask | ((1 << bit));
                
            }
            HashSet<Character> uniqueSet = new HashSet<>();
            for(char ch : word.toCharArray()){
                if(uniqueSet.contains(ch)){
                    continue;
                }
                uniqueSet.add(ch);
                map.get(ch).add(mask);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(String puzzle : puzzles){
            int pmask =0;
            for(char ch : puzzle.toCharArray()){
                int bit = ch -'a';
                pmask = pmask | ((1 << bit)); 
            }
            char fch = puzzle.charAt(0);
            ArrayList<Integer> wordTocheck =map.get(fch);
            int count = 0;
            
            for(int wmask : wordTocheck){
                if((wmask &pmask) == wmask){
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }

    // 136. Single Number

    public int singleNumber(int[] nums) {
        int uni = 0;
        for(int num : nums){
            uni = uni ^ num;
        }
        return uni;
    }


    // 260. Single Number III
        public int[] singleNumber_(int[] nums) {
            int xory =0;
            for(int num : nums){
                xory = xory ^ num;
            }
            
            int rmsb = xory &(~xory +1); // right mist set bit
            int a =0;
            int b= 0;
            
            for(int num : nums){
                if((num & rmsb) == 0){
                    a = a^num; 
                }else{
                    b = b^num;
                }
            }
            
            return new int[]{a,b};
        }

        // 268. Missing Number

        public int missingNumber(int[] nums) {
            int xor =0;
            for(int i =0; i<nums.length; i++){
                xor = xor ^ nums[i];
            }
            
            for(int i=1; i<=nums.length; i++){
                xor = xor ^i;
            }
            
            int rmsb = xor & (~xor+1);
            
            int x= 0;
            int y =0;
            
            for(int num : nums){
                if((num & rmsb) == 0){
                    x = x^num;
                }else{
                    y = y ^ num;
                }
            }
            
            for(int i =1; i<=nums.length; i++){
                if((i & rmsb) == 0){
                    x = x^i;
                }else{
                    y = y ^ i;
                }
            }
            int missing = 0;
            for(int num : nums){
                if(num == x){
                  missing = y;
                }else if(num == y){
                     missing = x;
                }
            }
            return missing;
        }

        // 137. Single Number II
        // note ->  -ve test cases failed

        public int singleNumber1(int[] nums) {
        
            int tn = Integer.MAX_VALUE;
            int tnp1 =0;
            int tnp2 =0;
        
    //         cw = common with 
            for(int i =0; i<nums.length; i++){
                int cwtn = nums[i] & tn;
                int cwtn1 = nums[i] & tnp1;
                int cwtn2 = nums[i] & tnp2;
                
                tn = tn & (~cwtn);
                tnp1 = tnp1 | cwtn;
                
                tnp1 = tnp1 &(~cwtn1);
                tnp2 = tnp2 | cwtn1;
                
                tnp2 = tnp2 &(~cwtn2);
                tn = tn | cwtn2;
            }
            return tnp1 ;
        }

        // 1442. Count Triplets That Can Form Two Arrays of Equal XOR

        public int countTriplets(int[] arr) {
       
            int tCount =0;
          
            for(int i =0; i<arr.length; i++){
                
                int val = arr[i];
              
                for(int k = i+1; k<arr.length; k++){
                    val = val ^ arr[k];
                    if(val == 0){
                        tCount +=(k-i);
                    }
                }
            }
            return tCount;
        }
    

    public static void main(String[] args) {
        
    }

}