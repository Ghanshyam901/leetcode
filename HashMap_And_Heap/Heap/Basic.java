package Heap;

public class Basic {
    
    public static int HeightOfTree(int [] arr, int idx){
        if(idx >= arr.length) return -1;

        int lh = HeightOfTree(arr, 2*idx+1);
        int rh = HeightOfTree(arr, 2*idx+2);

        return Math.max(lh, rh)+1;
    }
    public static void main(String[] args) {
        
    }
}
