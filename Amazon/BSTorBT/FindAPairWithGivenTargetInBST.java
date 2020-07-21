package Amazon.BSTorBT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindAPairWithGivenTargetInBST {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public boolean pairExists(Node root, Node temp, int target){
        Node curr = root;
        while(curr!=null){
            if(curr.data==target && curr!=temp){
                return true;
            } else if(curr.data<=target){
                curr = curr.right;
            } else{
                curr = curr.left;
            }
        }
        return false;
    }

    public int isPairPresent1(Node root, int target){
        Queue<Node> queue = new LinkedList<>();
        Node curr = root;queue.add(curr);
        while(!queue.isEmpty()){
            curr = queue.remove();
            if(curr.left!=null){
                queue.add(curr.left);
            } if(curr.right!=null){
                queue.add(curr.right);
            }
            if(pairExists(root, curr, target-curr.data))
                return 1;

        }
        return 0;
    }


}
