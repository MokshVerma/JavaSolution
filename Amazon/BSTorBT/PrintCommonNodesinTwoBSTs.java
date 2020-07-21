package Amazon.BSTorBT;

import java.util.ArrayList;
import java.util.Stack;

public class PrintCommonNodesinTwoBSTs {

    class Node{
        int data;
        Node left,right;
        Node (int d){
            data=d;
            left=right=null;
        }
    }

    public static ArrayList<Integer> printCommon(Node root1, Node root2) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Node curr = root1;

        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list1.add(curr.data);

            curr = curr.right;
        }

        curr = root2;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list2.add(curr.data);

            curr = curr.right;
        }
        int i=0, j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i).equals(list2.get(j))){
                list.add(list1.get(i));
                i++; j++;
            } else if(list1.get(i)<list2.get(j)){
                i++;
            } else{
                j++;
            }
        }
        return list;
    }

}
