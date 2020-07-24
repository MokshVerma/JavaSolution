package AmazonGFG.BSTorBT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class inOrderTraversal {

    static class Node{
        int val;
        Node left=null, right=null;

        public Node(int val){
            this.val = val;
        }
    }

    public static List<Integer> iterative(Node root){
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);

            curr = curr.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println(String.valueOf(iterative(root)));
    }

}
