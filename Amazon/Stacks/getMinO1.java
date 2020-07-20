package Amazon.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class getMinO1 {

    static class GfG {
        int minEle;
        Stack<Integer> s = new Stack<>();

        /*returns min element from stack*/
        int getMin(){
            if(s.isEmpty()){
                return -1;
            }
            return minEle;
        }

        /*returns popped element from stack*/
        int pop(){
            if(s.isEmpty())
                return -1;
            int t=0;
            if(s.peek()==minEle){
                t=s.pop();
                minEle = s.pop();
            } else{
                t=s.pop();
            }
            return t;
        }

        /*push element x into the stack*/
        void push(int x){
            if(s.isEmpty()){
                s.push(x);
                s.push(x);
                minEle = x;
            } else{
                if(x<=minEle){
                    s.push(minEle);
                    s.push(x);
                    minEle = x;
                } else{
                    s.push(x);
                }
            }
        }
    }

    static class GetMin{
        Stack<Integer> stack = new Stack<>();
        int min;


        public void push(int x){
            if(stack.isEmpty()){
                stack.push(x);
                min = x;
            } else{
                if(x<min){
                    stack.push(2*x - min);
                    min = x;
                } else {
                    stack.push(x);
                }
            }
        }

        public int pop(){
            if(stack.isEmpty())
                return -1;
            if(stack.peek()<min){
                int temp = min;
                min = 2*min-stack.pop();
                return temp;
            } else{
                return stack.pop();
            }
        }

        public int getMin(){
            if(stack.size()==1){
                return stack.peek();
            } else if(stack.isEmpty())
                return -1;
            else {
                return min;
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int q = sc.nextInt();
            GfG g = new GfG();
            while(q>0)
            {
                int qt = sc.nextInt();

                if(qt == 1)
                {
                    int att = sc.nextInt();
                    g.push(att);
                    //System.out.println(att);
                }
                else if(qt == 2)
                {
                    System.out.print(g.pop()+" ");
                }
                else if(qt == 3)
                {
                    System.out.print(g.getMin()+" ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }

}
