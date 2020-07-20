package AmazonGFG.Queues;

import java.util.Queue;

public class ReverseQueue {

        public Queue<Integer> rev(Queue<Integer> q){
            if(!q.isEmpty()){
                int t = q.remove();
                if(!q.isEmpty()){
                    rev(q);
                }
                q.add(t);
            }
            return q;
        }

}
