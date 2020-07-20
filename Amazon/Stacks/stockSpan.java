package Amazon.Stacks;

/*The stock span problem is a financial problem where we have a series of n daily
price quotes for a stock and we need to calculate the span of stock’s price for
all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number
of consecutive days just before the given day, for which the price of the stock
on the current day is less than or equal to its price on the given day.
 */
 /*
        For example, if an array of 7 days prices is given as
        {100, 80, 60, 70, 60, 75, 85},
        then the span values for corresponding 7 days are
        {1, 1, 1, 2, 1, 4, 6}. /*
  */

import java.util.Stack;

public class stockSpan {

    public static int[] calculateSpan(int n, int[] prices){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        result[0] = 1;
        stack.push(0);
        for(int i=1; i<n; i++){
            if(prices[i-1]<=prices[i]){
                while(!stack.isEmpty() && prices[stack.peek()]<=prices[i]){
                    result[i] += result[stack.pop()];
                }
                stack.push(i);
                result[i]++;
            } else{
                result[i] = 1;
            }
        }
        return result;
    }
}
