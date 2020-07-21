package Amazon.BSTorBT;

import java.util.Stack;

public class KthLargestElementInBST {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int k){
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int i=0;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.right;
            }
            k--;
            curr = stack.pop();
            if(k==0){
                i=curr.data;
            }
            curr = curr.left;
        }
        return i;
    }

}
