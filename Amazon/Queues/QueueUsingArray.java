package AmazonGFG.Queues;

public class QueueUsingArray {

    class MyQueue {

        int front, rear;
        int arr[] = new int[100005];

        MyQueue(){
            front=0;
            rear=0;
        }

        /* The method push to push element
           into the queue */
        void push(int x) {
            if(rear<arr.length)
                arr[rear++] = x;
        }

        /* The method pop which return the
           element popped out of the queue*/
        int pop() {
            if(front<arr.length && rear!=front)
                return arr[front++];
            return -1;
        }
    }

}
