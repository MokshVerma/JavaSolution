package Amazon.BSTorBT;

public class MinAbsoluteDifferenceBST {

    class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static int maxDiff(Node  root, int k){
        Node curr = root;
        int min = Integer.MAX_VALUE;
        while(curr!=null){
            min = Math.min(min, Math.abs(k-curr.data));
            if(curr.data<k){
                // prev = curr;
                curr = curr.right;
            } else if(curr.data>k){
                // prev = curr;
                curr = curr.left;
            } else{
                return 0;
            }
        }

        return min;
    }

}
