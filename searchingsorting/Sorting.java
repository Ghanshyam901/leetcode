

public class Sorting{

    // leecode 34
    public int[] searchRange(int[] nums, int target) {
         
        return new int[] {first(nums,target),last(nums,target)};
    }
   
   public int first(int[] arr, int data) {
     int si = 0,ei = arr.length - 1;
       while(si <= ei){
           int mid = (si + ei) / 2;
           if(arr[mid] == data){
               if(mid - 1 >= 0 && arr[mid - 1] == data) ei = mid - 1;
               else return mid;
           }else if(arr[mid] < data) si = mid + 1;
           else ei = mid - 1;
       }

       return -1;
   }

public int last(int[] arr, int data) {
     int si = 0,ei = arr.length - 1;
       while(si <= ei){
           int mid = (si + ei) / 2;
           if(arr[mid] == data){
               if(mid + 1 < arr.length && arr[mid + 1] == data) si = mid + 1;
               else return mid;
           }else if(arr[mid] < data) si = mid + 1;
           else ei = mid - 1;
       }

       return -1;
   }


   public static int searchindex(int [] arr, int data){

      

        int si =0;
        int ei = arr.length;

        

        while(si <=ei){

            int mid = si +ei/2;

            if(arr[mid] < data){
                si = mid+1;

            }else{
                ei = mid-1;
            }

            
        }
        return si;

   }
   public static int insertidx(int [] arr, int data){

      

    int si =0;
    int ei = arr.length;

    

    while(si <=ei){

        int mid = si +ei/2;

        if(arr[mid] <= data){
            si = mid+1;

        }else{
            ei = mid-1;
        }

        
    }

    // int first = si;
    // int last= si-1;
    // return (last >=0 && arr[last] ==  data) ? last: first;
    return (si - 1 >= 0 && arr[si-1] ==  data) ? si - 1: si;

}

public static int nearestOne(int []arr, int  data){
    
    int si =0;
    int ei = arr.length;

    

    while(si <=ei){

        int mid = si +ei/2;

        if(arr[mid] <= data){
            si = mid+1;

        }else{
            ei = mid-1;
        }

        
    }
    int first = si;
    int last= ei+1;
    return (last >=0 && arr[last] ==  data) ? last: first;
    
}



    public static void main (String [] args){

        int [] arr = {1,2,3,4,5,6,9,10};
        int data = 7;

        System.out.println(searchRange(arr,data));

    }




    
}