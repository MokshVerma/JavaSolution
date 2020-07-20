package Amazon.Stacks;

import java.util.Arrays;
import java.util.Stack;
/*
Given an array A[] of size N having distinct elements, the task is to find the next
greater element for each element of the array in order of their appearance in the
array. If no such element exists, output -1.

Input
2
4
1 3 2 4
5
6 8 0 1 3
Output
3 4 4 -1
8 -1 1 3 -1



*/

public class NextLargerElement {

    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        Stack<Long> stack = new Stack<>();
        long[] res = new long[n];
        res[n-1] = -1;
        stack.push(arr[n-1]);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                res[i] = -1;
            else
                res[i] = stack.peek();

            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(nextLargerElement(arr, 4)));
    }

}
