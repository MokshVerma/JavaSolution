package Amazon.Sorting;

import java.util.Arrays;

public class Sort012 {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void segragate012(int arr[], int n){
        int i=0, j=n-1;
        for(int k=0; k<=j; k++){
            if(arr[k]==0){
                swap(arr, i, k);
                i++;
            } else if(arr[k]==2){
                swap(arr, j, k);
                j--;
//                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,2,0,1,2,1,2,0,0,1,2};
        segragate012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


}
