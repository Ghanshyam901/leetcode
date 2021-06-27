public class binarySearch {
    

    public static boolean binarySearch_(int []arr,int data){
       
            //  Arrays.sort(arr);

            int lo =0;
            int hi = arr.length-1;

            while(lo <= hi){
                int mid = (lo+hi)/2;

                if(arr[mid] ==  data){
                    return true;
                }else if(arr[mid] > data){
                    hi = mid-1;

                }else{
                    lo = mid+1;
                }
            }

            return false;
    }

    public static void main(String[] args) {
        

        int [] arr = {1,2,3,4,5,7,88,99};
        int data = 99;

            System.out.println(binarySearch_(arr,data));
      

    }
}
