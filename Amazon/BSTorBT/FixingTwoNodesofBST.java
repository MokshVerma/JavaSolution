package Amazon.BSTorBT;

import java.util.ArrayList;
import java.util.Stack;

public class FixingTwoNodesofBST {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public Node correctBST(Node root){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.data);

            curr = curr.right;
        }
//        Integer n1=null, n2 = null;
//        int i1 = 0;
        int n1 = -1, n2 = -1;
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)){
                n1 = list.get(i);
                break;
            }
        }
        for(int i=list.size()-1; i>=1; i--){
            if(list.get(i)<list.get(i-1)){
                n2 = list.get(i);
                break;
            }
        }

//        if(n2==null){
//            n2 = list.get(i1+1);
//        }

        System.out.println(n1 + " " + n2);

        curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(curr.data==n1){
                curr.data = n2;
            } else if(curr.data == n2)
                curr.data = n1;

            curr = curr.right;
        }

        return root;
    }
}
