import java.util.ArrayList;
import java.util.Arrays;

class Rec{
    
    public static void printInc(int a , int b){
        if(a == b){
            System.out.println(a);
            return;
        }

        printInc(a, b-1);
        System.out.println(b);
    }



       
    public static void printdec(int a , int b){
        if(a == b){
            System.out.println(a);
            return;
        }
        System.out.println(b);
        printdec(a, b-1);
       
    }

    public static void IncDec(int a, int b){

        if(a > b){
            
            return;
        }

        System.out.println(a);
        IncDec(a +1, b);
        System.out.println(a);

    }
    
    public static void printOddEven(int a ,int b){
        if(a > b) return;


        if(a % 2 == 0) System.out.println(a);
        printOddEven(a+1,b);
        if(a % 2 != 0) System.out.println(a);
    }

    public static int fact(int n){
        return n == 0 ? 1 : fact(n-1)*n;
    }

    public static int power(int a ,int b){
        return b == 0 ? 1 : power(a, b-1)*a;
    }


    // arrays....
    public static int maxImum (int [] arr, int idx){
        
        if(idx == arr.length-1) return arr[idx];

        int maxArray = maxImum(arr, idx+1);
        if(maxArray > arr[idx]){
            return maxArray;
        }else{
            return arr[idx];
        }

    }
    public static int minimum (int [] arr, int idx){
        
        if(idx == arr.length-1) return arr[idx];

        int maxArray = maxImum(arr, idx+1);
        if(maxArray < arr[idx]){
            return maxArray;
        }else{
            return arr[idx];
        }

    }

    public static boolean find(int [] arr, int idx , int data){

    if(idx == arr.length) return false;

    return arr[idx] ==  data || find(arr,idx+1,data);



    }

    public static int firstIdx (int [] arr, int idx , int data){

        if(idx == arr.length)return -1;

        return arr[idx] ==  data ? idx : firstIdx(arr, idx + 1, data);

    }
    public static int[] allIndex(int[] arr, int idx, int data, int count) {
        if (idx == arr.length) {
            int[] base = new int[count];
            return base;
        }

        if (arr[idx] == data)
            count++;
        int[] ans = allIndex(arr, idx + 1, data, count);
        if (arr[idx] == data)
            ans[count - 1] = idx;

        return ans;
    }

    public static ArrayList<String> subSeq(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = subSeq(str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>(recAns);
        for (String s : recAns)
            myAns.add(str.charAt(idx) + s);
        
        return myAns;
    }

    // public static ArrayList<String> getKpc(String str){


    // }
    
    
    public static void main (String[] args){

//    printInc(5, 9);     
//    printdec(5,9);

//    IncDec(5,9);
// // printOddEven(5,9);
//             System.out.println(fact(5));
            // System.out.println(power(2,5));
            int [] arr ={2,4,5,2,8,8,8,6,100,200,11};

            // System.out.println(minimum(arr,0));
            // System.out.println(find(arr,0,222));
            System.out.println(firstIdx(arr,0,9));
    }
}