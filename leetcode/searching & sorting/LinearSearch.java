
public class LinearSearch {
    
public static boolean Linearsearch(int [] arr , int data){

    for(int i =0; i<arr.length; i++){
        if(arr[i] ==  data){
            // System.out.println("found");
            return true;
           
        }
    }
    // System.out.println("not found");
    return false;
    

}


 public static void main(String[] args) {
        int [] arr ={2,4,8,1,5,0,88,98,66};
            int data= 97;
   
            System.out.println(Linearsearch(arr, data));
      
    }
}
