package Amazon.BSTorBT;

import java.util.Stack;

public class InorderSuccessorInBST {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public Node inorderSuccessor(Node root,Node x){
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(curr.data>x.data)
                return curr;

            curr = curr.right;
        }
        return null;
    }

}
