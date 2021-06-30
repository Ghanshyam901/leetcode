public class StringToArr {
    public static void main(String[] args) {
        // String str ="hello world";
        String str2 ="hello sk";

        // char [] ch = new char[str.length()];

        // for(int i =0; i<str.length(); i++){
        //     ch[i] = str.charAt(i);
        // }

        // for(char c : ch){
        //     System.out.println(c);
// ===================================================================================================================

            char [] ch1 = str2.toCharArray();
            for(char ch2 : ch1){
                    System.out.println(ch2);
            }                

        
        }
    }

