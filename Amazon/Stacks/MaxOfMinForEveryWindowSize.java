package Amazon.Stacks;

import java.util.Stack;

public class MaxOfMinForEveryWindowSize {


    static int[] printMaxOfMin(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = -1;
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        right[n-1] = n;
        stack.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();
            stack.push(i);
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++){
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(arr[len], arr[i]);
        }

        for(int i=n-1; i>=1; i++){
            res[i] = Math.max(res[i+1], res[i]);
        }

        return res;
    }

}
