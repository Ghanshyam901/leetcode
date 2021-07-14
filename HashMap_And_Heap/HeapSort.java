import java.util.Arrays;
public class HeapSort {
    

    private void swap(int i, int j) { // O(1)
        int temp = i;
        i=j;
        // this.arr.set(j, temp);
        j = temp;
    }

public boolean compareTo(int[] arr, boolean isIncreasing , int i , int j){
    if(isIncreasing){
        return arr[i] > arr[j];

    }else{
        return arr[i]< arr[j];
    }
}

void downHeapify(int[] arr, boolean isIncreasing, int pi, int li){
    int maxIdx = pi;
    int lci = 2*pi+1;
    int rci = 2*pi+2;

    if (lci <= li && compareTo(arr, isIncreasing, lci, maxIdx))
        maxIdx = lci;
    if (rci <= li && compareTo(arr, isIncreasing, rci, maxIdx))
        maxIdx = rci;

        if(pi != maxIdx){
            swap(pi,maxIdx);

            downHeapify(arr,isIncreasing,pi,li);

        }
}
void heapSort(int []arr, boolean isIncreasing)
{
    int li = arr.length - 1;
    for (int i = li; i >= 0; i--)
    downHeapify(arr, isIncreasing, i, li);

    while (li >= 0)
    {
        swap(arr[0], arr[li--]);
        downHeapify(arr, isIncreasing, 0, li);
    }
}


    public static void main(String[] args) {
        
   int[] arr = {10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13};
    heapSort(arr, true);

    for (int ele : arr)
        System.out.println(ele +" ");
    }
}
