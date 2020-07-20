package Amazon.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class TheCelebrityProblem {

    static int getId(int M[][], int n){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            stack.push(i);
        }
        int t=0;
        while(stack.size()>1){
            int i = stack.pop();
            int j = stack.pop();
            if(M[i][j]==1){
                stack.push(j);
            } else {
                stack.push(i);
            }
        }
        t = stack.pop();
        for(int k=0; k<n; k++){
            if(k!=t && (M[t][k]==1 || M[k][t]!=1)){
                return -1;
            }
        }
        return t;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(getId(M,N));
            t--;
        }
    }


}
