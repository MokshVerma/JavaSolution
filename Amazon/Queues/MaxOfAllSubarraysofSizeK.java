package AmazonGFG.Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarraysofSizeK {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k){
        Deque<Integer> dq= new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int i=0, j=0, max;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.removeLast(); // Remove from rear
            // Add new element at rear of queue
            dq.addLast(i);
        }
        for(; i<n; i++){
            list.add(dq.peek());
            while(!dq.isEmpty() && dq.peekFirst()<=i-k)
                dq.removeFirst();
            while (!dq.isEmpty() && dq.peekLast()<=arr[i])
                dq.removeLast();
            dq.addLast(i);
        }
        list.add(dq.peek());
        return list;
    }

}
