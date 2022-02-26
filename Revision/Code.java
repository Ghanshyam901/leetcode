import java.util.HashMap;

class Code{
    public static void main(String[] args) {
        
    }
// https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/note

public int lengthOfLongestSubstringTwoDistinct(String s) {
    HashMap<Character,Integer> map = new HashMap<>();
    int dis =0;
    int start =0;
    int ans =0;

    for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
        int fre = map.getOrDefault(ch,0);
        if(fre == 0)dis++;
        map.put(ch,fre+1);

        while(dis > 2){
            fre = map.get(s.charAt(start));
            map.put(s.charAt(start),fre-1);
            if(fre-1 == 0){
                 dis--;

            }
            start++;
        }
        ans = Math.max(ans,i-start+1);
    }
    return ans;
 }



 

}