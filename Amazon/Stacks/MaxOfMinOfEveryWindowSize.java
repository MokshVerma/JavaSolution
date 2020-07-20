package AmazonGFG.Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxOfMinOfEveryWindowSize {

    static int[] printMaxOfMin(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

//        left[n]=-1;/
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if(stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

//        right[n]=n;
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if(stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();

            stack.push(i);
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int len = right[i]-left[i]-1;
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }

        for(int i=n-2; i>=0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            int[] res = printMaxOfMin(arr, n);

            for (int i = 0; i < n; i++)
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }

}
