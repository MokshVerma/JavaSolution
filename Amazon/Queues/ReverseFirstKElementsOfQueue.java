package AmazonGFG.Queues;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k){
        Stack<Integer> stack = new Stack<>();
        while(k-->0){
            stack.push(q.remove());
        }
        k = stack.size();
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        k = q.size()-k;
        while(k-->0){
            q.add(q.remove());
        }
        return q;
    }

}
