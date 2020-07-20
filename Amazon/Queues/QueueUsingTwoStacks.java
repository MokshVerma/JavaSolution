package AmazonGFG.Queues;

import java.util.Stack;

public class QueueUsingTwoStacks {

    class StackQueue {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        /* The method insert to push element
           into the queue */
        void Push(int x){
            s1.push(x);
        }


        /* The method remove which return the
          element popped out of the queue*/
        int Pop(){
            if(s2.isEmpty()){
                if(s1.isEmpty())
                    return -1;
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }

}
