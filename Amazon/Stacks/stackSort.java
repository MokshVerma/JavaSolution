package Amazon.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class stackSort {

    public static Stack<Integer> sortIterative(Stack<Integer> s)
    {
        if(s == null || s.isEmpty()) {
            return s;
        }

        Stack<Integer> s1 = new Stack<>();
        Integer topS = null;
        while (!s.isEmpty()) {
            topS = s.pop();
            while(!s1.isEmpty() && topS < s1.peek()) {
                s.push(s1.pop());
            }
            s1.push(topS);
        }

        return s1;
    }

    public static Stack<Integer> sort(Stack<Integer> s){
        if(!s.isEmpty()){
            int temp = s.pop();
            sort(s);
            sortedInsert(s, temp);
        }
        return s;
    }

    public static void sortedInsert(Stack<Integer> s, int temp){
        if(s.empty() || s.peek()<=temp)
            s.push(temp);
        else {
            int t = s.pop();
            sortedInsert(s, temp);
            s.push(t);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0)
                s.push(sc.nextInt());
            Stack<Integer> a = sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
        }
    }
}
