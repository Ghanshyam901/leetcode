
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

    public static void main(String[] args) {
        
    }

}