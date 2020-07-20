package Amazon.Sorting;

public class inversionCount {

    static long count=0;
    // arr[]: Input Array
    // N : Size of the Array arr[]

    static void swap(long[] arr, int a, int b){
        long t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    static void quickSort(long[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static int partition(long[] arr, int low, int high){
        // Your code here
        long p = arr[low];
        int i = low+1;
        for(int j=low+1; j<=high; j++){
            if(arr[j] < p){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i-1);
        count+=Math.abs(low-(i-1));
        return i-1;
    }

    static long inversionCount(long[] arr, long N){
        quickSort(arr, 0, (int) (N-1));
        return count;
    }
}
