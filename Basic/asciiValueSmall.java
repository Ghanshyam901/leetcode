public class asciiValueSmall{
    public static void main(String[] args) {
        
       char SmallChar= 'a';

       for(int i = 'a'; i<='z'; i++){
           System.out.println(SmallChar +" :" + i);
           SmallChar++;
       }
    }
}