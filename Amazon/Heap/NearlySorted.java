package AmazonGFG.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {

    //Given an array of n elements, where each element is at most k away
    // from its target position, you need to sort the array optimally.

    ArrayList<Integer> nearlySorted(int arr[], int n, int k){
        // your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=k && i<n; i++){
            minHeap.add(arr[i]);
        }

        for(int i=k+1; i<n; i++){
            list.add(minHeap.remove());
            minHeap.add(arr[i]);
        }
        while(!minHeap.isEmpty()){
            list.add(minHeap.remove());
        }
        return list;
    }
}
