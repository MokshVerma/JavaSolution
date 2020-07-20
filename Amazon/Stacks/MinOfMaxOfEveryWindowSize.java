package AmazonGFG.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MinOfMaxOfEveryWindowSize {

    static int[] printMinOfMax(int[] arr, int n){
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i])
                stack.pop();
            if(stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i])
                stack.pop();
            if(stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();
            stack.push(i);
        }



        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            int len = right[i]-left[i]-1;
            ans[len-1] = Math.min(ans[len-1], arr[i]);
        }

        System.out.println(Arrays.toString(ans));

        for(int i=n-2; i>=0; i--){
            ans[i] = Math.min(ans[i], ans[i+1]);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,50,10,70,30};
        System.out.println(Arrays.toString(printMinOfMax(arr, 7)));
    }
}
